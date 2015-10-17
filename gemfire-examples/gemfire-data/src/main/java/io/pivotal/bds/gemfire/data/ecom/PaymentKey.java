package io.pivotal.bds.gemfire.data.ecom;

import io.pivotal.bds.gemfire.key.BaseColocationKey;

public class PaymentKey extends BaseColocationKey<Long, Long> {

    public PaymentKey() {
    }

    public PaymentKey(Long id, Long colocationId) {
        super(id, colocationId);
    }

}
