package io.pivotal.bds.gemfire.ml.distance;

import java.util.Map;

import io.pivotal.bds.gemfire.ml.DistanceFactory;
import smile.math.distance.ChebyshevDistance;
import smile.math.distance.Distance;

public class ChebyshevDistanceFactory implements DistanceFactory<double[]> {

    @Override
    public Distance<double[]> createDistance(Map<String, Object> props) {
        return new ChebyshevDistance();
    }

}
