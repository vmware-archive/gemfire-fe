package io.pivotal.bds.gemfire.geojson.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Consumer;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.opengis.feature.simple.SimpleFeature;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

@SuppressWarnings("serial")
public class BoundaryList extends ArrayList<Boundary> {

    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock writeLock = readWriteLock.writeLock();
    private final Lock readLock = readWriteLock.readLock();

    private static final GeometryFactory factory = new GeometryFactory();

    public BoundaryList() {
    }

    void addFeature(SimpleFeature feat) {
        readLock.lock();
        try {
            for (Boundary b : this) {
                b.addFeature(feat);
            }
        } finally {
            readLock.unlock();
        }
    }

    void getIntersectingFeatures(Geometry geom, List<SimpleFeature> list) {
        readLock.lock();
        try {
            for (Boundary b : this) {
                b.getIntersectingFeatures(geom, list);
            }
        } finally {
            readLock.unlock();
        }
    }

    public boolean split(Geometry geom) {
        writeLock.lock();
        try {
            if (!super.isEmpty()) {
                return false;
            }

            Coordinate[] coords = geom.getCoordinates();

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
                    Boundary b = new Boundary(poly);
                    add(b);

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

            return true;
        } finally {
            writeLock.unlock();
        }
    }

    public List<Boundary> intersects(Geometry geom) {
        return find(geom, intersectsComparator);
    }

    public Boundary intersects(Point pt) {
        return find(pt, intersectsComparator);
    }

    public List<Boundary> contains(Geometry geom) {
        return find(geom, containsComparator);
    }

    public Boundary contains(Point pt) {
        return find(pt, containsComparator);
    }

    public List<Boundary> coveredBy(Geometry geom) {
        return find(geom, coveredByComparator);
    }

    public Boundary coveredBy(Point pt) {
        return find(pt, coveredByComparator);
    }

    public List<Boundary> covers(Geometry geom) {
        return find(geom, coversComparator);
    }

    public Boundary covers(Point pt) {
        return find(pt, coversComparator);
    }

    public List<Boundary> crosses(Geometry geom) {
        return find(geom, crossesComparator);
    }

    public Boundary crosses(Point pt) {
        return find(pt, crossesComparator);
    }

    public List<Boundary> disjoint(Geometry geom) {
        return find(geom, disjointComparator);
    }

    public Boundary disjoint(Point pt) {
        return find(pt, disjointComparator);
    }

    public List<Boundary> overlaps(Geometry geom) {
        return find(geom, overlapsComparator);
    }

    public Boundary overlaps(Point pt) {
        return find(pt, overlapsComparator);
    }

    public List<Boundary> touches(Geometry geom) {
        return find(geom, touchesComparator);
    }

    public Boundary touches(Point pt) {
        return find(pt, touchesComparator);
    }

    public List<Boundary> within(Geometry geom) {
        return find(geom, withinComparator);
    }

    public Boundary within(Point pt) {
        return find(pt, withinComparator);
    }

    private Boundary find(Point pt, GeoComparator comp) {
        readLock.lock();
        try {
            for (Boundary b : this) {
                if (comp.compare(b.getGeometry(), pt)) {
                    if (b.isLeaf()) {
                        return b;
                    } else {
                        return b.children.find(pt, comp);
                    }
                }
            }

            return null;
        } finally {
            readLock.unlock();
        }
    }

    private List<Boundary> find(Geometry geom, GeoComparator comp) {
        List<Boundary> list = new ArrayList<>();
        find(geom, comp, list);
        return list;
    }

    private void find(Geometry geom, GeoComparator comp, List<Boundary> list) {
        readLock.lock();
        try {
            for (Boundary b : this) {
                if (comp.compare(b.getGeometry(), geom)) {
                    if (b.isLeaf()) {
                        list.add(b);
                    } else {
                        b.children.find(geom, comp, list);
                    }
                }
            }
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public int size() {
        readLock.lock();
        try {
            return super.size();
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public boolean isEmpty() {
        readLock.lock();
        try {
            return super.isEmpty();
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public boolean contains(Object o) {
        readLock.lock();
        try {
            return super.contains(o);
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public Boundary get(int index) {
        readLock.lock();
        try {
            return super.get(index);
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public boolean add(Boundary e) {
        writeLock.lock();
        try {
            return super.add(e);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public Boundary remove(int index) {
        writeLock.lock();
        try {
            return super.remove(index);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public boolean remove(Object o) {
        writeLock.lock();
        try {
            return super.remove(o);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public void clear() {
        writeLock.lock();
        try {
            super.clear();
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public boolean addAll(Collection<? extends Boundary> c) {
        writeLock.lock();
        try {
            return super.addAll(c);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        writeLock.lock();
        try {
            return super.removeAll(c);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public void forEach(Consumer<? super Boundary> action) {
        readLock.lock();
        try {
            super.forEach(action);
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        readLock.lock();
        try {
            return super.containsAll(c);
        } finally {
            readLock.unlock();
        }
    }

    private static final GeoComparator intersectsComparator = new Intersects();
    private static final GeoComparator containsComparator = new Contains();
    private static final GeoComparator coveredByComparator = new CoveredBy();
    private static final GeoComparator coversComparator = new Covers();
    private static final GeoComparator crossesComparator = new Crosses();
    private static final GeoComparator disjointComparator = new Disjoint();
    private static final GeoComparator overlapsComparator = new Overlaps();
    private static final GeoComparator touchesComparator = new Touches();
    private static final GeoComparator withinComparator = new Within();

    private static interface GeoComparator {
        boolean compare(Geometry g1, Geometry g2);
    }

    private static class Intersects implements GeoComparator {

        @Override
        public boolean compare(Geometry g1, Geometry g2) {
            return g1.intersects(g2);
        }
    }

    private static class Contains implements GeoComparator {

        @Override
        public boolean compare(Geometry g1, Geometry g2) {
            return g1.contains(g2);
        }
    }

    private static class CoveredBy implements GeoComparator {

        @Override
        public boolean compare(Geometry g1, Geometry g2) {
            return g1.coveredBy(g2);
        }
    }

    private static class Covers implements GeoComparator {

        @Override
        public boolean compare(Geometry g1, Geometry g2) {
            return g1.covers(g2);
        }
    }

    private static class Crosses implements GeoComparator {

        @Override
        public boolean compare(Geometry g1, Geometry g2) {
            return g1.crosses(g2);
        }
    }

    private static class Disjoint implements GeoComparator {

        @Override
        public boolean compare(Geometry g1, Geometry g2) {
            return g1.disjoint(g2);
        }
    }

    private static class Overlaps implements GeoComparator {

        @Override
        public boolean compare(Geometry g1, Geometry g2) {
            return g1.overlaps(g2);
        }
    }

    private static class Touches implements GeoComparator {

        @Override
        public boolean compare(Geometry g1, Geometry g2) {
            return g1.touches(g2);
        }
    }

    private static class Within implements GeoComparator {

        @Override
        public boolean compare(Geometry g1, Geometry g2) {
            return g1.within(g2);
        }
    }

    void toString(StringBuilder buf, int indent) {
        for (Boundary b : this) {
            b.toString(buf, indent);
        }
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
