package io.pivotal.bds.gemfire.geojson.test;

import java.io.BufferedReader;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.geotools.geojson.feature.FeatureJSON;
import org.geotools.referencing.CRS;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.junit.Test;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.referencing.crs.CoordinateReferenceSystem;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.LineString;

public class SimpleLoadTest {

    @Test
    public void test() throws Exception {
        FeatureJSON fj = new FeatureJSON();
        BufferedReader reader = Files.newBufferedReader(Paths.get("src/test/resources/phoenix-roads.geojson"));

        JSONObject root = (JSONObject) JSONValue.parse(reader);

        // JSONObject crs = (JSONObject) root.get("crs");
        // JSONObject crsProps = (JSONObject) crs.get("properties");
        // String crsName = (String) crsProps.get("name");
        // CoordinateReferenceSystem coordRefSys = CRS.decode(crsName);

        JSONArray features = (JSONArray) root.get("features");
        for (Object feature : features) {
            SimpleFeature sf = (SimpleFeature) fj.readFeature(new StringReader(feature.toString()));
            System.out.println(sf.getID() + ": " + sf);
        }
    }
}
