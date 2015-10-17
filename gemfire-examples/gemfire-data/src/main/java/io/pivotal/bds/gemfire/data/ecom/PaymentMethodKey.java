package io.pivotal.bds.gemfire.data.ecom;

import io.pivotal.bds.gemfire.key.BaseColocationKey;

public class PaymentMethodKey extends BaseColocationKey<Long, Long> {

    public PaymentMethodKey() {
    }

    public PaymentMethodKey(Long id, Long colocationId) {
        super(id, colocationId);
    }

}
