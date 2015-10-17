package io.pivotal.bds.gemfire.xrefs.common;

import io.pivotal.bds.gemfire.key.BaseColocationKey;

public class TradeKey extends BaseColocationKey<Long, String> {

    public TradeKey() {
    }

    public TradeKey(Long id, String colocationId) {
        super(id, colocationId);
    }

}
