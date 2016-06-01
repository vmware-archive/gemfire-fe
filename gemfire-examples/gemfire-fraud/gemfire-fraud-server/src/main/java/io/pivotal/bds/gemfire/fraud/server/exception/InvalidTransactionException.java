package io.pivotal.bds.gemfire.fraud.server.exception;

import io.pivotal.bds.gemfire.fraud.common.data.TransactionResultCode;

@SuppressWarnings("serial")
public class InvalidTransactionException extends Exception {

    private TransactionResultCode resultCode;

    public InvalidTransactionException(TransactionResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public TransactionResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(TransactionResultCode resultCode) {
        this.resultCode = resultCode;
    }

}
