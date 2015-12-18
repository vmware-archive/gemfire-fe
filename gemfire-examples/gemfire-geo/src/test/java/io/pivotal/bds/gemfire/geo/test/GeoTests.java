package io.pivotal.bds.gemfire.geo.test;

import java.util.List;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Polygon;

import io.pivotal.bds.gemfire.geo.util.GeoUtil;

public class GeoTests {

    public static void main(String[] args) throws Exception {
        GeometryFactory gf = new GeometryFactory();

        Coordinate[] coords = new Coordinate[5];

        coords[0] = new Coordinate(-180.0, -90.0);
        coords[1] = new Coordinate(-180.0, +90.0);
        coords[2] = new Coordinate(+180.0, +90.0);
        coords[3] = new Coordinate(+180.0, -90.0);
        coords[4] = new Coordinate(-180.0, -90.0);

        Polygon poly = gf.createPolygon(coords);

        System.out.println(poly);

        System.out.println("empty = " + poly.isEmpty());
        System.out.println("rectangle = " + poly.isRectangle());
        System.out.println("simple = " + poly.isSimple());
        System.out.println("valid = " + poly.isValid());

        System.out.println("contains 0/0 = " + poly.contains(gf.createPoint(new Coordinate(0.0, 0.0))));
        System.out.println("contains -180/-90 = " + poly.contains(gf.createPoint(new Coordinate(-180.0, -90.0))));
        System.out.println("intersects 0/0 = " + poly.intersects(gf.createPoint(new Coordinate(0.0, 0.0))));
        System.out.println("intersects -180/-90 = " + poly.intersects(gf.createPoint(new Coordinate(-180.0, -90.0))));
        System.out.println("overlaps = " + poly.overlaps(gf.createPoint(new Coordinate(-180.0, -90.0))));
        System.out.println("within = " + poly.within(gf.createPoint(new Coordinate(0.0, 0.0))));
        System.out.println("touches -180/-90 = " + poly.touches(gf.createPoint(new Coordinate(-180.0, -90.0))));
        System.out.println("touches 0/0 = " + poly.touches(gf.createPoint(new Coordinate(0.0, 0.0))));

        List<Geometry> split = GeoUtil.split(poly);
        System.out.println("split = " + split);
        for (Geometry g : split) {
            System.out.println("    split = " + GeoUtil.split(g));
        }
    }
}
