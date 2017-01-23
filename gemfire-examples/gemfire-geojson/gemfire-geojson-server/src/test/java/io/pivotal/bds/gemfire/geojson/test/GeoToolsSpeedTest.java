package io.pivotal.bds.gemfire.geojson.test;

import org.junit.Test;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

public class GeoToolsSpeedTest {

    @Test
    public void test() throws Exception {
        Coordinate coord = new Coordinate(0.0, 0.0);
        Point pt = new GeometryFactory().createPoint(coord);
        Geometry geom = pt.buffer(0.0001);

        int count = 10000;
        long start = System.nanoTime();

        for (int i = 0; i < count; ++i) {
            geom.intersects(geom);
        }

        long end = System.nanoTime();
        long delta = end - start;
        long avg = delta / count;
        System.out.println(delta + " " + avg);
    }
}
