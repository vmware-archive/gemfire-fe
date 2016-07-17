package io.pivotal.bds.gemfire.keyfw.generator;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.CacheFactory;
import com.gemstone.gemfire.cache.CacheLoader;
import com.gemstone.gemfire.cache.CacheLoaderException;
import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.LoaderHelper;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.distributed.DistributedLockService;
import com.gemstone.gemfire.distributed.DistributedSystem;

public class IntegerIDPrefixCacheLoader implements CacheLoader<Integer, Integer>, Declarable {

	private DistributedSystem system;
	private Region<Integer, Integer> region;

	private static final String serviceName = "PrefixService";
	private static final String objectName = "Prefix";
	private static final long waitTime = 1000L;
	private static final long leaseTime = 1000L;

	private static final Logger LOG = LoggerFactory.getLogger(IntegerIDPrefixCacheLoader.class);

	public IntegerIDPrefixCacheLoader() {
	}

	public IntegerIDPrefixCacheLoader(DistributedSystem system, Region<Integer, Integer> region) {
		this.system = system;
		this.region = region;
	}

	@Override
	public void close() {
	}

	@Override
	public void init(Properties props) {
		String regionName = System.getProperty("prefix-region-name", "DistIDPrefix");
		regionName = props.getProperty("prefixRegionName", regionName);
		LOG.info("init: props={}, regionName={}", props, regionName);

		Cache c = CacheFactory.getAnyInstance();
		region = c.getRegion(regionName);
		system = c.getDistributedSystem();
	}

	@Override
	public Integer load(LoaderHelper<Integer, Integer> helper) throws CacheLoaderException {
		LOG.info("getting prefix");

		DistributedLockService dls = DistributedLockService.create(serviceName, system);
		boolean success = dls.lock(objectName, waitTime, leaseTime);

		if (!success) {
			throw new IllegalStateException("cannot acquire lock for setting prefix");
		}

		try {
			int prefix = region.get(1);
			region.put(1, prefix + 1);
			LOG.info("setting prefix to {}", prefix);
			return prefix;
		} finally {
			dls.unlock(objectName);
		}
	}

}
