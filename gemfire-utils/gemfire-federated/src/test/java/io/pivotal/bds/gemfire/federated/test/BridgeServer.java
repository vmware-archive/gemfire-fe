package io.pivotal.bds.gemfire.federated.test;

import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.CacheFactory;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.RegionFactory;
import com.gemstone.gemfire.cache.RegionShortcut;
import com.gemstone.gemfire.cache.client.Pool;
import com.gemstone.gemfire.cache.client.PoolFactory;
import com.gemstone.gemfire.cache.client.PoolManager;
import com.gemstone.gemfire.cache.execute.FunctionService;
import com.gemstone.gemfire.cache.server.CacheServer;

import io.pivotal.bds.gemfire.federated.BridgeFunction;

public class BridgeServer {

	public static void main(String[] args) throws Exception {
		System.out.println("creating CacheFactory");
		CacheFactory cf = new CacheFactory();

		cf.set("mcast-port", "0");
		cf.set("locators", "localhost[10334]");

		System.out.println("creating Cache");
		Cache c = cf.create();

		System.out.println("creating Pool");
		PoolFactory pf = PoolManager.createFactory();
		pf.addLocator("localhost", 10335);
		Pool pool = pf.create("federationPool");

		System.out.println("creating Region");
		RegionFactory<String, String> rf = c.createRegionFactory(RegionShortcut.PARTITION);
		Region<String, String> region = rf.create("test");
		
		FunctionService.registerFunction(new BridgeFunction(pool));

		System.out.println("creating CacheServer");
		CacheServer cs = c.addCacheServer();
		cs.setPort(40404);
		cs.start();

		System.out.println("done");

	}
}
