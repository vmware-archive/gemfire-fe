package io.pivotal.bds.gemfire.data.ecom;

import io.pivotal.bds.gemfire.key.BaseKey;

public class AccountKey extends BaseKey<Long> {

    public AccountKey() {
    }

    public AccountKey(Long id) {
        super(id);
    }

}
