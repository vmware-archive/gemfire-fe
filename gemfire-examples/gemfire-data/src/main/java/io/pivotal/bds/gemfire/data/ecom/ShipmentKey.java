package io.pivotal.bds.gemfire.data.ecom;

import io.pivotal.bds.gemfire.key.BaseColocationKey;

public class ShipmentKey extends BaseColocationKey<Long, Long> {

    public ShipmentKey() {
    }

    public ShipmentKey(Long id, Long colocationId) {
        super(id, colocationId);
    }

}
