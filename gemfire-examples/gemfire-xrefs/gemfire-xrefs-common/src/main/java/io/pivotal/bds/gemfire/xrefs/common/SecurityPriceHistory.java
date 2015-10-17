package io.pivotal.bds.gemfire.xrefs.common;

import java.util.Date;

public class SecurityPriceHistory {

    private SecurityPriceHistoryKey key;
    private Date updatedOn;
    private SecurityKey securityKey;
    private double price;

    public SecurityPriceHistory() {
    }

    public SecurityPriceHistory(SecurityPriceHistoryKey key, Date updatedOn, SecurityKey securityKey, double price) {
        this.key = key;
        this.updatedOn = updatedOn;
        this.securityKey = securityKey;
        this.price = price;
    }

    public SecurityPriceHistoryKey getKey() {
        return key;
    }

    public void setKey(SecurityPriceHistoryKey key) {
        this.key = key;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public SecurityKey getSecurityKey() {
        return securityKey;
    }

    public void setSecurityKey(SecurityKey securityKey) {
        this.securityKey = securityKey;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "SecurityPriceHistory [key=" + key + ", updatedOn=" + updatedOn + ", securityKey=" + securityKey + ", price=" + price
                + "]";
    }

}
