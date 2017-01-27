package io.pivotal.bds.gemfire.geojson.test;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.geotools.feature.simple.SimpleFeatureBuilder;
import org.geotools.feature.simple.SimpleFeatureTypeBuilder;
import org.junit.Assert;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.WKTReader;

public class WKTTest {

    public static void main(String[] args) throws Exception {
        WKTReader wktReader = new WKTReader();

        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get("/Users/tdalsing/projects/allstate/docs/here/data/WKT/wkt_link.txt.001.sample"),
                Charset.forName("us-ascii"))) {
            String line = null;
            int c = 0;

            SimpleFeatureTypeBuilder sftb = new SimpleFeatureTypeBuilder();
            sftb.add("geometry", Geometry.class);
            sftb.setName("Link");
            SimpleFeatureType sft = sftb.buildFeatureType();
            
            while ((line = reader.readLine()) != null) {
//                System.out.println(++c + ": " + line);
                String[] cols = line.split("\t");
                Assert.assertEquals(line, 2, cols.length);

                String id = cols[0].trim();
                String wkt = cols[1].trim();
                Geometry geo = wktReader.read(wkt);
                
                SimpleFeatureBuilder sfb = new SimpleFeatureBuilder(sft);
                sfb.add(geo);
                
                SimpleFeature sf = sfb.buildFeature(id);
                Geometry geom = (Geometry) sf.getDefaultGeometry();
                System.out.println(++c + ": " + geom);
            }
        }
    }
}
