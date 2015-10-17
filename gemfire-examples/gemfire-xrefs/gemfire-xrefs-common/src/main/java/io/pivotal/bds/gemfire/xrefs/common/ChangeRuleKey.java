package io.pivotal.bds.gemfire.xrefs.common;

import io.pivotal.bds.gemfire.key.BaseColocationKey;

public class ChangeRuleKey extends BaseColocationKey<String, String> {

    public ChangeRuleKey() {
    }

    public ChangeRuleKey(String id, String colocationId) {
        super(id, colocationId);
    }

}
