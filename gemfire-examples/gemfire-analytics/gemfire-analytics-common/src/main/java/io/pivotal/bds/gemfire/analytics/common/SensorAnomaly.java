package io.pivotal.bds.gemfire.analytics.common;

public class SensorAnomaly {

    private SensorAnomalyKey key;
    private SensorReadingKey readingKey;
    private SensorKey sensorKey;

    public SensorAnomaly() {
    }

    public SensorAnomaly(SensorAnomalyKey key, SensorReadingKey readingKey, SensorKey sensorKey) {
        this.key = key;
        this.readingKey = readingKey;
        this.sensorKey = sensorKey;
    }

    public SensorAnomalyKey getKey() {
        return key;
    }

    public void setKey(SensorAnomalyKey key) {
        this.key = key;
    }

    public SensorReadingKey getReadingKey() {
        return readingKey;
    }

    public void setReadingKey(SensorReadingKey readingKey) {
        this.readingKey = readingKey;
    }

    public SensorKey getSensorKey() {
        return sensorKey;
    }

    public void setSensorKey(SensorKey sensorKey) {
        this.sensorKey = sensorKey;
    }

    @Override
    public String toString() {
        return "SensorAnomaly [key=" + key + ", readingKey=" + readingKey + ", sensorKey=" + sensorKey + "]";
    }

}
