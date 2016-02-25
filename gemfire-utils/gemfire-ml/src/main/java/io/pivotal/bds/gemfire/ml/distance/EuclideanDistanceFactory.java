package io.pivotal.bds.gemfire.ml.distance;

import java.util.Map;

import io.pivotal.bds.gemfire.ml.DistanceFactory;
import smile.math.distance.Distance;
import smile.math.distance.EuclideanDistance;

public class EuclideanDistanceFactory implements DistanceFactory<double[]> {

    @Override
    public Distance<double[]> createDistance(Map<String, Object> props) {
        double[] weight = (double[]) props.get("weight");
        return weight == null ? new EuclideanDistance() : new EuclideanDistance(weight);
    }

}
