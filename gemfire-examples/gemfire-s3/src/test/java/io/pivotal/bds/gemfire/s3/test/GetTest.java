package io.pivotal.bds.gemfire.s3.test;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.cache.client.ClientRegionFactory;
import com.gemstone.gemfire.cache.client.ClientRegionShortcut;
import com.gemstone.gemfire.pdx.PdxInstance;

public class GetTest {

    public static void main(String[] args) throws Exception {
        ClientCacheFactory ccf = new ClientCacheFactory();

        ccf.addPoolLocator("localhost", 10334);
        ccf.setPdxReadSerialized(true);

        ClientCache cc = ccf.create();

        Region<String, PdxInstance> test1 = createRegion(cc, "test1");

        for (int i = 0; i < 10; ++i) {
            String id = "id-" + i;

            PdxInstance value = test1.get(id);
            System.out.println(id + " = " + value);
        }
    }

    private static Region<String, PdxInstance> createRegion(ClientCache cc, String name) {
        ClientRegionFactory<String, PdxInstance> crf = cc.createClientRegionFactory(ClientRegionShortcut.PROXY);
        return crf.create(name);
    }
}
