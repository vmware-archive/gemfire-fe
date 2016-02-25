package io.pivotal.bds.gemfire.ml.distance;

import java.util.Map;

import io.pivotal.bds.gemfire.ml.DistanceFactory;
import smile.math.distance.CorrelationDistance;
import smile.math.distance.Distance;

public class CorrelationDistanceFactory implements DistanceFactory<double[]> {

    @Override
    public Distance<double[]> createDistance(Map<String, Object> props) {
        return new CorrelationDistance();
    }

}
