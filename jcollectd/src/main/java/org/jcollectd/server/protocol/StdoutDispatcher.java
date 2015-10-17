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

package org.jcollectd.server.protocol;

import org.jcollectd.agent.api.*;
import org.jcollectd.agent.protocol.Dispatcher;
import org.jcollectd.agent.protocol.Network;
import org.jcollectd.agent.protocol.TypesDB;

import java.util.ArrayList;
import java.util.List;

/**
 * Dispatch collectd data to stdout.
 * java -classpath collectd.jar org.collectd.server.protocol.UdpReceiver
 */
public class StdoutDispatcher implements Dispatcher {

    private final boolean namesOnly =
            "true".equals(Network.getProperty("namesOnly"));

    public void dispatch(Values vals) {
        if (namesOnly) {
            System.out.print("plugin=" + vals.getPlugin());
            System.out.print(",pluginInstance=" + vals.getPluginInstance());
            System.out.print(",type=" + vals.getType());
            System.out.print(",typeInstance=" + vals.getTypeInstance());
            List<DataSource> ds = vals.getDataSource();
            if (ds == null) {
                ds = TypesDB.getInstance().getType(vals.getType());
            }
            if (ds != null) {
                List<String> names = new ArrayList<String>();
                for (DataSource d : ds) {
                    names.add(d.getName());
                }
                System.out.print("-->" + names);
            }
            System.out.println();
        } else {
            System.out.println(vals);
        }
    }

    public void dispatch(Notification notification) {
        System.out.println(notification);
    }
}
