package io.pivotal.bds.gemfire.data.securities;

import io.pivotal.bds.gemfire.key.BaseKey;

public class SecurityKey extends BaseKey<String> {

    public SecurityKey() {
    }

    public SecurityKey(String id) {
        super(id);
    }

}
