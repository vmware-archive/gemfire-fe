package io.pivotal.bds.gemfire.fraud.common.data;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

@Table(name = "card_balance", keyspace = "gemfire")
public class CardBalance {

    @PartitionKey
    @Column(name = "card_id")
    private String cardId;

    @Column(name = "account_id")
    private String accountId;

    @Column(name = "card_balance")
    private double balance;

    public CardBalance() {
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
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
        CardBalance other = (CardBalance) obj;
        if (accountId == null) {
            if (other.accountId != null)
                return false;
        } else if (!accountId.equals(other.accountId))
            return false;
        if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
            return false;
        if (cardId == null) {
            if (other.cardId != null)
                return false;
        } else if (!cardId.equals(other.cardId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CardBalance [cardId=" + cardId + ", accountId=" + accountId + ", balance=" + balance + "]";
    }

}
