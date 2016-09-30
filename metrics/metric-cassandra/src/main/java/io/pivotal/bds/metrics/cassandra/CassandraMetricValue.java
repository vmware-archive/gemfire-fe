package io.pivotal.bds.metrics.cassandra;

public class CassandraMetricValue {

    private String name;
    private String type;
    private String unit;
    private double value;

    public CassandraMetricValue(String name, String type, String unit, double value) {
        this.name = name;
        this.type = type;
        this.unit = unit;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getUnit() {
        return unit;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "CassandraMetricValue [name=" + name + ", type=" + type + ", unit=" + unit + ", value=" + value + "]";
    }

}
