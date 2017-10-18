package io.pivotal.bds.gemfire.geo.test;

import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.Pool;
import org.apache.geode.cache.execute.FunctionService;
import org.apache.geode.pdx.ReflectionBasedAutoSerializer;

public class PopulateRootBoundary {

    public static void main(String[] args) throws Exception {
        ClientCacheFactory ccf = new ClientCacheFactory();
        ccf.addPoolLocator("localhost", 10334);
        ccf.setPdxSerializer(new ReflectionBasedAutoSerializer("io.pivotal.bds.gemfire.geo.data.*,io.pivotal.bds.gemfire.key.*"));

        ClientCache cc = ccf.create();
        try {
            Pool pool = cc.getDefaultPool();
            FunctionService.onServer(pool).execute("PopulateBoundaryFunction");
        } finally {
            cc.close();
        }
    }
}
