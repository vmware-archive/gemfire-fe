package io.pivotal.bds.gemfire.data.securities;

import io.pivotal.bds.gemfire.key.BaseKey;

public class IssuerKey extends BaseKey<String> {

    public IssuerKey() {
    }

    public IssuerKey(String id) {
        super(id);
    }

}
