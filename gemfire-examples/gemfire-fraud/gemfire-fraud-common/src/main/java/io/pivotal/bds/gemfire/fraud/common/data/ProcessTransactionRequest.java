package io.pivotal.bds.gemfire.fraud.common.data;

import java.util.Date;

public class ProcessTransactionRequest {

    private Date createdOn;
    private String cardNumber;
    private int expiration;
    private String ccv;
    private String nameOnCard;
    private String vendorId;
    private double amount;
    private boolean cardPresent;

    public ProcessTransactionRequest() {
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getExpiration() {
        return expiration;
    }

    public void setExpiration(int expiration) {
        this.expiration = expiration;
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

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isCardPresent() {
        return cardPresent;
    }

    public void setCardPresent(boolean cardPresent) {
        this.cardPresent = cardPresent;
    }

    @Override
    public int hashCode() {
        return cardNumber.hashCode();
    }

    @Override
    public String toString() {
        return "ProcessTransactionRequest [createdOn=" + createdOn + ", cardNumber=" + cardNumber + ", expiration=" + expiration
                + ", ccv=" + ccv + ", nameOnCard=" + nameOnCard + ", vendorId=" + vendorId + ", amount=" + amount + ", cardPresent="
                + cardPresent + "]";
    }

}
