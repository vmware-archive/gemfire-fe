package io.pivotal.bds.gemfire.data.ecom;

import io.pivotal.bds.gemfire.key.BaseColocationKey;

public class InvoiceKey extends BaseColocationKey<Long, Long> {

    public InvoiceKey() {
    }

    public InvoiceKey(Long id, Long colocationId) {
        super(id, colocationId);
    }

}
