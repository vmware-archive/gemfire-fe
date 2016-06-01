package io.pivotal.bds.gemfire.fraud.common.data;

import java.util.Date;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

@Table(name = "transaction", keyspace = "gemfire")
public class Transaction {

    @PartitionKey
    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "account_id")
    private String accountId;

    @Column(name = "card_id")
    private String cardId;

    @Column(name = "vendor_id")
    private String vendorId;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "transaction_amount")
    private double amount;

    public Transaction() {
    }

    public Transaction(Transaction txn) {
        this.transactionId = txn.transactionId;
        this.accountId = txn.accountId;
        this.cardId = txn.cardId;
        this.vendorId = txn.vendorId;
        this.createdOn = txn.createdOn;
        this.amount = txn.amount;
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

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction [transactionId=" + transactionId + ", accountId=" + accountId + ", cardId=" + cardId + ", vendorId="
                + vendorId + ", createdOn=" + createdOn + ", amount=" + amount + "]";
    }

}
