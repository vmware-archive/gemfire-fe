package io.pivotal.bds.gemfire.util;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.EntryOperation;
import com.gemstone.gemfire.cache.PartitionResolver;

public class EncodedStringPartitionResolver<V> implements PartitionResolver<String, V>, Declarable {

    private char delimiter = ':';
    private Location location = Location.postfix;

    private static final Logger LOG = LogManager.getLogger(EncodedStringPartitionResolver.class);

    public EncodedStringPartitionResolver() {
    }

    public EncodedStringPartitionResolver(char delimiter, String location) {
        this.delimiter = delimiter;
        this.location = Location.valueOf(location);
    }

    public char getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(char delimiter) {
        this.delimiter = delimiter;
    }

    public String getLocation() {
        return location.name();
    }

    public void setLocation(String location) {
        this.location = Location.valueOf(location);
    }

    @Override
    public Object getRoutingObject(EntryOperation<String, V> op) {
        String key = op.getKey();
        LOG.debug("getRoutingObject: key={}", key);

        String ro = null;

        switch (location) {
            case postfix: {
                int p = key.lastIndexOf(delimiter);

                if (p < 0) {
                    throw new IllegalArgumentException("Delimiter " + delimiter + " not found in key " + key);
                } else if (p == key.length() - 1) {
                    throw new IllegalArgumentException("Delimiter " + delimiter + " is at the end of key " + key);
                }

                ro = key.substring(p + 1);
                break;
            }
            case prefix: {
                int p = key.indexOf(delimiter);

                if (p < 0) {
                    throw new IllegalArgumentException("Delimiter " + delimiter + " not found in key " + key);
                } else if (p == 0) {
                    throw new IllegalArgumentException("Delimiter " + delimiter + " is at the beginning of key " + key);
                }

                ro = key.substring(0, p);
                break;
            }
            default: {
                throw new IllegalArgumentException("Unknown location: " + location);
            }
        }

        LOG.debug("getRoutingObject: key={}, ro={}", key, ro);
        return ro;
    }

    @Override
    public void init(Properties props) {
        String sdelim = System.getProperty("gemfire.util.encoded-string-resolver.delimiter", "" + delimiter);
        sdelim = props.getProperty("delimiter", sdelim);

        String sloc = System.getProperty("gemfire.util.encoded-string-resolver.location", location.name());
        sloc = props.getProperty("location", sloc);

        LOG.info("init: delimiter={}, location={}", sdelim, sloc);

        check(sdelim, "delimiter");
        check(sloc, "location");

        if (sdelim.length() != 1) {
            throw new IllegalArgumentException("Delimiter must be one character: " + sdelim);
        }

        delimiter = sdelim.charAt(0);
        location = Location.valueOf(sloc);
    }

    private static void check(String s, String name) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException("Property " + name + " is missing");
        }
    }

    @Override
    public void close() {
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }

    private static enum Location {
        prefix, postfix;
    }
}
