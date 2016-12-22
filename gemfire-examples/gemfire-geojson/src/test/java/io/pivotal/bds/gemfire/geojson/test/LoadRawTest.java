package io.pivotal.bds.gemfire.geojson.test;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.junit.BeforeClass;
import org.junit.Test;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.cache.client.ClientRegionFactory;
import com.gemstone.gemfire.cache.client.ClientRegionShortcut;
import com.gemstone.gemfire.cache.execute.FunctionService;

import io.pivotal.bds.gemfire.geojson.data.AddFeatureRequest;

public class LoadRawTest {

    private static ClientCache cache;
    private static Region<Integer, Integer> routingRegion;
    private static final String path = "/Users/tdalsing/projects/allstate/docs/data/ex_5WHPthk5aWhLByKoCNVCCYHNWNEdr.imposm-geojson/ex_5WHPthk5aWhLByKoCNVCCYHNWNEdr_roads.geojson";

    @BeforeClass
    public static void before() throws Exception {
        System.out.println("before: creating cache and region");
        ClientCacheFactory ccf = new ClientCacheFactory();
        ccf.addPoolLocator("localhost", 10334);
        cache = ccf.create();

        ClientRegionFactory<Integer, Integer> crf = cache.createClientRegionFactory(ClientRegionShortcut.PROXY);
        routingRegion = crf.create("routing");
    }

    @Test
    public void test() throws Exception {
        System.out.println("test: loading file");
        BufferedReader reader = Files.newBufferedReader(Paths.get(path));

        System.out.println("test: parsing file");
        JSONObject root = (JSONObject) JSONValue.parse(reader);
        JSONArray features = (JSONArray) root.get("features");

        System.out.println("test: creating features");
        Set<AddFeatureRequest> filter = new HashSet<>();

        for (Object feature : features) {
            JSONObject jo = (JSONObject) feature;
            JSONObject props = (JSONObject) jo.get("properties");
            Number nid = (Number) props.get("osm_id");
            Integer id = nid.intValue();

            AddFeatureRequest req = new AddFeatureRequest(id, jo.toJSONString());
            filter.add(req);
        }

        System.out.println("test: calling function");
        FunctionService.onRegion(routingRegion).withFilter(filter).execute("AddFeatureFunction").getResult();
        System.out.println("test: done");
    }
}
