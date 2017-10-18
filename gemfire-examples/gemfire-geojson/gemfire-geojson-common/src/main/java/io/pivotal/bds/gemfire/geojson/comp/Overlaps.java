package io.pivotal.bds.gemfire.geojson.comp;

import com.vividsolutions.jts.geom.Geometry;

public class Overlaps extends GeoComparator {

    @Override
    public boolean compare(Geometry g1, Geometry g2) {
        return g1.overlaps(g2);
    }
}
