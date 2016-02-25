package io.pivotal.bds.gemfire.ml.distance;

import java.util.Map;

import org.springframework.util.Assert;

import io.pivotal.bds.gemfire.ml.DistanceFactory;
import smile.math.distance.Distance;
import smile.math.distance.MinkowskiDistance;

public class MinkowskiDistanceFactory implements DistanceFactory<double[]> {

    @Override
    public Distance<double[]> createDistance(Map<String, Object> props) {
        Number p = (Number) props.get("p");
        Assert.notNull(p, "Missing property 'p'");
        double[] weight = (double[]) props.get("weight");
        return weight == null ? new MinkowskiDistance(p.intValue()) : new MinkowskiDistance(p.intValue(), weight);
    }

}
