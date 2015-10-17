package io.pivotal.bds.gemfire.federated.test;

import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.CacheFactory;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.RegionFactory;
import com.gemstone.gemfire.cache.RegionShortcut;
import com.gemstone.gemfire.cache.execute.FunctionService;
import com.gemstone.gemfire.cache.server.CacheServer;

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
