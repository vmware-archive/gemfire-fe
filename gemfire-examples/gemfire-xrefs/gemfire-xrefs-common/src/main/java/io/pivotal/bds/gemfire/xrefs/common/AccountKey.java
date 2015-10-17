package io.pivotal.bds.gemfire.xrefs.common;

import io.pivotal.bds.gemfire.key.BaseKey;

public class AccountKey extends BaseKey<String> {

    public AccountKey() {
    }

    public AccountKey(String id) {
        super(id);
    }

}
