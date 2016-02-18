package io.pivotal.bds.gemfire.r.server.test;

import java.util.Date;
import java.util.UUID;

import org.json.JSONObject;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.cache.client.ClientRegionFactory;
import com.gemstone.gemfire.cache.client.ClientRegionShortcut;
import com.gemstone.gemfire.pdx.JSONFormatter;
import com.gemstone.gemfire.pdx.PdxInstance;

public class Prediction {

    public static void main(String[] args) throws Exception {
        ClientCacheFactory ccf = new ClientCacheFactory();

        ccf.addPoolLocator("192.168.0.110", 10334);
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
