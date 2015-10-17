package io.pivotal.bds.gemfire.xrefs.common;

import io.pivotal.bds.gemfire.key.BaseKey;

public class IssuerKey extends BaseKey<String> {

    public IssuerKey() {
    }

    public IssuerKey(String id) {
        super(id);
    }

}
