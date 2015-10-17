package io.pivotal.bds.gemfire.data.ecom;

import io.pivotal.bds.gemfire.key.BaseColocationKey;

public class AddressKey extends BaseColocationKey<Long, Long> {

    public AddressKey() {
    }

    public AddressKey(Long id, Long colocationId) {
        super(id, colocationId);
    }

}
