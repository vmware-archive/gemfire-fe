package io.pivotal.bds.gemfire.localregion.test;

import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.Pool;
import org.apache.geode.cache.execute.FunctionService;
import org.apache.geode.pdx.ReflectionBasedAutoSerializer;

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
