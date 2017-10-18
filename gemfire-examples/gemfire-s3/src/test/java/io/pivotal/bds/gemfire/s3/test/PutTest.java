package io.pivotal.bds.gemfire.s3.test;

import java.util.Date;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.ClientRegionFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.apache.geode.pdx.PdxInstance;
import org.apache.geode.pdx.PdxInstanceFactory;

public class PutTest {

    public static void main(String[] args) throws Exception {
        ClientCacheFactory ccf = new ClientCacheFactory();

        ccf.addPoolLocator("localhost", 10334);
        ccf.setPdxReadSerialized(true);

        ClientCache cc = ccf.create();

        Region<String, PdxInstance> test1 = createRegion(cc, "test1");

        for (int i = 0; i < 10; ++i) {
            String id = "id-" + i;

            PdxInstanceFactory pif = cc.createPdxInstanceFactory("Value");

            pif.writeString("name", "name-" + i);
            pif.writeInt("index", i);
            pif.writeDate("date", new Date());

            PdxInstance value = pif.create();
            test1.put(id, value);
        }
    }

    private static Region<String, PdxInstance> createRegion(ClientCache cc, String name) {
        ClientRegionFactory<String, PdxInstance> crf = cc.createClientRegionFactory(ClientRegionShortcut.PROXY);
        return crf.create(name);
    }
}
