package io.pivotal.bds.gemfire.fraud.common.util;

import com.datastax.driver.extras.codecs.enums.EnumOrdinalCodec;

import io.pivotal.bds.gemfire.fraud.common.data.VendorType;

public class VendorTypeCodec extends EnumOrdinalCodec<VendorType> {

    public VendorTypeCodec() {
        super(VendorType.class);
    }

}
