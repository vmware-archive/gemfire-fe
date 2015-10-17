package org.jcollectd.agent.protocol;

import java.util.HashMap;
import java.util.Map;

/**
 * Protocol Part types from collectd/src/network.h
 * @see <a href="http://collectd.org/wiki/index.php/Binary_protocol">Collect Binary Protocol</a>
 */
public enum Part {

    UNKNOWN(-1),
    /**
     * Host [String] - The name of the host to associate with subsequent data values
     */
    HOST(0x0000),

    /**
     * Time [Numeric] - The timestamp to associate with subsequent data values, unix time format (seconds since epoch)
     */
    TIME(0x0001),

    /**
     * Plugin [String] - The plugin name to associate with subsequent data values, e.g. "cpu"
     */
    PLUGIN(0x0002),

    /**
     * Plugin instance [String] - The plugin instance name to associate with subsequent data values, e.g. "1"
     */
    PLUGIN_INSTANCE(0x0003),

    /**
     * Type [String] - The type name to associate with subsequent data values, e.g. "cpu"
     */
    TYPE(0x0004),

    /**
     * Type instance [String]- The type instance name to associate with subsequent data values, e.g. "idle"
     */
    TYPE_INSTANCE(0x0005),

    /**
     * Values - Identifier values
     */
    VALUES(0x0006),

    /**
     * Interval [Numeric] - used to set the "step" when creating new RRDs unless rrdtool plugin forces StepSize. Also used to detect values that have timed out.
     */
    INTERVAL(0x0007),

    /**
     * Timestamp [Numeric] - The timestamp to associate with subsequent data values. Time is defined in 2–30 seconds since epoch. New in Version 5.0.
     *
     * @see <a href="http://collectd.org/wiki/index.php/High_resolution_time_format">High resolution time format</a>
     */
    TIME_HIRES(0x0008),

    /**
     * Interval [Numeric] - The interval in which subsequent data values are collected. The interval is given in 2–30 seconds. New in Version 5.0.
     *
     * @see <a href="http://collectd.org/wiki/index.php/High_resolution_time_format">High resolution time format</a>
     */
    INTERVAL_HIRES(0x0009),

    /**
     * Notification Message [String]
     */
    MESSAGE(0x0100),

    /**
     * Notification Sevirity [Numeric]
     */
    SEVERITY(0x0101),

    /**
     * Signature (HMAC-SHA-256)
     */
    SIG(0x0200),

    /**
     * Encryption (AES-256/OFB/SHA-1)
     */
    ENC(0x0210);


    private final static Map<Integer, Part> lookup = new HashMap<Integer, Part>();

    static{
        for (Part part : Part.values()) {
            lookup.put(part.id, part);
        }
    }

    public final int id;
    Part(int id) {
        this.id = id;
    }

    public static Part find(int id) {
        return lookup.containsKey(id)  ? lookup.get(id) : UNKNOWN;
    }

}
