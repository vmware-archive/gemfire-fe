package io.pivotal.bds.gemfire.geojson.test;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.geotools.geojson.feature.FeatureJSON;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.junit.BeforeClass;
import org.junit.Test;
import org.opengis.feature.simple.SimpleFeature;

import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.cache.client.Pool;
import com.gemstone.gemfire.cache.execute.FunctionService;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.LineString;

public class FindFeaturesTest {

    private static ClientCache cache;
    private static Pool pool;
    private static final FeatureJSON json = new FeatureJSON();
    private static final String path = "/Users/tdalsing/projects/allstate/docs/data/ex_5WHPthk5aWhLByKoCNVCCYHNWNEdr.imposm-geojson/ex_5WHPthk5aWhLByKoCNVCCYHNWNEdr_roads.geojson";

    @BeforeClass
    public static void before() throws Exception {
        System.out.println("before: creating cache and region");
        ClientCacheFactory ccf = new ClientCacheFactory();
        ccf.addPoolLocator("localhost", 10334);
        cache = ccf.create();
        pool = cache.getDefaultPool();
    }

    @Test
    public void test() throws Exception {
        System.out.println("test: loading file");
        BufferedReader reader = Files.newBufferedReader(Paths.get(path));

        System.out.println("test: parsing file");
        JSONObject root = (JSONObject) JSONValue.parse(reader);
        JSONArray features = (JSONArray) root.get("features");

        System.out.println("test: calling function");
        for (Object feature : features) {
            JSONObject jo = (JSONObject) feature;
            SimpleFeature sf = json.readFeature(jo.toString());
            LineString ls = (LineString) sf.getAttribute("geometry");
            Coordinate coord = ls.getCoordinate();

            FunctionService.onServers(pool).withArgs(coord).execute("FindFeaturesFunction").getResult();
        }

        System.out.println("test: done");
    }
}
