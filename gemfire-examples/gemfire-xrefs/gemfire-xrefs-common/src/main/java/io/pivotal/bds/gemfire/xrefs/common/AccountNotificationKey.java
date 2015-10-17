package io.pivotal.bds.gemfire.xrefs.common;

import io.pivotal.bds.gemfire.key.BaseColocationKey;

public class AccountNotificationKey extends BaseColocationKey<Long, String> {

    public AccountNotificationKey() {
    }

    public AccountNotificationKey(Long id, String colocationId) {
        super(id, colocationId);
    }

}
