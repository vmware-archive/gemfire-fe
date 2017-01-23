package io.pivotal.bds.gemfire.geojson.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.geotools.feature.simple.SimpleFeatureBuilder;
import org.geotools.feature.simple.SimpleFeatureTypeBuilder;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

import io.pivotal.bds.gemfire.geojson.comp.ComparisonType;
import io.pivotal.bds.gemfire.geojson.data.Boundary;

public class BoundaryTest {

    private static Boundary root;

    private static final int LON_COUNT = 100;
    private static final int LAT_COUNT = 100;
    private static final int COUNT = LON_COUNT * LAT_COUNT;

    private static final double deltaLon = 360.0 / LON_COUNT;
    private static final double deltaLat = 180.0 / LAT_COUNT;

    private static final GeometryFactory factory = new GeometryFactory();
    private static final Map<String, SimpleFeature> features = new HashMap<>();

    @BeforeClass
    public static void before() {
        Coordinate[] coords = new Coordinate[5];

        coords[0] = new Coordinate(-180.0, -90.0);
        coords[1] = new Coordinate(-180.0, 90.0);
        coords[2] = new Coordinate(180.0, 90.0);
        coords[3] = new Coordinate(180.0, -90.0);
        coords[4] = coords[0];

        Geometry geom = factory.createPolygon(coords);

        root = new Boundary(geom);
        createFeatures();
    }

    @Test
    public void test() throws Exception {
        int count = 0;

        for (Map.Entry<String, SimpleFeature> e : features.entrySet()) {
            SimpleFeature sf = e.getValue();
            Geometry sfg = (Geometry) sf.getDefaultGeometry();
            Point pt = sfg.getCentroid();
            Geometry bound = pt.buffer(deltaLat / 1000.0);

            List<SimpleFeature> list = root.findFeatures(bound, ComparisonType.intersects, "Test");
            List<SimpleFeature> list2 = root.scanFeatures(bound, ComparisonType.intersects, "Test");

            Assert.assertEquals("Scan size is different than find size", list.size(), list2.size());

            for (SimpleFeature sf2 : list) {
                Geometry sfg2 = (Geometry) sf2.getDefaultGeometry();
                Assert.assertTrue("Wrong feature", sfg2.intersects(sfg));
            }

            if (++count % (LON_COUNT / 10) == 0) {
                System.out.println("Tested " + count + " features");
            }
        }
    }

    private static void createFeatures() {
        int count = 0;
        double lon = -180.0 + deltaLon;

        for (int x = 0; x < LON_COUNT; ++x) {
            double left = lon - deltaLon / 10.0;

            if (left < -180.0) {
                left = -180.0;
            }

            double right = lon + deltaLon / 10.0;

            if (right > 180.0) {
                right = 180.0;
            }

            double lat = -90.0 + deltaLat;

            for (int y = 0; y < LAT_COUNT; ++y) {
                double bottom = lat - deltaLat / 10.0;

                if (bottom < -90.0) {
                    bottom = -90.0;
                }

                double top = lat + deltaLat / 10.0;

                if (top > 90.0) {
                    top = 90.0;
                }

                Coordinate lowerLeft = new Coordinate(left, bottom);
                Coordinate upperRight = new Coordinate(right, top);

                Coordinate[] coords = { lowerLeft, upperRight };

                Geometry geo = factory.createLineString(coords);

                SimpleFeatureTypeBuilder sftb = new SimpleFeatureTypeBuilder();
                sftb.setName("Test");
                sftb.add("geometry", Geometry.class);

                SimpleFeatureType sft = sftb.buildFeatureType();

                SimpleFeatureBuilder sfb = new SimpleFeatureBuilder(sft);
                sfb.add(geo);

                SimpleFeature sf = sfb.buildFeature(UUID.randomUUID().toString());
                features.put(sf.getID(), sf);
                root.addFeature(sf);

                lat += deltaLat;

                if (lat > 90.0) {
                    lat = 90.0;
                }

                if (++count % (COUNT / 10) == 0) {
                    System.out.println("Added " + count + " features");
                }
            }

            lon += deltaLon;

            if (lon > 180.0) {
                lon = 180.0;
            }
        }
    }
}
