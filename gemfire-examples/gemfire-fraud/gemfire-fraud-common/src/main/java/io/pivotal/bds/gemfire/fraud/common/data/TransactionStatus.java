package io.pivotal.bds.gemfire.fraud.common.data;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

import io.pivotal.bds.gemfire.fraud.common.util.TransactionResultCodeCodec;
import io.pivotal.bds.gemfire.fraud.common.util.TransactionStatusCodeCodec;

@Table(name = "transaction_status", keyspace = "gemfire")
public class TransactionStatus {

    @PartitionKey
    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "account_id")
    private String accountId;

    @Column(name = "transaction_status", codec = TransactionStatusCodeCodec.class)
    private TransactionStatusCode transactionStatusCode;

    @Column(name = "transaction_result", codec = TransactionResultCodeCodec.class)
    private TransactionResultCode transactionResultCode;

    public TransactionStatus() {
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public TransactionStatusCode getTransactionStatusCode() {
        return transactionStatusCode;
    }

    public void setTransactionStatusCode(TransactionStatusCode transactionStatusCode) {
        this.transactionStatusCode = transactionStatusCode;
    }

    public TransactionResultCode getTransactionResultCode() {
        return transactionResultCode;
    }

    public void setTransactionResultCode(TransactionResultCode transactionResultCode) {
        this.transactionResultCode = transactionResultCode;
    }

    @Override
    public String toString() {
        return "TransactionStatus [transactionId=" + transactionId + ", accountId=" + accountId + ", transactionStatusCode="
                + transactionStatusCode + ", transactionResultCode=" + transactionResultCode + "]";
    }

}
