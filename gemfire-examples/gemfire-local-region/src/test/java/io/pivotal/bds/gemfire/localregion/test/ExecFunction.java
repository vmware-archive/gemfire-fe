package io.pivotal.bds.gemfire.localregion.test;

import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.cache.client.Pool;
import com.gemstone.gemfire.cache.execute.FunctionService;
import com.gemstone.gemfire.pdx.ReflectionBasedAutoSerializer;

public class ExecFunction {

    public static void main(String[] args) throws Exception {
        ClientCacheFactory ccf = new ClientCacheFactory();

        ccf.setPdxReadSerialized(false);
        ccf.setPdxSerializer(
                new ReflectionBasedAutoSerializer("io.pivotal.bds.gemfire.localregion.data.*,io.pivotal.bds.gemfire.data.ecom.*"));
        ccf.addPoolLocator("localhost", 10334);

        ClientCache cc = ccf.create();
        Pool pool = cc.getDefaultPool();
        
        FunctionService.onServers(pool).execute("TestFunction");
        
        System.out.print("> ");
        System.in.read();
    }
}
