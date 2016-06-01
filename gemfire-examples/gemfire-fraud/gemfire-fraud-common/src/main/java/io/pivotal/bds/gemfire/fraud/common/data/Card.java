package io.pivotal.bds.gemfire.fraud.common.data;

import java.util.Date;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

@Table(name = "card", keyspace = "gemfire")
public class Card {

    @PartitionKey
    @Column(name = "card_id")
    private String cardId;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "expiration_date")
    private Date expirationDate;

    @Column(name = "ccv")
    private String ccv;

    @Column(name = "name_on_card")
    private String nameOnCard;

    @Column(name = "account_id")
    private String accountId;

    @Column(name = "card_limit")
    private double cardLimit;

    public Card() {
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCcv() {
        return ccv;
    }

    public void setCcv(String ccv) {
        this.ccv = ccv;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getCardLimit() {
        return cardLimit;
    }

    public void setCardLimit(double cardLimit) {
        this.cardLimit = cardLimit;
    }

    @Override
    public String toString() {
        return "Card [cardId=" + cardId + ", cardNumber=" + cardNumber + ", expirationDate=" + expirationDate + ", ccv=" + ccv
                + ", nameOnCard=" + nameOnCard + ", accountId=" + accountId + ", cardLimit=" + cardLimit + "]";
    }

}
