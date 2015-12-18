package io.pivotal.bds.gemfire.geo.data;

import com.vividsolutions.jts.geom.Geometry;

public class FindPOIRequest {

    private BoundaryKey boundaryKey;
    private Geometry geometry;

    public FindPOIRequest() {
    }

    public FindPOIRequest(BoundaryKey boundaryKey, Geometry geometry) {
        this.boundaryKey = boundaryKey;
        this.geometry = geometry;
    }

    public BoundaryKey getBoundaryKey() {
        return boundaryKey;
    }

    public void setBoundaryKey(BoundaryKey boundaryKey) {
        this.boundaryKey = boundaryKey;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    @Override
    public int hashCode() {
        return boundaryKey.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FindPOIRequest other = (FindPOIRequest) obj;
        if (boundaryKey == null) {
            if (other.boundaryKey != null)
                return false;
        } else if (!boundaryKey.equals(other.boundaryKey))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "FindPOIRequest [boundaryKey=" + boundaryKey + ", geometry=" + geometry + "]";
    }

}
