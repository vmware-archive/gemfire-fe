package io.pivotal.bds.gemfire.fraud.common.util;

import com.datastax.driver.extras.codecs.enums.EnumOrdinalCodec;

import io.pivotal.bds.gemfire.fraud.common.data.TransactionStatusCode;

public class TransactionStatusCodeCodec extends EnumOrdinalCodec<TransactionStatusCode> {

    public TransactionStatusCodeCodec() {
        super(TransactionStatusCode.class);
    }

}
