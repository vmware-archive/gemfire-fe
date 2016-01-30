package io.pivotal.bds.gemfire.pmml.common.data;

import io.pivotal.bds.gemfire.key.BaseKey;

public class ModelKey extends BaseKey<String> {

    public ModelKey() {
    }

    public ModelKey(String id) {
        super(id);
    }

}
