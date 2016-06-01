package io.pivotal.bds.gemfire.fraud.common.util;

import com.datastax.driver.extras.codecs.enums.EnumOrdinalCodec;

import io.pivotal.bds.gemfire.fraud.common.data.VendorStatus;

public class VendorStatusCodec extends EnumOrdinalCodec<VendorStatus> {

    public VendorStatusCodec() {
        super(VendorStatus.class);
    }

}
