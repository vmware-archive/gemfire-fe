package io.pivotal.bds.gemfire.r.common;

@SuppressWarnings("serial")
public class TrainDefKey extends BaseColocationStringKey {

    public TrainDefKey() {
    }

    public TrainDefKey(String id, String colocationId) {
        super(id, colocationId);
    }

}
