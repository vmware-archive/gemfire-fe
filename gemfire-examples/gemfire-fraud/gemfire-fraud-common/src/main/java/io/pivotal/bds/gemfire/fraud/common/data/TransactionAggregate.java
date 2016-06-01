package io.pivotal.bds.gemfire.fraud.common.data;

import java.util.List;

public class TransactionAggregate {

    private Transaction transaction;
    private List<TransactionHistory> transactionHistory;

    public TransactionAggregate() {
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public List<TransactionHistory> getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(List<TransactionHistory> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    @Override
    public String toString() {
        return "TransactionAggregate [transaction=" + transaction + ", transactionHistory=" + transactionHistory + "]";
    }

}
