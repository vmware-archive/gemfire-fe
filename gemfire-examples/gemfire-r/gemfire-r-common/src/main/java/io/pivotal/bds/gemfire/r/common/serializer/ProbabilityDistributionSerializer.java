package io.pivotal.bds.gemfire.r.common.serializer;

import org.jpmml.evaluator.ProbabilityDistribution;

public class ProbabilityDistributionSerializer extends ClassificationSerializer<ProbabilityDistribution> {

    public ProbabilityDistributionSerializer() {
        super(ProbabilityDistribution.class);
    }

    @Override
    public int getId() {
        return 1002;
    }

}
