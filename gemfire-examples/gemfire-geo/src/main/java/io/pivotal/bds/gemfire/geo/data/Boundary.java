package io.pivotal.bds.gemfire.geo.data;

import java.util.List;

import com.vividsolutions.jts.geom.Geometry;

public class Boundary {

    private BoundaryKey key;
    private Geometry geometry;
    private List<BoundaryKey> children;

    public Boundary() {
    }

    public Boundary(BoundaryKey key, Geometry geometry, List<BoundaryKey> children) {
        this.key = key;
        this.geometry = geometry;
        this.children = children;
    }

    public BoundaryKey getKey() {
        return key;
    }

    public void setKey(BoundaryKey key) {
        this.key = key;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public List<BoundaryKey> getChildren() {
        return children;
    }

    public void setChildren(List<BoundaryKey> children) {
        this.children = children;
    }

    public boolean isLeaf() {
        return children == null || children.isEmpty();
    }

    @Override
    public String toString() {
        return "Boundary [key=" + key + ", geometry=" + geometry + ", children=" + children + "]";
    }
}
