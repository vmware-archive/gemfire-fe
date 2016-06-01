package io.pivotal.bds.gemfire.r.server.util;

import io.pivotal.bds.gemfire.r.common.ModelKey;
import io.pivotal.bds.gemfire.r.common.Prediction;
import io.pivotal.bds.gemfire.r.common.PredictionKey;
import io.pivotal.bds.gemfire.util.RegionHelper;

public abstract class PredictHandler extends Handler {

    protected ModelKey modelKey;

    public PredictHandler(ModelKey modelKey, String regionName) {
        super(modelKey, regionName);
        this.modelKey = modelKey;
    }

    public ModelKey getModelKey() {
        return modelKey;
    }

    protected void send(PredictionKey key, Prediction prediction) {
        LOG.debug("send: key={}, prediction={}", key, prediction);
        RegionHelper.getRegion("prediction").put(key, prediction);
    }

}
