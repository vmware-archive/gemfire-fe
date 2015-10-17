package io.pivotal.bds.gemfire.xrefs.common;

import io.pivotal.bds.gemfire.key.BaseKey;

public class VolumeChangeRuleKey extends BaseKey<Long> {

    public VolumeChangeRuleKey() {
    }

    public VolumeChangeRuleKey(Long id) {
        super(id);
    }

}
