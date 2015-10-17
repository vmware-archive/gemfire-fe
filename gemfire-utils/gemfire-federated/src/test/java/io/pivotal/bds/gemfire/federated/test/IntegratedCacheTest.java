package io.pivotal.bds.gemfire.federated.test;

import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.CacheFactory;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;

public class IntegratedCacheTest {

	public static void main(String[] args) throws Exception {
		Cache cache = new CacheFactory().create();
		
		ClientCache client = new ClientCacheFactory().create();
	}
}
