package io.pivotal.bds.gemfire.data.securities;

import java.util.Date;

public class Trade {

    private TradeKey key;
    private SecurityKey securityKey;
    private AccountKey accountKey;
    private Date date;
    private int quantity;
    private double price;

    public Trade() {
    }

    public Trade(TradeKey key, SecurityKey securityKey, AccountKey accountKey, Date date, int quantity, double price) {
        this.key = key;
        this.securityKey = securityKey;
        this.accountKey = accountKey;
        this.date = date;
        this.quantity = quantity;
        this.price = price;
    }

    public TradeKey getKey() {
        return key;
    }

    public void setKey(TradeKey key) {
        this.key = key;
    }

    public SecurityKey getSecurityKey() {
        return securityKey;
    }

    public void setSecurityKey(SecurityKey securityKey) {
        this.securityKey = securityKey;
    }

    public AccountKey getAccountKey() {
        return accountKey;
    }

    public void setAccountKey(AccountKey accountKey) {
        this.accountKey = accountKey;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Trade [key=" + key + ", securityKey=" + securityKey + ", accountKey=" + accountKey + ", date=" + date
                + ", quantity=" + quantity + ", price=" + price + "]";
    }

}
