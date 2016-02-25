package io.pivotal.bds.gemfire.ml.distance;

import java.util.Map;

import io.pivotal.bds.gemfire.ml.DistanceFactory;
import smile.math.distance.Distance;
import smile.math.distance.JaccardDistance;

public class JaccardDistanceFactory<T> implements DistanceFactory<T> {

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Distance<T> createDistance(Map<String, Object> props) {
        return new JaccardDistance();
    }

}
