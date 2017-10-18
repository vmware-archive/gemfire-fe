package io.pivotal.bds.gemfire.federated.test;

import org.apache.geode.cache.Cache;
import org.apache.geode.cache.CacheFactory;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.RegionFactory;
import org.apache.geode.cache.RegionShortcut;
import org.apache.geode.cache.client.Pool;
import org.apache.geode.cache.client.PoolFactory;
import org.apache.geode.cache.client.PoolManager;
import org.apache.geode.cache.execute.FunctionService;
import org.apache.geode.cache.server.CacheServer;

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
