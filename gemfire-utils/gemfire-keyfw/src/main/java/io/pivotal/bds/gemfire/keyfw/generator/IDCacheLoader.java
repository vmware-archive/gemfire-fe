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

public class IDCacheLoader implements CacheLoader<String, Long>, Declarable {

	private Region<Integer, Long> region;

	private static final Logger LOG = LoggerFactory.getLogger(IDCacheLoader.class);

	public IDCacheLoader() {
	}

	public IDCacheLoader(Region<Integer, Long> region) {
		this.region = region;
	}

	@Override
	public void init(Properties props) {
		String regionName = System.getProperty("local-prefix-region-name", "LocalIDPrefix");
		regionName = props.getProperty("localPrefixRegionName", regionName);
		LOG.info("init: props={}, regionName={}", props, regionName);

		Cache c = CacheFactory.getAnyInstance();
		region = c.getRegion(regionName);
	}

	@Override
	public void close() {
	}

	@Override
	public Long load(LoaderHelper<String, Long> helper) throws CacheLoaderException {
		Long l = region.get(1);
		l = l << 48;
		LOG.info("id={}", l);
		return l;
	}
}
