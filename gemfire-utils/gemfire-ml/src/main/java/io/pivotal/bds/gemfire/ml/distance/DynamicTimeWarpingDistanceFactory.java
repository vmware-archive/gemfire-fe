package io.pivotal.bds.gemfire.ml.distance;

import java.util.Map;

import org.springframework.util.Assert;

import io.pivotal.bds.gemfire.ml.DistanceFactory;
import smile.math.distance.Distance;
import smile.math.distance.DynamicTimeWarping;

public class DynamicTimeWarpingDistanceFactory<T> implements DistanceFactory<T> {

    @SuppressWarnings("unchecked")
    @Override
    public Distance<T> createDistance(Map<String, Object> props) {
        Distance<T> dist = (Distance<T>) props.get("distance");
        Assert.notNull(dist, "Distance property 'distance' is missing");
        Number radius = (Number) props.getOrDefault("radius", 1.0);
        return (Distance<T>) new DynamicTimeWarping<T>(dist, radius.doubleValue());
    }

}
