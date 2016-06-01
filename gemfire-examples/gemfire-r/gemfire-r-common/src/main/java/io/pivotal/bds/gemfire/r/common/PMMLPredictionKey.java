package io.pivotal.bds.gemfire.r.common;

@SuppressWarnings("serial")
public class PMMLPredictionKey extends BaseColocationStringKey {

    public PMMLPredictionKey() {
    }

    public PMMLPredictionKey(String id, String colocationId) {
        super(id, colocationId);
    }

}
