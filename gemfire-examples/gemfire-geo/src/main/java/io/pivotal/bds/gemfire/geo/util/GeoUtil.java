package io.pivotal.bds.gemfire.geo.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.gemstone.gemfire.cache.Region;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

import io.pivotal.bds.gemfire.geo.Constants;
import io.pivotal.bds.gemfire.geo.data.Boundary;
import io.pivotal.bds.gemfire.geo.data.BoundaryKey;
import io.pivotal.bds.gemfire.util.RegionHelper;

public class GeoUtil implements Constants {

    private static final GeometryFactory factory = new GeometryFactory();

    public static List<Geometry> split(Geometry g) {
        Coordinate[] coords = g.getCoordinates();

        double minX = Double.MAX_VALUE;
        double maxX = -1.0 * Double.MAX_VALUE;
        double minY = Double.MAX_VALUE;
        double maxY = -1.0 * Double.MAX_VALUE;

        for (Coordinate coord : coords) {
            double x = coord.x;
            double y = coord.y;

            if (x < minX) {
                minX = x;
            }

            if (x > maxX) {
                maxX = x;
            }

            if (y < minY) {
                minY = y;
            }

            if (y > maxY) {
                maxY = y;
            }
        }

        double deltaX = (maxX - minX) / 10.0;
        double deltaY = (maxY - minY) / 10.0;

        List<Geometry> list = new ArrayList<>();

        double lx = minX;
        double rx = lx + deltaX;

        for (int ix = 0; ix < 10; ++ix) {
            double ly = minY;
            double uy = ly + deltaY;

            for (int iy = 0; iy < 10; ++iy) {
                Coordinate[] newCoords = new Coordinate[5];

                newCoords[0] = new Coordinate(lx, ly);
                newCoords[1] = new Coordinate(lx, uy);
                newCoords[2] = new Coordinate(rx, uy);
                newCoords[3] = new Coordinate(rx, ly);
                newCoords[4] = new Coordinate(lx, ly);

                Polygon poly = factory.createPolygon(newCoords);
                list.add(poly);

                ly = uy;

                if (iy == 9) {
                    uy = maxY;
                } else {
                    uy = ly + deltaY;
                }
            }

            lx = rx;

            if (ix == 9) {
                rx = maxX;
            } else {
                rx = lx + deltaX;
            }
        }

        return list;
    }

    public static Boundary intersects(Point pt) {
        Region<BoundaryKey, Boundary> rootRegion = RegionHelper.getRegion(ROOT_BOUNDARY_REGION_NAME);

        for (Boundary b : rootRegion.values()) {
            Boundary b2 = intersects(b, pt);

            if (b2 != null) {
                return b2;
            }
        }

        return null;
    }

    public static Boundary intersects(Boundary b, Point pt) {
        if (b.getGeometry().intersects(pt)) {
            if (b.isLeaf()) {
                return b;
            }

            Region<BoundaryKey, Boundary> region = RegionHelper.getRegion(BOUNDARY_REGION_NAME);

            try {
                b.getChildren().forEach(new Consumer<BoundaryKey>() {
                    @Override
                    public void accept(BoundaryKey t) {
                        Boundary b2 = region.get(t);
                        Boundary br = intersects(b2, pt);

                        if (br != null) {
                            throw new ExitException(br);
                        }
                    }
                });
            } catch (ExitException x) {
                return x.boundary;
            }
        }

        return null;
    }

    public static List<Boundary> intersects(Geometry geom) {
        List<Boundary> list = new ArrayList<>();
        intersects(geom, list);
        return list;
    }

    public static void intersects(Geometry geom, List<Boundary> list) {
        Region<BoundaryKey, Boundary> rootRegion = RegionHelper.getRegion(ROOT_BOUNDARY_REGION_NAME);

        for (Boundary b : rootRegion.values()) {
            intersects(b, geom, list);
        }
    }

    public static List<Boundary> intersects(Boundary b, Geometry geom) {
        List<Boundary> list = new ArrayList<>();
        intersects(b, geom, list);
        return list;
    }

    public static void intersects(Boundary b, Geometry geom, List<Boundary> list) {
        if (b.getGeometry().intersects(geom)) {
            if (b.isLeaf()) {
                list.add(b);
            } else {
                Region<BoundaryKey, Boundary> region = RegionHelper.getRegion(BOUNDARY_REGION_NAME);

                b.getChildren().forEach(new Consumer<BoundaryKey>() {
                    @Override
                    public void accept(BoundaryKey t) {
                        Boundary b2 = region.get(t);
                        intersects(b2, geom, list);
                    }
                });
            }
        }
    }

    @SuppressWarnings("serial")
    private static final class ExitException extends RuntimeException {
        public Boundary boundary;

        public ExitException(Boundary boundary) {
            this.boundary = boundary;
        }

    }
}
