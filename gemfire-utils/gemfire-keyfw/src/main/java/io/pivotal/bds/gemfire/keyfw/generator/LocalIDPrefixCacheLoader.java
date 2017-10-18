package io.pivotal.bds.gemfire.keyfw.generator;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.Cache;
import org.apache.geode.cache.CacheFactory;
import org.apache.geode.cache.CacheLoader;
import org.apache.geode.cache.CacheLoaderException;
import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.LoaderHelper;
import org.apache.geode.cache.Region;
import org.apache.geode.distributed.DistributedLockService;
import org.apache.geode.distributed.DistributedSystem;

public class LocalIDPrefixCacheLoader implements CacheLoader<Integer, Long>, Declarable {

	private DistributedSystem system;
	private Region<Integer, Long> region;

	private static final String serviceName = "PrefixService";
	private static final String objectName = "Prefix";
	private static final long waitTime = 1000L;
	private static final long leaseTime = 1000L;

	private static final Logger LOG = LoggerFactory.getLogger(LocalIDPrefixCacheLoader.class);

	public LocalIDPrefixCacheLoader() {
	}

	public LocalIDPrefixCacheLoader(DistributedSystem system, Region<Integer, Long> region) {
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
	public Long load(LoaderHelper<Integer, Long> helper) throws CacheLoaderException {
		LOG.info("getting prefix");

		DistributedLockService dls = DistributedLockService.create(serviceName, system);
		boolean success = dls.lock(objectName, waitTime, leaseTime);

		if (!success) {
			throw new IllegalStateException("cannot acquire lock for setting prefix");
		}

		try {
			long prefix = region.get(1);
			region.put(1, prefix + 1L);
			LOG.info("setting prefix to {}", prefix);
			return prefix;
		} finally {
			dls.unlock(objectName);
		}
	}

}
