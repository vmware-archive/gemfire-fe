package io.pivotal.bds.gemfire.fraud.common.data;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

@Table(name = "account_balance", keyspace = "gemfire")
public class AccountBalance {

    @PartitionKey
    @Column(name = "account_id")
    private String accountId;

    @Column(name = "account_balance")
    private double balance;

    public AccountBalance() {
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AccountBalance other = (AccountBalance) obj;
        if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "AccountBalance [accountId=" + accountId + ", balance=" + balance + "]";
    }

}
