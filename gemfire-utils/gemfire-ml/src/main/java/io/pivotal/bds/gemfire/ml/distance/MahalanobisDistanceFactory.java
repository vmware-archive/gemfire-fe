package io.pivotal.bds.gemfire.ml.distance;

import java.util.Map;

import org.springframework.util.Assert;

import io.pivotal.bds.gemfire.ml.DistanceFactory;
import smile.math.distance.Distance;
import smile.math.distance.MahalanobisDistance;

public class MahalanobisDistanceFactory implements DistanceFactory<double[]> {

    @Override
    public Distance<double[]> createDistance(Map<String, Object> props) {
        double[][] cov = (double[][]) props.get("cov");
        Assert.notNull(cov, "Missing property 'cov'");
        return new MahalanobisDistance(cov);
    }

}
