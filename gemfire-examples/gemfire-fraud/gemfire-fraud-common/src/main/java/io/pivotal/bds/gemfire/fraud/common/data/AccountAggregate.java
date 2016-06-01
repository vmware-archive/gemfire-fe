package io.pivotal.bds.gemfire.fraud.common.data;

import java.util.List;

public class AccountAggregate {

    private Account account;
    private List<TransactionAggregate> transactions;

    public AccountAggregate() {
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<TransactionAggregate> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionAggregate> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "AccountAggregate [account=" + account + ", transactions=" + transactions + "]";
    }

}
