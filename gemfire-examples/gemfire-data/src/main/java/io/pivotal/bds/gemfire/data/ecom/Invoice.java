package io.pivotal.bds.gemfire.data.ecom;

import java.util.Date;

public class Invoice {

    private InvoiceKey key;
    private OrderKey orderKey;
    private Date invoiceDate;

    public Invoice() {
    }

    public Invoice(InvoiceKey key, OrderKey orderKey, Date invoiceDate) {
        this.key = key;
        this.orderKey = orderKey;
        this.invoiceDate = invoiceDate;
    }

    public InvoiceKey getKey() {
        return key;
    }

    public void setKey(InvoiceKey key) {
        this.key = key;
    }

    public OrderKey getOrderKey() {
        return orderKey;
    }

    public void setOrderKey(OrderKey orderKey) {
        this.orderKey = orderKey;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    @Override
    public String toString() {
        return "Invoice [key=" + key + ", orderKey=" + orderKey + ", invoiceDate=" + invoiceDate + "]";
    }

}
