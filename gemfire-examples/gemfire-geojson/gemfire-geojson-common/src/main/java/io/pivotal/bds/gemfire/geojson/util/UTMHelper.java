package io.pivotal.bds.gemfire.geojson.util;

import java.util.ArrayList;
import java.util.List;

import org.geotools.referencing.CRS;
import org.opengis.referencing.crs.CoordinateReferenceSystem;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

public class UTMHelper {

    private static final List<Holder> holders = new ArrayList<>();
    private static final GeometryFactory factory = new GeometryFactory();

    static {
        try {
            double left = -180.0;

            for (int i = 0; i < 60; ++i) {
                addZone(i + 32601, left, 84.0, 0.0); // N
                addZone(i + 32701, left, 0.0, -80.0); // S
                left += 6.0;
            }
        } catch (Exception x) {
            // unlikely unless the classpath doesn't include gt-epsg-hsql
            x.printStackTrace();
        }
    }

    public static CoordinateReferenceSystem getUTM(Point location) {
        for (Holder h : holders) {
            if (h.boundary.intersects(location)) {
                return h.crs;
            }
        }

        throw new IllegalArgumentException("Cannot find CRS for point " + location);
    }

    private static class Holder {
        public CoordinateReferenceSystem crs;
        public Geometry boundary;
    }

    private static void addZone(int code, double left, double top, double bottom) throws Exception {
        double right = left + 6.0;
        CoordinateReferenceSystem crs = CRS.decode("EPSG:" + code);

        Coordinate[] coords = new Coordinate[5];

        coords[0] = new Coordinate(left, bottom);
        coords[1] = new Coordinate(left, top);
        coords[2] = new Coordinate(right, top);
        coords[3] = new Coordinate(right, bottom);
        coords[4] = coords[0]; // polygons must be closed

        Geometry bound = factory.createPolygon(coords);

        Holder h = new Holder();

        h.crs = crs;
        h.boundary = bound;

        holders.add(h);
    }
}
