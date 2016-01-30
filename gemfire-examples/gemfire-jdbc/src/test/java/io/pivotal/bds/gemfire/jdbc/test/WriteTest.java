package io.pivotal.bds.gemfire.jdbc.test;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.cache.client.ClientRegionFactory;
import com.gemstone.gemfire.cache.client.ClientRegionShortcut;
import com.gemstone.gemfire.pdx.PdxInstance;
import com.gemstone.gemfire.pdx.PdxInstanceFactory;

public class WriteTest {

    public static void main(String[] args) throws Exception {
        ClientCacheFactory ccf = new ClientCacheFactory();

        ccf.addPoolLocator("localhost", 10334);
        ccf.setPdxReadSerialized(false);

        ClientCache cc = ccf.create();

        ClientRegionFactory<String, PdxInstance> crf = cc.createClientRegionFactory(ClientRegionShortcut.PROXY);
        Region<String, PdxInstance> r = crf.create("test");

        for (int i = 19; i < 30; ++i) {
            PdxInstanceFactory pif = cc.createPdxInstanceFactory("Test");

            pif.writeString("id", "id-" + i);
            pif.writeString("name", "object " + i);
            pif.writeInt("count", i);

            PdxInstance inst = pif.create();

            r.put("id-" + i, inst);
        }
    }
}
