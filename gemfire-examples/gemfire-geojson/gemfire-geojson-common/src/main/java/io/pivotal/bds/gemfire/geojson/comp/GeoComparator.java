package io.pivotal.bds.gemfire.geojson.comp;

import java.util.HashMap;
import java.util.Map;

import com.vividsolutions.jts.geom.Geometry;

public abstract class GeoComparator {

    private static final Map<ComparisonType, GeoComparator> comparators;

    static {
        comparators = new HashMap<>();
        
        comparators.put(ComparisonType.contains, new Contains());
        comparators.put(ComparisonType.coveredBy, new CoveredBy());
        comparators.put(ComparisonType.covers, new Covers());
        comparators.put(ComparisonType.crosses, new Crosses());
        comparators.put(ComparisonType.disjoint, new Disjoint());
        comparators.put(ComparisonType.intersects, new Intersects());
        comparators.put(ComparisonType.overlaps, new Overlaps());
        comparators.put(ComparisonType.touches, new Touches());
        comparators.put(ComparisonType.within, new Within());
    }

    protected GeoComparator() {
    }

    public static boolean compare(Geometry g1, Geometry g2, ComparisonType type) {
        GeoComparator comp = comparators.get(type);

        if (comp == null) {
            throw new IllegalArgumentException("GeoComparator for " + type.name() + " not found");
        }

        return comp.compare(g1, g2);
    }

    public abstract boolean compare(Geometry g1, Geometry g2);
}