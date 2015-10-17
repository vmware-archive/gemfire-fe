package io.pivotal.bds.gemfire.data.ecom;

import io.pivotal.bds.gemfire.key.BaseColocationKey;

public class OrderItemKey extends BaseColocationKey<Long, Long> {

    public OrderItemKey() {
    }

    public OrderItemKey(Long id, Long colocationId) {
        super(id, colocationId);
    }

}
