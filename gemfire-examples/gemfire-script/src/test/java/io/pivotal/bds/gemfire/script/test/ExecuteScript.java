package io.pivotal.bds.gemfire.script.test;

import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.cache.client.Pool;
import com.gemstone.gemfire.cache.execute.FunctionService;

public class ExecuteScript {

    private static final String script = "System.out.println(\"Hello World!\")";

    public static void main(String[] args) throws Exception {
        ClientCacheFactory ccf = new ClientCacheFactory();

        ccf.addPoolLocator("localhost", 10334);

        ClientCache cc = ccf.create();
        Pool pool = cc.getDefaultPool();

        FunctionService.onServer(pool).withArgs(script).execute("ScriptExecutionFunction");
    }
}
