package io.pivotal.bds.gemfire.ml.util;

import java.util.Properties;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

public class PropertiesSupport {

    public static Properties stripPrefix(Properties props, String prefix) {
        Properties p = new Properties();

        for (String pn : props.stringPropertyNames()) {
            if (pn.startsWith(prefix)) {
                String npn = pn.substring(prefix.length());
                String pv = props.getProperty(pn);
                p.setProperty(npn, pv);
            }
        }

        return p;
    }

    public static String getRequiredStringProperty(Properties properties, String name) {
        String s = properties.getProperty(name);
        Assert.notNull(s, "Missing string property " + name);
        return s;
    }

    public static Integer getIntegerProperty(Properties properties, String name, Integer def) {
        String s = properties.getProperty(name);

        if (!StringUtils.hasText(s)) {
            return def;
        }

        try {
            return new Integer(s.trim());
        } catch (Exception x) {
            throw new IllegalArgumentException("Property " + name + " is not a valid integer");
        }
    }

    public static Double getDoubleProperty(Properties properties, String name, Double def) {
        String s = properties.getProperty(name);

        if (!StringUtils.hasText(s)) {
            return def;
        }

        try {
            return new Double(s.trim());
        } catch (Exception x) {
            throw new IllegalArgumentException("Property " + name + " is not a valid double");
        }
    }

    public static Integer getRequiredIntegerProperty(Properties properties, String name) {
        Integer i = getIntegerProperty(properties, name, null);
        Assert.notNull(i, "Missing integer property " + name);
        return i;
    }

    public static Double getRequiredDoubleProperty(Properties properties, String name) {
        Double d = getDoubleProperty(properties, name, null);
        Assert.notNull(d, "Missing double property " + name);
        return d;
    }
}
