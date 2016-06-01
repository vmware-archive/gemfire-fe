package io.pivotal.bds.gemfire.fraud.common.data;

public class ProcessTransactionResponse {

    private String transactionId;
    private TransactionResultCode resultCode;

    public ProcessTransactionResponse() {
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public TransactionResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(TransactionResultCode resultCode) {
        this.resultCode = resultCode;
    }

    @Override
    public String toString() {
        return "ProcessTransactionResponse [transactionId=" + transactionId + ", resultCode=" + resultCode + "]";
    }

}
