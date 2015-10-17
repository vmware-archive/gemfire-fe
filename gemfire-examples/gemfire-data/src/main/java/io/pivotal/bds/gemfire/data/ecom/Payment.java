package io.pivotal.bds.gemfire.data.ecom;

import java.util.Date;

public class Payment {

    private PaymentKey key;
    private OrderKey orderKey;
    private PaymentMethodKey paymentMethodKey;
    private Date paymentDate;
    private double amount;

    public Payment() {
    }

    public Payment(PaymentKey key, OrderKey orderKey, PaymentMethodKey paymentMethodKey, Date paymentDate, double amount) {
        this.key = key;
        this.orderKey = orderKey;
        this.paymentMethodKey = paymentMethodKey;
        this.paymentDate = paymentDate;
        this.amount = amount;
    }

    public PaymentKey getKey() {
        return key;
    }

    public void setKey(PaymentKey key) {
        this.key = key;
    }

    public OrderKey getOrderKey() {
        return orderKey;
    }

    public void setOrderKey(OrderKey orderKey) {
        this.orderKey = orderKey;
    }

    public PaymentMethodKey getPaymentMethodKey() {
        return paymentMethodKey;
    }

    public void setPaymentMethodKey(PaymentMethodKey paymentMethodKey) {
        this.paymentMethodKey = paymentMethodKey;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Payment [key=" + key + ", orderKey=" + orderKey + ", paymentMethodKey=" + paymentMethodKey + ", paymentDate="
                + paymentDate + ", amount=" + amount + "]";
    }

}
