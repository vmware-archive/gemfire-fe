package io.pivotal.bds.gemfire.geojson.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.opengis.feature.simple.SimpleFeature;

import com.vividsolutions.jts.geom.Geometry;

public class Boundary {

    public static final int MAX_FEATURE_IDS = 1000;

    private final Integer id;
    private final Geometry geometry;
    private final List<SimpleFeature> features = new ArrayList<>();
    final BoundaryList children = new BoundaryList();

    private static final AtomicInteger nextId = new AtomicInteger();

    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock readLock = readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.writeLock();

    public Boundary(Geometry geometry) {
        this.id = nextId.getAndIncrement();
        this.geometry = geometry;
    }

    public Integer getId() {
        return id;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public List<SimpleFeature> getIntersectingFeatures(Geometry geom) {
        List<SimpleFeature> list = new ArrayList<>();
        getIntersectingFeatures(geom, list);
        return list;
    }

    void getIntersectingFeatures(Geometry geom, List<SimpleFeature> list) {
        if (geometry.intersects(geom)) {
            if (isLeaf()) {
                for (SimpleFeature feature: features) {
                    Geometry g = (Geometry)feature.getAttribute("geometry");
                    
                    if (geom.intersects(g)) {
                        list.add(feature);
                    }
                }
            } else {
                children.getIntersectingFeatures(geom, list);
            }
        }
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }

    public List<SimpleFeature> getFeatures() {
        readLock.lock();
        try {
            return Collections.unmodifiableList(features);
        } finally {
            readLock.unlock();
        }
    }

    public void addFeature(SimpleFeature feature) {
        Geometry geom = (Geometry) feature.getAttribute("geometry");

        if (geometry.intersects(geom)) {
            
            writeLock.lock();
            
            try {
                if (isLeaf()) {
                    if (features.size() > MAX_FEATURE_IDS) {
                        // split the geometry
                        split();

                        // move features to children
                        for (SimpleFeature f : features) {
                            Geometry g = (Geometry) f.getAttribute("geometry");
                            List<Boundary> bl = children.intersects(g);

                            for (Boundary b : bl) {
                                b.addFeature(feature);
                            }
                        }

                        features.clear();
                    } else {
                        // not at max, simply add
                        features.add(feature);
                    }
                } else {
                    children.addFeature(feature);
                }
            } finally {
                writeLock.unlock();
            }
        }
    }

    public boolean split() {
        return children.split(geometry);
    }

    public String printHierarchy() {
        StringBuilder buf = new StringBuilder();
        toString(buf, 0);
        return buf.toString();
    }

    void toString(StringBuilder buf, int indent) {
        for (int i = 0; i < indent; ++i) {
            buf.append(' ');
        }

        buf.append("id=").append(id).append(", geometry=").append(geometry).append(", features=").append(features).append('\n');
        children.toString(buf, indent + 3);
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}
