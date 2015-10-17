package io.pivotal.bds.metrics.data;

public class MetricValue {

    private String name;
    private MetricType type;
    private MetricUnit unit;
    private double value;

    public MetricValue(String name, MetricType type, MetricUnit unit, double value) {
        this.name = name;
        this.type = type;
        this.unit = unit;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public MetricType getType() {
        return type;
    }

    public MetricUnit getUnit() {
        return unit;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "MetricValue [name=" + name + ", type=" + type + ", unit=" + unit + ", value=" + value + "]";
    }

}
