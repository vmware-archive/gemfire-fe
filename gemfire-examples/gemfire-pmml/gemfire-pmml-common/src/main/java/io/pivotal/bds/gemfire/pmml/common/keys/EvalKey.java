package io.pivotal.bds.gemfire.pmml.common.keys;

import io.pivotal.bds.gemfire.keyfw.BaseStringDSKey;

@SuppressWarnings("serial")
public class EvalKey extends BaseStringDSKey {

    public EvalKey() {
    }

    public EvalKey(String id) {
        super(id);
    }
}
