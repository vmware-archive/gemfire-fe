package io.pivotal.bds.gemfire.fraud.common.key;

import io.pivotal.bds.gemfire.keyfw.BaseDSColocationKey;

@SuppressWarnings("serial")
public class CardKey extends BaseDSColocationKey<String, String> {

    public CardKey() {
    }

    public CardKey(String id, String acctId) {
        super(id, acctId);
    }

}
