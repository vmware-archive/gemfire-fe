package io.pivotal.bds.gemfire.federated.test;

import java.util.HashSet;
import java.util.Set;

import org.apache.geode.cache.Operation;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.ClientRegionFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.apache.geode.cache.execute.FunctionService;

import io.pivotal.bds.gemfire.federated.BridgeFunction;

public class TestClient {

	public static void main(String[] args) throws Exception {
		System.out.println("creating ClientCacheFactory");
		ClientCacheFactory ccf = new ClientCacheFactory();
		ccf.addPoolLocator("localhost", 10334);
		
		System.out.println("creating ClientCache");
		ClientCache cc = ccf.create();

		System.out.println("creating Region");
		ClientRegionFactory<String, String> crf = cc.createClientRegionFactory(ClientRegionShortcut.PROXY);
		crf.setPoolName(cc.getDefaultPool().getName());
		Region<String, String> r = crf.create("test");

		System.out.println("calling function");
		Object[] data = new Object[] {Operation.CREATE,"test","key1","value1"};
		
		Set<String> filter = new HashSet<>();
		filter.add("key1");
		
		FunctionService.onRegion(r).withArgs(data).withFilter(filter).execute(BridgeFunction.class.getSimpleName());
		System.out.println("done");
	}
}
