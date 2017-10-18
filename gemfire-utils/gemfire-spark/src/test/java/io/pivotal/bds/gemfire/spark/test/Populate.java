package io.pivotal.bds.gemfire.spark.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.Cache;
import org.apache.geode.cache.CacheFactory;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.RegionFactory;
import org.apache.geode.cache.RegionShortcut;

public class Populate {

	private static final Logger LOG = LoggerFactory.getLogger(Populate.class);

	public static void main(String[] args) throws Exception {
		LOG.info("Creating cache");
		Cache cache = new CacheFactory().create();
		RegionFactory<String, String> regionFactory = cache.createRegionFactory(RegionShortcut.REPLICATE);
		Region<String, String> region = regionFactory.create("test");

		LOG.info("Adding data");
		int count = 0;
		while (true) {
			++count;
			region.put("key-" + count, "value-" + count);
			Thread.sleep(1000L);
		}
	}
}
