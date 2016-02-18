package io.pivotal.bds.gemfire.ml.util;

import java.util.Map;

import org.springframework.util.Assert;

public class PropertiesSupport {

    public static String getRequiredStringProperty(Map<String, Object> properties, String name) {
        String s = getProperty(properties, name, String.class, null);
        Assert.notNull(s, "Missing string property " + name);
        return s;
    }

    public static Integer getIntegerProperty(Map<String, Object> properties, String name, Integer def) {
        return getProperty(properties, name, Integer.class, def);
    }

    public static Double getDoubleProperty(Map<String, Object> properties, String name, Double def) {
        return getProperty(properties, name, Double.class, def);
    }

    public static Integer getRequiredIntegerProperty(Map<String, Object> properties, String name) {
        Integer i = getProperty(properties, name, Integer.class, null);
        Assert.notNull(i, "Missing integer property " + name);
        return i;
    }

    public static Double getRequiredDoubleProperty(Map<String, Object> properties, String name) {
        Double d = getProperty(properties, name, Double.class, null);
        Assert.notNull(d, "Missing double property " + name);
        return d;
    }

    public static Boolean getBooleanProperty(Map<String, Object> properties, String name, Boolean def) {
        Boolean b = getProperty(properties, name, Boolean.class, def);
        return b;
    }

    public static <V> V getRequiredProperty(Map<String, Object> props, String name, Class<V> type) {
        V v = getProperty(props, name, type, null);
        Assert.notNull(v, "Missing property " + name);
        return v;
    }

    @SuppressWarnings("unchecked")
    public static <V> V getProperty(Map<String, Object> props, String name, Class<V> type, V def) {
        Object o = props.get(name);

        if (o == null) {
            return def;
        }

        if (o.getClass() != type) {
            throw new IllegalArgumentException(
                    "Property " + name + " is the wrong type: expected " + type.getName() + ", actual " + o.getClass().getName());
        }

        return (V) o;
    }
}
