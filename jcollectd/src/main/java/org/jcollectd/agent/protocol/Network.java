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

package org.jcollectd.agent.protocol;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * jcd.* property configuration.
 * //TODO: simplify
 */
public class Network {

    static final int UINT8_LEN = 1;
    static final int UINT16_LEN = UINT8_LEN * 2;
    static final int UINT32_LEN = UINT16_LEN * 2;
    static final int UINT64_LEN = UINT32_LEN * 2;
    public static final int HEADER_LEN = UINT16_LEN * 2;

    public static final int DEFAULT_PORT = 25826;
    public static final String DEFAULT_V4_ADDR = "239.192.74.66";
    public static final String DEFAULT_V6_ADDR = "ff18::efc0:4a42";



    /**
     * as per collectd/src/network.c v5
     * most probably 1472 can also be safe for both ipv4/6 but has to be configured also on a receiving side
     */
    public static final int DEFAULT_BUFFER_SIZE = 1452;

    /*to be set in static*/
    public static final int BUFFER_SIZE;

    private static final Properties _props = new Properties();
    public static final String KEY_PREFIX = "jcd.";

    static {
        loadProperties();
        BUFFER_SIZE = Integer.getInteger(KEY_PREFIX.concat("maxBufferSize"), DEFAULT_BUFFER_SIZE);
    }

    public static Properties getProperties() {
        return _props;
    }

    public static String getProperty(String name, String defval) {
        String key = KEY_PREFIX + name;
        return _props.getProperty(key, System.getProperty(key, defval));
    }


    public static String getProperty(String name) {
        return getProperty(name, null);
    }


    private static void loadProperties() {
        String fname = KEY_PREFIX + "properties";
        String file = System.getProperty(fname, fname);

        if (new File(file).exists()) {
            Logger log = Logger.getLogger(Network.class.getName());
            FileInputStream is = null;
            try {
                is = new FileInputStream(file);
                _props.load(is);
                log.fine("Loaded " + file);
            } catch (IOException e) {
                log.fine("Unable to load " + file + ": " + e);
            } finally {
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                    }
                }
            }
        }
    }
}
