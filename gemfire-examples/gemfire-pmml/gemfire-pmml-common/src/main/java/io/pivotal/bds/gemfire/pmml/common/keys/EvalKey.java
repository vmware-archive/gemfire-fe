package io.pivotal.bds.gemfire.pmml.common.keys;

import io.pivotal.bds.gemfire.key.BaseKey;

public class EvalKey extends BaseKey<String> {

    public EvalKey() {
    }

    public EvalKey(String id) {
        super(id);
    }

}
