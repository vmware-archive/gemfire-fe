package io.pivotal.bds.gemfire.fraud.common.key;

import io.pivotal.bds.gemfire.keyfw.BaseDSColocationKey;

@SuppressWarnings("serial")
public class AlertKey extends BaseDSColocationKey<String, String> {

    public AlertKey() {
    }

    public AlertKey(String id, String colocationId) {
        super(id, colocationId);
    }

}
