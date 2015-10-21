package io.pivotal.bds.gemfire.data.securities;

import io.pivotal.bds.gemfire.key.BaseColocationKey;

public class SecurityPriceHistoryKey extends BaseColocationKey<Long, String> {

    public SecurityPriceHistoryKey() {
    }

    public SecurityPriceHistoryKey(Long id, String colocationId) {
        super(id, colocationId);
    }

}
