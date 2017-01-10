package io.pivotal.bds.gemfire.geojson.test;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.ClientRegionFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoadRawTest {

    private static ClientCache cache;
    private static Region<Integer, String> jsonFeatureRegion;
    // private static final String path =
    // "/Users/tdalsing/projects/gemfire-fe/gemfire-examples/gemfire-geojson/data/ex_5WHPthk5aWhLByKoCNVCCYHNWNEdr.imposm-geojson/ex_5WHPthk5aWhLByKoCNVCCYHNWNEdr_roads.geojson";
    private static final String path = "src/test/resources/phoenix-roads.geojson";

    @BeforeClass
    public static void before() throws Exception {
        System.out.println("before: creating cache and region");
        ClientCacheFactory ccf = new ClientCacheFactory();
        ccf.addPoolLocator("localhost", 10334);
        cache = ccf.create();

        ClientRegionFactory<Integer, String> crf = cache.createClientRegionFactory(ClientRegionShortcut.PROXY);
        jsonFeatureRegion = crf.create("jsonFeature");
    }

    @Test
    public void test() throws Exception {
        System.out.println("test: loading file");
        BufferedReader reader = Files.newBufferedReader(Paths.get(path));

        System.out.println("test: parsing file");
        JSONObject root = (JSONObject) JSONValue.parse(reader);
        JSONArray features = (JSONArray) root.get("features");

        int count = 0;
        System.out.println("test: creating features");

        for (Object feature : features) {
            JSONObject jo = (JSONObject) feature;
            JSONObject props = (JSONObject) jo.get("properties");

            Number nid = (Number) props.get("osm_id");
            Integer id = nid.intValue();

            String json = jo.toJSONString();

            jsonFeatureRegion.put(id, json);

            if (++count % 100 == 0) {
                System.out.println("test: written " + count + " features");
            }
        }

        System.out.println("test: done");
    }
}
