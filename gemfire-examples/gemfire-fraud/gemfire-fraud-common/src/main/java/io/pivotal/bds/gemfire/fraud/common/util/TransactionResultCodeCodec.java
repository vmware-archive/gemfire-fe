package io.pivotal.bds.gemfire.fraud.common.util;

import com.datastax.driver.extras.codecs.enums.EnumOrdinalCodec;

import io.pivotal.bds.gemfire.fraud.common.data.TransactionResultCode;

public class TransactionResultCodeCodec extends EnumOrdinalCodec<TransactionResultCode> {

    public TransactionResultCodeCodec() {
        super(TransactionResultCode.class);
    }

}
