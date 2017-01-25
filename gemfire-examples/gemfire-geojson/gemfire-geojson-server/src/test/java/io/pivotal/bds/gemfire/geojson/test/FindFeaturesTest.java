package io.pivotal.bds.gemfire.geojson.test;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.Pool;
import org.apache.geode.cache.execute.FunctionService;
import org.geotools.geojson.feature.FeatureJSON;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.junit.BeforeClass;
import org.junit.Test;
import org.opengis.feature.simple.SimpleFeature;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Point;

import io.pivotal.bds.gemfire.geojson.comp.ComparisonType;
import io.pivotal.bds.gemfire.geojson.data.FindFeaturesRequest;

public class FindFeaturesTest {

    private static ClientCache cache;
    private static Pool pool;

    private static final FeatureJSON json = new FeatureJSON();

    // private static final String path =
    // "/Users/tdalsing/projects/allstate/docs/data/ex_5WHPthk5aWhLByKoCNVCCYHNWNEdr.imposm-geojson/ex_5WHPthk5aWhLByKoCNVCCYHNWNEdr_roads.geojson";
    private static final String path = "src/test/resources/phoenix-roads.geojson";

    @BeforeClass
    public static void before() throws Exception {
        System.out.println("before: creating cache and region");

        ClientCacheFactory ccf = new ClientCacheFactory();
        ccf.addPoolLocator("localhost", 10334);
        cache = ccf.create();
        pool = cache.getDefaultPool();

        System.out.println("before: done");
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
            Geometry ls = (Geometry) sf.getDefaultGeometry();
            Point pt = ls.getCentroid();
            Geometry geo = pt.buffer(0.0001);

            FindFeaturesRequest req = new FindFeaturesRequest(geo, null, ComparisonType.intersects);

            Object res = FunctionService.onServers(pool).withArgs(req).execute("FindFeaturesFunction").getResult();
            System.out.println("res = " + res);
        }

        System.out.println("test: done");
    }
}
