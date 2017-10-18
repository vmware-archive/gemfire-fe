package io.pivotal.bds.gemfire.r.server.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
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

public class PopulateTestData {

    public static void main(String[] args) throws Exception {
        ClientCacheFactory ccf = new ClientCacheFactory();

        ccf.addPoolLocator("localhost", 10334);
        ccf.setPdxReadSerialized(true);

        ClientCache cc = ccf.create();

        ClientRegionFactory<String, PdxInstance> crf = cc.createClientRegionFactory(ClientRegionShortcut.PROXY);
        Region<String, PdxInstance> r = crf.create("testData");

        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");

        FileReader fr = new FileReader("gsod2.txt");

        try {
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine(); // consume header

            while ((line = br.readLine()) != null) {
                JSONObject jo = new JSONObject();

                String id = UUID.randomUUID().toString();
                jo.put("id", id);

                String[] ss = line.split(",");

                String syear = ss[2];
                Date date = fmt.parse(syear);
                jo.put("date", date.getTime());

                addDoubleField(ss, 3, jo, "temp");
                addDoubleField(ss, 4, jo, "dewp");
                addDoubleField(ss, 5, jo, "slp");
                addDoubleField(ss, 6, jo, "stp");
                addDoubleField(ss, 7, jo, "visib");
                addDoubleField(ss, 8, jo, "wdsp");
                addDoubleField(ss, 9, jo, "mxspd");
                addDoubleField(ss, 10, jo, "gust");
                addDoubleField(ss, 11, jo, "max");
                addDoubleField(ss, 12, jo, "min");
                addDoubleField(ss, 13, jo, "prcp");

                PdxInstance inst = JSONFormatter.fromJSON(jo.toString());
                r.put(id, inst);
            }

            br.close();
        } finally {
            fr.close();
        }
    }
    
    private static void addDoubleField(String[] ss, int index, JSONObject json, String name) {
        String s = ss[index];
        double d = Double.parseDouble(s);
        json.put(name, d);
    }
}
