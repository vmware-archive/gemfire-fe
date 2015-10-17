package io.pivotal.bds.gemfire.script.test;

import java.util.HashSet;
import java.util.Set;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.cache.client.ClientRegionFactory;
import com.gemstone.gemfire.cache.client.ClientRegionShortcut;
import com.gemstone.gemfire.cache.execute.FunctionService;

import io.pivotal.bds.gemfire.script.data.ExecutionData;

public class ExecuteScript {

    public static void main(String[] args) throws Exception {
        ClientCacheFactory ccf = new ClientCacheFactory();

        ccf.addPoolLocator("localhost", 10334);

        ClientCache cc = ccf.create();

        ClientRegionFactory<String, String> rf = cc.createClientRegionFactory(ClientRegionShortcut.PROXY);
        Region<String, String> r = rf.create("Data");

        ExecutionData data = new ExecutionData("test", "whatever");
        Set<String> filter = new HashSet<>();

        for (int i = 0; i < 1000; ++i) {
            FunctionService.onRegion(r).withArgs(data).withFilter(filter).execute("ScriptExecutionFunction");
        }
    }
}
