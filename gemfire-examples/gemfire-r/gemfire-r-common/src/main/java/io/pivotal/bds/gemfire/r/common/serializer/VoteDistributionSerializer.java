package io.pivotal.bds.gemfire.r.common.serializer;

import org.jpmml.evaluator.VoteDistribution;

public class VoteDistributionSerializer extends ClassificationSerializer<VoteDistribution> {

    public VoteDistributionSerializer() {
        super(VoteDistribution.class);
    }

    @Override
    public int getId() {
        return 1001;
    }

}
