package io.pivotal.bds.gemfire.data.ecom;

import java.util.Date;
import java.util.Set;

public class Shipment {

    private ShipmentKey key;
    private OrderKey orderKey;
    private Set<OrderItemKey> orderItemKeys;
    private ShippingMethodKey shippingMethodKey;
    private String trackingNumber;
    private Date shippedDate;
    private Date expectedArrivalDate;
    private Date actualArrivalDate;
    private ShipmentStatus status;

    public Shipment() {
    }

    public Shipment(ShipmentKey key, OrderKey orderKey, Set<OrderItemKey> orderItemKeys, ShippingMethodKey shippingMethodKey,
            String trackingNumber, Date shippedDate, Date expectedArrivalDate, Date actualArrivalDate, ShipmentStatus status) {
        this.key = key;
        this.orderKey = orderKey;
        this.orderItemKeys = orderItemKeys;
        this.shippingMethodKey = shippingMethodKey;
        this.trackingNumber = trackingNumber;
        this.shippedDate = shippedDate;
        this.expectedArrivalDate = expectedArrivalDate;
        this.actualArrivalDate = actualArrivalDate;
        this.status = status;
    }

    public ShipmentKey getKey() {
        return key;
    }

    public void setKey(ShipmentKey key) {
        this.key = key;
    }

    public OrderKey getOrderKey() {
        return orderKey;
    }

    public void setOrderKey(OrderKey orderKey) {
        this.orderKey = orderKey;
    }

    public Set<OrderItemKey> getOrderItemKeys() {
        return orderItemKeys;
    }

    public void setOrderItemKeys(Set<OrderItemKey> orderItemKeys) {
        this.orderItemKeys = orderItemKeys;
    }

    public ShippingMethodKey getShippingMethodKey() {
        return shippingMethodKey;
    }

    public void setShippingMethodKey(ShippingMethodKey shippingMethodKey) {
        this.shippingMethodKey = shippingMethodKey;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public Date getExpectedArrivalDate() {
        return expectedArrivalDate;
    }

    public void setExpectedArrivalDate(Date expectedArrivalDate) {
        this.expectedArrivalDate = expectedArrivalDate;
    }

    public Date getActualArrivalDate() {
        return actualArrivalDate;
    }

    public void setActualArrivalDate(Date actualArrivalDate) {
        this.actualArrivalDate = actualArrivalDate;
    }

    public ShipmentStatus getStatus() {
        return status;
    }

    public void setStatus(ShipmentStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Shipment [key=" + key + ", orderKey=" + orderKey + ", orderItemKeys=" + orderItemKeys + ", shippingMethodKey="
                + shippingMethodKey + ", trackingNumber=" + trackingNumber + ", shippedDate=" + shippedDate
                + ", expectedArrivalDate=" + expectedArrivalDate + ", actualArrivalDate=" + actualArrivalDate + ", status=" + status
                + "]";
    }

}
