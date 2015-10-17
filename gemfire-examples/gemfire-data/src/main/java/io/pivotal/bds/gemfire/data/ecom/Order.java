package io.pivotal.bds.gemfire.data.ecom;

import java.util.Date;
import java.util.Set;

public class Order {

    private OrderKey key;
    private AccountKey accountKey;
    private Set<OrderItemKey> orderItemKeys;
    private Date orderedOn;
    private AddressKey billingAddressKey;
    private AddressKey shippingAddressKey;
    private PaymentMethodKey paymentMethodKey;
    private ShippingMethodKey shippingMethodKey;
    private double subtotal;
    private double shipping;
    private double total;

    public Order() {
    }

    public Order(OrderKey key, AccountKey accountKey, Set<OrderItemKey> orderItemKeys, Date orderedOn, AddressKey billingAddressKey,
            AddressKey shippingAddressKey, PaymentMethodKey paymentMethodKey, ShippingMethodKey shippingMethodKey, double subtotal,
            double shipping, double total) {
        this.key = key;
        this.accountKey = accountKey;
        this.orderItemKeys = orderItemKeys;
        this.orderedOn = orderedOn;
        this.billingAddressKey = billingAddressKey;
        this.shippingAddressKey = shippingAddressKey;
        this.paymentMethodKey = paymentMethodKey;
        this.shippingMethodKey = shippingMethodKey;
        this.subtotal = subtotal;
        this.shipping = shipping;
        this.total = total;
    }

    public OrderKey getKey() {
        return key;
    }

    public void setKey(OrderKey key) {
        this.key = key;
    }

    public AccountKey getAccountKey() {
        return accountKey;
    }

    public void setAccountKey(AccountKey accountKey) {
        this.accountKey = accountKey;
    }

    public Set<OrderItemKey> getOrderItemKeys() {
        return orderItemKeys;
    }

    public void setOrderItemKeys(Set<OrderItemKey> orderItemKeys) {
        this.orderItemKeys = orderItemKeys;
    }

    public Date getOrderedOn() {
        return orderedOn;
    }

    public void setOrderedOn(Date orderedOn) {
        this.orderedOn = orderedOn;
    }

    public AddressKey getBillingAddressKey() {
        return billingAddressKey;
    }

    public void setBillingAddressKey(AddressKey billingAddressKey) {
        this.billingAddressKey = billingAddressKey;
    }

    public AddressKey getShippingAddressKey() {
        return shippingAddressKey;
    }

    public void setShippingAddressKey(AddressKey shippingAddressKey) {
        this.shippingAddressKey = shippingAddressKey;
    }

    public PaymentMethodKey getPaymentMethodKey() {
        return paymentMethodKey;
    }

    public void setPaymentMethodKey(PaymentMethodKey paymentMethodKey) {
        this.paymentMethodKey = paymentMethodKey;
    }

    public ShippingMethodKey getShippingMethodKey() {
        return shippingMethodKey;
    }

    public void setShippingMethodKey(ShippingMethodKey shippingMethodKey) {
        this.shippingMethodKey = shippingMethodKey;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getShipping() {
        return shipping;
    }

    public void setShipping(double shipping) {
        this.shipping = shipping;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order [key=" + key + ", accountKey=" + accountKey + ", orderItemKeys=" + orderItemKeys + ", orderedOn=" + orderedOn
                + ", billingAddressKey=" + billingAddressKey + ", shippingAddressKey=" + shippingAddressKey + ", paymentMethodKey="
                + paymentMethodKey + ", shippingMethodKey=" + shippingMethodKey + ", subtotal=" + subtotal + ", shipping="
                + shipping + ", total=" + total + "]";
    }

}
