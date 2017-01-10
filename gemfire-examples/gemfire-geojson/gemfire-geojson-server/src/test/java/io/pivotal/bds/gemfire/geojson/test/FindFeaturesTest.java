package io.pivotal.bds.gemfire.geojson.test;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.Pool;
import org.apache.geode.cache.execute.FunctionService;
import org.geotools.geojson.feature.FeatureJSON;
import org.geotools.geometry.jts.JTS;
import org.geotools.referencing.CRS;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.junit.BeforeClass;
import org.junit.Test;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.MathTransform;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.Point;

import io.pivotal.bds.gemfire.geojson.util.UTMHelper;

public class FindFeaturesTest {

    private static ClientCache cache;
    private static Pool pool;

    private static final FeatureJSON json = new FeatureJSON();
    private static final GeometryFactory factory = new GeometryFactory();

    private static CoordinateReferenceSystem wgs84 = DefaultGeographicCRS.WGS84;

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
            LineString ls = (LineString) sf.getAttribute("geometry");

            // use first coordinate as lookup point
            Coordinate coord = ls.getCoordinate();

            Point pt = factory.createPoint(coord);

            // get CRS for UTM for point
            CoordinateReferenceSystem cartCRS = UTMHelper.getUTM(pt);
            
            // get transforms for to/from cartesian
            MathTransform toCart = CRS.findMathTransform(wgs84, cartCRS);
            MathTransform toLatLon = CRS.findMathTransform(cartCRS, wgs84);

            // transform the point to cartesian
            Coordinate cartCoord = JTS.transform(coord, null, toCart);

            double x = cartCoord.x;
            double y = cartCoord.y;

            // create boundaries that are +/-25 meters from point
            double left = x - 25.0;
            double right = x + 25.0;
            double bottom = y - 25.0;
            double top = y + 25.0;

            // create polygon using boundaries
            Coordinate[] arg = new Coordinate[5];

            arg[0] = JTS.transform(new Coordinate(left, bottom), null, toLatLon);
            arg[1] = JTS.transform(new Coordinate(left, top), null, toLatLon);
            arg[2] = JTS.transform(new Coordinate(right, top), null, toLatLon);
            arg[3] = JTS.transform(new Coordinate(right, bottom), null, toLatLon);
            arg[4] = arg[0]; // polygon must be closed

            Object res = FunctionService.onServers(pool).withArgs(arg).execute("FindFeaturesFunction").getResult();
            System.out.println("res = " + res);
        }

        System.out.println("test: done");
    }
}
