package io.pivotal.bds.gemfire.data.ecom;

import io.pivotal.bds.gemfire.key.BaseColocationKey;

public class OrderKey extends BaseColocationKey<Long, Long> {

    public OrderKey() {
    }

    public OrderKey(Long id, Long colocationId) {
        super(id, colocationId);
    }

}
