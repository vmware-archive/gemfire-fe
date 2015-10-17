package io.pivotal.bds.gemfire.data.ecom;

public class Price {

    private int minimumQuantity;
    private int maximumQuantity;
    private double price;

    public Price() {
    }

    public Price(int minimumQuantity, int maximumQuantity, double price) {
        this.minimumQuantity = minimumQuantity;
        this.maximumQuantity = maximumQuantity;
        this.price = price;
    }

    public int getMinimumQuantity() {
        return minimumQuantity;
    }

    public void setMinimumQuantity(int minimumQuantity) {
        this.minimumQuantity = minimumQuantity;
    }

    public int getMaximumQuantity() {
        return maximumQuantity;
    }

    public void setMaximumQuantity(int maximumQuantity) {
        this.maximumQuantity = maximumQuantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Price [minimumQuantity=" + minimumQuantity + ", maximumQuantity=" + maximumQuantity + ", price=" + price + "]";
    }

}
