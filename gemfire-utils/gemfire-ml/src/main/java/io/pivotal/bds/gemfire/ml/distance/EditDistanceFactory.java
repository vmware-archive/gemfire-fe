package io.pivotal.bds.gemfire.ml.distance;

import java.util.Map;

import org.springframework.util.Assert;

import io.pivotal.bds.gemfire.ml.DistanceFactory;
import smile.math.distance.Distance;
import smile.math.distance.EditDistance;

public class EditDistanceFactory implements DistanceFactory<String> {

    @Override
    public Distance<String> createDistance(Map<String, Object> props) {
        double[][] weight = (double[][]) props.get("weight");
        Number radius = (Number) props.get("radius");
        Number maxStringLength = (Number) props.get("maxStringLength");
        Boolean damerau = (Boolean) props.get("damerau");

        if (weight != null) {
            Assert.isNull(maxStringLength, "Weight was specified so 'maxStringLength' cannot be specified");
            Assert.isNull(damerau, "Weight was specified so 'damerau' cannot be specified");

            return radius == null ? new EditDistance(weight) : new EditDistance(weight, radius.doubleValue());
        } else if (maxStringLength != null) {
            return damerau == null ? new EditDistance(maxStringLength.intValue())
                    : new EditDistance(maxStringLength.intValue(), damerau.booleanValue());
        } else {
            throw new IllegalArgumentException("Either weight or maxStringLength must be specified");
        }
    }

}
