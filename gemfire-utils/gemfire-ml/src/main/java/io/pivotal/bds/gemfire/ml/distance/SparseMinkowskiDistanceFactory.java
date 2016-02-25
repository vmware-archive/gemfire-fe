package io.pivotal.bds.gemfire.ml.distance;

import java.util.Map;

import org.springframework.util.Assert;

import io.pivotal.bds.gemfire.ml.DistanceFactory;
import smile.math.SparseArray;
import smile.math.distance.Distance;
import smile.math.distance.SparseMinkowskiDistance;

public class SparseMinkowskiDistanceFactory implements DistanceFactory<SparseArray> {

    @Override
    public Distance<SparseArray> createDistance(Map<String, Object> props) {
        Number p = (Number) props.get("p");
        Assert.notNull(p, "Missing property 'p'");
        double[] weight = (double[]) props.get("weight");
        return weight == null ? new SparseMinkowskiDistance(p.intValue()) : new SparseMinkowskiDistance(p.intValue(), weight);
    }

}
