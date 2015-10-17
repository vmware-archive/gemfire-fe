package io.pivotal.bds.gemfire.analytics.common;

public class Sensor {

    private SensorKey key;
    private String description;
    private SensorType type;
    private SensorUnit unit;

    public Sensor() {
    }

    public Sensor(SensorKey key, String description, SensorType type, SensorUnit unit) {
        this.key = key;
        this.description = description;
        this.type = type;
        this.unit = unit;
    }

    public SensorKey getKey() {
        return key;
    }

    public void setKey(SensorKey key) {
        this.key = key;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SensorType getType() {
        return type;
    }

    public void setType(SensorType type) {
        this.type = type;
    }

    public SensorUnit getUnit() {
        return unit;
    }

    public void setUnit(SensorUnit unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Sensor [key=" + key + ", description=" + description + ", type=" + type + ", unit=" + unit + "]";
    }

}
