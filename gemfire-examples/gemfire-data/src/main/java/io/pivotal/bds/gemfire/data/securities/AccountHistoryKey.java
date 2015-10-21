package io.pivotal.bds.gemfire.data.securities;

import io.pivotal.bds.gemfire.key.BaseColocationKey;

public class AccountHistoryKey extends BaseColocationKey<Long, String> {

    public AccountHistoryKey() {
    }

    public AccountHistoryKey(Long id, String colocationId) {
        super(id, colocationId);
    }

}
