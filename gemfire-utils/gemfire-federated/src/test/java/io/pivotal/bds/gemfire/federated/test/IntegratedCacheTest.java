package io.pivotal.bds.gemfire.federated.test;

import org.apache.geode.cache.Cache;
import org.apache.geode.cache.CacheFactory;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;

public class IntegratedCacheTest {

	public static void main(String[] args) throws Exception {
		Cache cache = new CacheFactory().create();
		
		ClientCache client = new ClientCacheFactory().create();
	}
}
