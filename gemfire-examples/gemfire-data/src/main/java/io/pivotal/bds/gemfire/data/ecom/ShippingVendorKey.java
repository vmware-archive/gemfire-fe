package io.pivotal.bds.gemfire.data.ecom;

import io.pivotal.bds.gemfire.key.BaseKey;

public class ShippingVendorKey extends BaseKey<Long> {

    public ShippingVendorKey() {
    }

    public ShippingVendorKey(Long id) {
        super(id);
    }

}
