package io.pivotal.bds.gemfire.fraud.common.data;

import io.pivotal.bds.gemfire.fraud.common.key.AccountKey;
import io.pivotal.bds.gemfire.fraud.common.key.TransactionKey;

public class PartitionedProcessTransactionRequest {

    private AccountKey accountKey;
    private TransactionKey transactionKey;
    private ProcessTransactionRequest request;

    public PartitionedProcessTransactionRequest() {
    }

    public AccountKey getAccountKey() {
        return accountKey;
    }

    public void setAccountKey(AccountKey accountKey) {
        this.accountKey = accountKey;
    }

    public TransactionKey getTransactionKey() {
        return transactionKey;
    }

    public void setTransactionKey(TransactionKey transactionKey) {
        this.transactionKey = transactionKey;
    }

    public ProcessTransactionRequest getRequest() {
        return request;
    }

    public void setRequest(ProcessTransactionRequest request) {
        this.request = request;
    }

    @Override
    public int hashCode() {
        return accountKey.hashCode();
    }

    @Override
    public String toString() {
        return "PartitionedProcessTransactionRequest [accountKey=" + accountKey + ", transactionKey=" + transactionKey
                + ", request=" + request + "]";
    }

}
