package io.pivotal.bds.gemfire.ml;

import java.util.Map;

import smile.math.distance.Distance;

public interface DistanceFactory<T> {

    Distance<T> createDistance(Map<String, Object> props);
}
