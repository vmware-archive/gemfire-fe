package io.pivotal.bds.gemfire.ml.distance;

import java.util.Map;

import io.pivotal.bds.gemfire.ml.DistanceFactory;
import smile.math.distance.Distance;

public class HammingDistanceFactory<T> implements DistanceFactory<T> {

    @Override
    public Distance<T> createDistance(Map<String, Object> props) {
        return null; // TODO new HammingDistance();
    }

}
