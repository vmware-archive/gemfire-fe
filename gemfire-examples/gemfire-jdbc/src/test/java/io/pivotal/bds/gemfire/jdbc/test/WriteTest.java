package io.pivotal.bds.gemfire.jdbc.test;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.ClientRegionFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.apache.geode.pdx.PdxInstance;
import org.apache.geode.pdx.PdxInstanceFactory;

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
