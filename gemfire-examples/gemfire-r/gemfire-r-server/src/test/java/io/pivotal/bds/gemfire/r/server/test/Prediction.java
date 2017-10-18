package io.pivotal.bds.gemfire.r.server.test;

import java.util.Date;
import java.util.UUID;

import org.json.JSONObject;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.ClientRegionFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.apache.geode.pdx.JSONFormatter;
import org.apache.geode.pdx.PdxInstance;

public class Prediction {

    public static void main(String[] args) throws Exception {
        ClientCacheFactory ccf = new ClientCacheFactory();

        ccf.addPoolLocator("tdalsing-mbp.local", 10334);
        ccf.setPdxReadSerialized(true);

        ClientCache cc = ccf.create();

        ClientRegionFactory<String, PdxInstance> crf = cc.createClientRegionFactory(ClientRegionShortcut.PROXY);
        Region<String, PdxInstance> r = crf.create("testData");

        for (int i = 0; i < 10; ++i) {
            JSONObject jo = new JSONObject();

            String id = UUID.randomUUID().toString();
            jo.put("id", id);

            jo.put("date", new Date());

            put(jo, "temp", 12.0 + i);
            put(jo, "dewp", 7.0 + i);
            put(jo, "slp", 7.0 + i);
            put(jo, "stp", 7.0 + i);
            put(jo, "visib", 7.0 + i);
            put(jo, "wdsp", 7.0 + i);
            put(jo, "mxspd", 7.0 + i);
            put(jo, "gust", 7.0 + i);
            put(jo, "max", 7.0 + i);
            put(jo, "min", 7.0 + i);
            put(jo, "prcp", 7.0 + i);

            PdxInstance inst = JSONFormatter.fromJSON(jo.toString());
            r.put(id, inst);
        }
    }

    private static void put(JSONObject obj, String name, double val) {
        obj.put(name, val);
    }
}
