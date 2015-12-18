package io.pivotal.bds.gemfire.geo.test;

import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.cache.client.Pool;
import com.gemstone.gemfire.cache.execute.FunctionService;
import com.gemstone.gemfire.pdx.ReflectionBasedAutoSerializer;

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
