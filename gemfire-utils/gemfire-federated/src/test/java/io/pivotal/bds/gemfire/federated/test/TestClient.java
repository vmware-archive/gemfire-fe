package io.pivotal.bds.gemfire.federated.test;

import java.util.HashSet;
import java.util.Set;

import com.gemstone.gemfire.cache.Operation;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.cache.client.ClientRegionFactory;
import com.gemstone.gemfire.cache.client.ClientRegionShortcut;
import com.gemstone.gemfire.cache.execute.FunctionService;

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
