package io.pivotal.bds.gemfire.r.common;

@SuppressWarnings("serial")
public class PredictionKey extends BaseColocationStringKey {

    public PredictionKey() {
    }

    public PredictionKey(String id, String colocationId) {
        super(id, colocationId);
    }

}
