package io.pivotal.bds.gemfire.data.ecom;

import io.pivotal.bds.gemfire.key.BaseKey;

public class ShippingMethodKey extends BaseKey<Long> {

    public ShippingMethodKey() {
    }

    public ShippingMethodKey(Long id) {
        super(id);
    }

}
