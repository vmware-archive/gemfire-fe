package io.pivotal.bds.gemfire.federated.test;

import org.apache.geode.cache.Cache;
import org.apache.geode.cache.CacheFactory;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.RegionFactory;
import org.apache.geode.cache.RegionShortcut;
import org.apache.geode.cache.execute.FunctionService;
import org.apache.geode.cache.server.CacheServer;

import io.pivotal.bds.gemfire.federated.FederationFunction;

public class FederationServer {

	public static void main(String[] args) throws Exception {
		System.out.println("creating CacheFactory");
		CacheFactory cf = new CacheFactory();
		
		cf.set("mcast-port", "0");
		cf.set("locators", "localhost[10335]");
		
		System.out.println("creating Cache");
		Cache c = cf.create();
		
		System.out.println("creating Region");
		RegionFactory<String, String> rf = c.createRegionFactory(RegionShortcut.PARTITION);
		Region<String, String> region = rf.create("test");
		
		System.out.println("registering FederationFunction");
		FunctionService.registerFunction(new FederationFunction(c));
		
		System.out.println("creating CacheServer");
		CacheServer cs = c.addCacheServer();
		cs.setPort(40405);
		cs.start();
		
		System.out.println("done");
	}
}
