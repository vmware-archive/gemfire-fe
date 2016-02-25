package io.pivotal.bds.gemfire.ml.distance;

import java.util.Map;

import io.pivotal.bds.gemfire.ml.DistanceFactory;
import smile.math.SparseArray;
import smile.math.distance.Distance;
import smile.math.distance.SparseEuclideanDistance;

public class SparseEuclideanDistanceFactory implements DistanceFactory<SparseArray> {

    @Override
    public Distance<SparseArray> createDistance(Map<String, Object> props) {
        double[] weight = (double[]) props.get("weight");
        return weight == null ? new SparseEuclideanDistance() : new SparseEuclideanDistance(weight);
    }

}
