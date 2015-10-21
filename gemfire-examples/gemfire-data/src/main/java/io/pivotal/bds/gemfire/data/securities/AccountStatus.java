package io.pivotal.bds.gemfire.data.securities;

import java.util.Date;

public class AccountStatus {

    private AccountKey key;
    private Date lastUpdatedOn;
    private double balance;

    public AccountStatus() {
    }

    public AccountStatus(AccountKey key, Date lastUpdatedOn, double balance) {
        this.key = key;
        this.lastUpdatedOn = lastUpdatedOn;
        this.balance = balance;
    }

    public AccountKey getKey() {
        return key;
    }

    public void setKey(AccountKey key) {
        this.key = key;
    }

    public Date getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(Date lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
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
        AccountStatus other = (AccountStatus) obj;
        if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
            return false;
        if (key == null) {
            if (other.key != null)
                return false;
        } else if (!key.equals(other.key))
            return false;
        if (lastUpdatedOn == null) {
            if (other.lastUpdatedOn != null)
                return false;
        } else if (!lastUpdatedOn.equals(other.lastUpdatedOn))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "AccountStatus [key=" + key + ", lastUpdatedOn=" + lastUpdatedOn + ", balance=" + balance + "]";
    }

}
