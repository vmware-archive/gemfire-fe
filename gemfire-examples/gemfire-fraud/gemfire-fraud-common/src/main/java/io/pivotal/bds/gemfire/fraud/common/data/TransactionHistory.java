package io.pivotal.bds.gemfire.fraud.common.data;

import java.util.Date;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

import io.pivotal.bds.gemfire.fraud.common.util.TransactionResultCodeCodec;
import io.pivotal.bds.gemfire.fraud.common.util.TransactionStatusCodeCodec;

@Table(name = "transaction_history", keyspace = "gemfire")
public class TransactionHistory {

    @PartitionKey
    @Column(name = "transaction_history_id")
    private String transactionHistoryId;

    @Column(name = "updated_on")
    private Date updatedOn;

    @Column(name = "transaction_status", codec = TransactionStatusCodeCodec.class)
    private TransactionStatusCode transactionStatusCode;

    @Column(name = "transaction_result", codec = TransactionResultCodeCodec.class)
    private TransactionResultCode transactionResultCode;

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

    public TransactionHistory() {
    }

    public TransactionHistory(Transaction txn) {
        this.transactionId = txn.getTransactionId();
        this.accountId = txn.getAccountId();
        this.cardId = txn.getCardId();
        this.vendorId = txn.getVendorId();
        this.createdOn = txn.getCreatedOn();
        this.amount = txn.getAmount();
    }

    public String getTransactionHistoryId() {
        return transactionHistoryId;
    }

    public void setTransactionHistoryId(String transactionHistoryId) {
        this.transactionHistoryId = transactionHistoryId;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public TransactionStatusCode getTransactionStatusCode() {
        return transactionStatusCode;
    }

    public void setTransactionStatusCode(TransactionStatusCode transactionStatusCode) {
        this.transactionStatusCode = transactionStatusCode;
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

    public TransactionResultCode getTransactionResultCode() {
        return transactionResultCode;
    }

    public void setTransactionResultCode(TransactionResultCode transactionResultCode) {
        this.transactionResultCode = transactionResultCode;
    }

    @Override
    public String toString() {
        return "TransactionHistory [transactionHistoryId=" + transactionHistoryId + ", updatedOn=" + updatedOn
                + ", transactionStatusCode=" + transactionStatusCode + ", transactionResultCode=" + transactionResultCode
                + ", transactionId=" + transactionId + ", accountId=" + accountId + ", cardId=" + cardId + ", vendorId=" + vendorId
                + ", createdOn=" + createdOn + ", amount=" + amount + "]";
    }

}
