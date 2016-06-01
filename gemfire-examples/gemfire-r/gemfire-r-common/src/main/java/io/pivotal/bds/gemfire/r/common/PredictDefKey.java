package io.pivotal.bds.gemfire.r.common;

@SuppressWarnings("serial")
public class PredictDefKey extends BaseColocationStringKey {

    public PredictDefKey() {
    }

    public PredictDefKey(String id, String colocationId) {
        super(id, colocationId);
    }

}
