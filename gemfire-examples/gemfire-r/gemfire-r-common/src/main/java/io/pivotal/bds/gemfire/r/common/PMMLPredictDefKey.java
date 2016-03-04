package io.pivotal.bds.gemfire.r.common;

@SuppressWarnings("serial")
public class PMMLPredictDefKey extends BaseColocationStringKey {

    public PMMLPredictDefKey() {
    }

    public PMMLPredictDefKey(String id, String colocationId) {
        super(id, colocationId);
    }

}
