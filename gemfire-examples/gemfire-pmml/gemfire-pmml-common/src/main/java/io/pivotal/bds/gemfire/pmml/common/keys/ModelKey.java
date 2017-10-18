package io.pivotal.bds.gemfire.pmml.common.keys;

import io.pivotal.bds.gemfire.keyfw.BaseStringDSKey;

@SuppressWarnings("serial")
public class ModelKey extends BaseStringDSKey {

    public ModelKey() {
    }

    public ModelKey(String id) {
        super(id);
    }

}
