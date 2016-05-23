package io.pivotal.bds.gemfire.cassandra.data;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

import io.pivotal.bds.gemfire.cassandra.util.AccountStatusCodec;

@Table(name = "account", keyspace = "gemfire")
public class Account {

    @PartitionKey
    @Column(name = "account_id")
    private String accountId;

    @Column(name = "account_status", codec = AccountStatusCodec.class)
    private AccountStatus status;

    @Column(name = "account_limit")
    private double limit;

    public Account() {
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "Account [accountId=" + accountId + ", status=" + status + ", limit=" + limit + "]";
    }

}
