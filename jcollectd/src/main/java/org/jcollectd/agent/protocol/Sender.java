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

import org.jcollectd.agent.api.Notification;
import org.jcollectd.agent.api.Values;

import java.io.IOException;

/**
 * Protocol independent Sender interface.
 */
public abstract class Sender implements Dispatcher {

    private String _host =
            Network.getProperty("host", Network.getProperty("hostname"));

    protected Sender() {
    }

    protected abstract void write(Values data) throws IOException;

    protected abstract void write(Notification data) throws IOException;

    public abstract void flush() throws IOException;

    public abstract void addServer(String server);


    public void setHost(String host) {
        _host = host;
    }

    public void dispatch(Values values) {
        try {
            write(values);
        } catch (IOException e) {
            //XXX
            e.printStackTrace();
        }
    }

    public void dispatch(Notification notification) {
        try {
            write(notification);
        } catch (IOException e) {
            //XXX
            e.printStackTrace();
        }
    }
}
