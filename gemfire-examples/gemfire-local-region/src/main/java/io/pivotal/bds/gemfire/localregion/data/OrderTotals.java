package io.pivotal.bds.gemfire.localregion.data;

public class OrderTotals {

    private int count = 0;
    private double total = 0.0;

    public OrderTotals() {
    }

    public OrderTotals(int count, double total) {
        this.count = count;
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "OrderTotals [count=" + count + ", total=" + total + "]";
    }

}
