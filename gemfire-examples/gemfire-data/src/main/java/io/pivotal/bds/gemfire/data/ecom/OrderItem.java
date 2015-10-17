package io.pivotal.bds.gemfire.data.ecom;

public class OrderItem {

    private OrderItemKey key;
    private CatalogItemKey catalogItemKey;
    private int quantity;
    private double price;
    private double total;

    public OrderItem() {
    }

    public OrderItem(OrderItemKey key, CatalogItemKey catalogItemKey, int quantity, double price, double total) {
        this.key = key;
        this.catalogItemKey = catalogItemKey;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
    }

    public OrderItemKey getKey() {
        return key;
    }

    public void setKey(OrderItemKey key) {
        this.key = key;
    }

    public CatalogItemKey getCatalogItemKey() {
        return catalogItemKey;
    }

    public void setCatalogItemKey(CatalogItemKey catalogItemKey) {
        this.catalogItemKey = catalogItemKey;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "OrderItem [key=" + key + ", catalogItemKey=" + catalogItemKey + ", quantity=" + quantity + ", price=" + price
                + ", total=" + total + "]";
    }

}
