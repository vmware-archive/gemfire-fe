package io.pivotal.bds.gemfire.localregion.data;

import java.util.Map;

import io.pivotal.bds.gemfire.data.ecom.Account;
import io.pivotal.bds.gemfire.data.ecom.Order;
import io.pivotal.bds.gemfire.data.ecom.OrderKey;

public class AccountAggregate {

    private Account account;
    private Map<OrderKey, Order> orders;

    public AccountAggregate() {
    }

    public AccountAggregate(Account account, Map<OrderKey, Order> orders) {
        this.account = account;
        this.orders = orders;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Map<OrderKey, Order> getOrders() {
        return orders;
    }

    public void setOrders(Map<OrderKey, Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "AccountAggregate [account=" + account + ", orders=" + orders + "]";
    }

}
