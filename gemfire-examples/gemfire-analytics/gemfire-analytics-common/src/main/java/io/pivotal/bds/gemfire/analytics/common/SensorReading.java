package io.pivotal.bds.gemfire.analytics.common;

import java.util.Date;

public class SensorReading {

    private SensorReadingKey key;
    private SensorKey sensorKey;
    private Date timestamp;
    private double value;

    public SensorReading() {
    }

    public SensorReading(SensorReadingKey key, SensorKey sensorKey, Date timestamp, double value) {
        this.key = key;
        this.sensorKey = sensorKey;
        this.timestamp = timestamp;
        this.value = value;
    }

    public SensorReadingKey getKey() {
        return key;
    }

    public void setKey(SensorReadingKey key) {
        this.key = key;
    }

    public SensorKey getSensorKey() {
        return sensorKey;
    }

    public void setSensorKey(SensorKey sensorKey) {
        this.sensorKey = sensorKey;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SensorReading [key=" + key + ", sensorKey=" + sensorKey + ", timestamp=" + timestamp + ", value=" + value + "]";
    }

}
