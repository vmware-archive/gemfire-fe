package io.pivotal.bds.gemfire.ml.distance;

import java.util.Map;

import org.springframework.util.Assert;

import io.pivotal.bds.gemfire.ml.DistanceFactory;
import smile.math.distance.Distance;
import smile.math.distance.LeeDistance;

public class LeeDistanceFactory implements DistanceFactory<int[]> {

    @Override
    public Distance<int[]> createDistance(Map<String, Object> props) {
        Number q = (Number) props.get("q");
        Assert.notNull(q, "Missing property 'q'");
        return new LeeDistance(q.intValue());
    }

}
