package io.pivotal.bds.gemfire.xrefs.common;

import java.util.Date;

public class AccountHistory {

    private AccountHistoryKey key;
    private AccountKey accountKey;
    private Date updatedOn;
    private double balance;

    public AccountHistory() {
    }

    public AccountHistory(AccountHistoryKey key, AccountKey accountKey, Date updatedOn, double balance) {
        this.key = key;
        this.accountKey = accountKey;
        this.updatedOn = updatedOn;
        this.balance = balance;
    }

    public AccountHistoryKey getKey() {
        return key;
    }

    public void setKey(AccountHistoryKey key) {
        this.key = key;
    }

    public AccountKey getAccountKey() {
        return accountKey;
    }

    public void setAccountKey(AccountKey accountKey) {
        this.accountKey = accountKey;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "AccountHistory [key=" + key + ", accountKey=" + accountKey + ", updatedOn=" + updatedOn + ", balance=" + balance
                + "]";
    }

}
