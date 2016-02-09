package io.pivotal.bds.gemfire.kite.test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.cache.client.ClientRegionFactory;
import com.gemstone.gemfire.cache.client.ClientRegionShortcut;
import com.gemstone.gemfire.cache.client.Pool;
import com.gemstone.gemfire.pdx.PdxInstance;
import com.gemstone.gemfire.pdx.PdxInstanceFactory;

public class TestBucketed {

    public static void main(String[] args) throws Exception {
        System.out.println("creating cache");
        ClientCacheFactory ccf = new ClientCacheFactory();

        ccf.addPoolLocator("localhost", 10334);
        ccf.setPdxReadSerialized(true);
        ccf.setPoolReadTimeout(60000);

        ClientCache cc = ccf.create();
        Pool pool = cc.getDefaultPool();

        ClientRegionFactory<String, PdxInstance> crf = cc.createClientRegionFactory(ClientRegionShortcut.PROXY);
        crf.setPoolName(pool.getName());
        Region<String, PdxInstance> r = crf.create("test");

        System.out.println("creating keys");
        List<String> keys = new ArrayList<>();

        for (int i = 0; i < 10; ++i) {
            keys.add(UUID.randomUUID().toString());
        }

        System.out.println("putting data");
        for (String key : keys) {
            PdxInstanceFactory pif = cc.createPdxInstanceFactory("Test");
            pif.writeString("id", key);
            pif.writeString("desc", "value for key " + key);
            PdxInstance value = pif.create();
            r.put(key, value);
        }

        doGets(r, keys, "First");
        Thread.sleep(11000L);
        doGets(r, keys, "Second");
        Thread.sleep(11000L);
        doGets(r, keys, "Third");
        Thread.sleep(11000L);
        doGets(r, keys, "Fourth");
    }

    private static void doGets(Region<String, PdxInstance> r, List<String> keys, String label) {
        System.out.println("getting data: " + label);
        long total = 0L;
        int count = 0;

        for (String key : keys) {
            long start = System.nanoTime();

            PdxInstance inst = r.get(key);

            long end = System.nanoTime();
            long delta = (end - start) / 1000L;

            total += delta;
            ++count;

            if (inst == null) {
                System.out.println("value is null for key " + key);
            }
        }

        double avg = (double) total / (double) count;
        System.out.println(label + ": " + avg);
    }
}
