package io.pivotal.bds.gemfire.fraud.common.key;

import io.pivotal.bds.gemfire.keyfw.BaseDSKey;

@SuppressWarnings("serial")
public class AccountKey extends BaseDSKey<String> {

    public AccountKey() {
    }

    public AccountKey(String id) {
        super(id);
    }

}
