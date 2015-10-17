/*
 * jcollectd
 * Copyright (C) 2009 Hyperic, Inc.
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; only version 2 of the License is applicable.
 * 
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin St, Fifth Floor, Boston, MA  02110-1301 USA
 */

package org.jcollectd.agent.api;

/**
 * Java representation of collectd/src/plugin.h:data_source_t structure.
 */
public class DataSource {

    private static final String NAN = "U";

    private String _name;
    private Type _type;
    private double _min;
    private double _max;

    public DataSource(String name, Type type, double min, double max) {
        this._name = name;
        this._type = type;
        this._min = min;
        this._max = max;
    }

    /* Needed in parseDataSource below. Other value should use the above
     * constructor or `parseDataSource'. */
    private DataSource() {
        this._type = Type.GAUGE;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public int getType() {
        return _type.value;
    }

    public void setType(Type type) {
        _type = type;
    }

    public double getMin() {
        return _min;
    }

    public void setMin(double min) {
        _min = min;
    }

    public double getMax() {
        return _max;
    }

    public void setMax(double max) {
        _max = max;
    }

    private static double toDouble(String val) {
        if (val.equals(NAN)) {
            return Double.NaN;
        } else {
            return Double.parseDouble(val);
        }
    }

    private String asString(double val) {
        if (Double.isNaN(val)) {
            return NAN;
        } else {
            return String.valueOf(val);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        final char DLM = ':';
        sb.append(_name).append(DLM);
        sb.append(_type.value).append(DLM);
        sb.append(asString(_min)).append(DLM);
        sb.append(asString(_max));
        return sb.toString();
    }

    static public DataSource parseDataSource(String str) {
        String[] fields;
        int str_len = str.length();
        DataSource dsrc = new DataSource();

        /* Ignore trailing commas. This makes it easier for parsing value. */
        if (str.charAt(str_len - 1) == ',') {
            str = str.substring(0, str_len - 1);
        }

        fields = str.split(":");
        if (fields.length != 4)
            return (null);

        dsrc._name = fields[0];

        dsrc._type = Type.getType(fields[1]);

        dsrc._min = toDouble(fields[2]);
        dsrc._max = toDouble(fields[3]);

        return (dsrc);
    }

    public enum Type {
        COUNTER(0),
        GAUGE(1),
        DERIVE(2),
        ABSOLUTE(3);

        private final int value;

        Type(int i) {
            value = i;
        }

        public int value() {
            return value;
        }

        public static Type getType(String name) {
            try {
                return Type.valueOf(name);
            } catch (Exception e) {
            }
            return DERIVE;
        }

    }
}

