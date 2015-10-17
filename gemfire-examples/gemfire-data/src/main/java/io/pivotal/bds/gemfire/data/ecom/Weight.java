package io.pivotal.bds.gemfire.data.ecom;

public class Weight {

    private double weight;
    private WeightUnit unit;

    public Weight() {
    }

    public Weight(double weight, WeightUnit unit) {
        this.weight = weight;
        this.unit = unit;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public WeightUnit getUnit() {
        return unit;
    }

    public void setUnit(WeightUnit unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Weight [weight=" + weight + ", unit=" + unit + "]";
    }

}
