package io.pivotal.bds.gemfire.data.securities;

import java.util.Date;

public class SecurityPriceStatus {

    private SecurityKey key;
    private Date updatedOn;
    private double price;

    public SecurityPriceStatus() {
    }

    public SecurityPriceStatus(SecurityKey key, Date updatedOn, double price) {
        this.key = key;
        this.updatedOn = updatedOn;
        this.price = price;
    }

    public SecurityKey getKey() {
        return key;
    }

    public void setKey(SecurityKey key) {
        this.key = key;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "SecurityPriceStatus [key=" + key + ", updatedOn=" + updatedOn + ", price=" + price + "]";
    }

}
