package io.pivotal.bds.gemfire.r.common;

@SuppressWarnings("serial")
public class DynamicTrainDefKey extends BaseColocationStringKey {

    public DynamicTrainDefKey() {
    }

    public DynamicTrainDefKey(String id, String colocationId) {
        super(id, colocationId);
    }

}
