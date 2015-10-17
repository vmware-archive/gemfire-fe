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
import java.net.*;
import java.util.ArrayList;
import java.util.List;

/**
 * collectd UDP protocol sender.
 * See collectd/src/network.c:network_write
 */
public class UdpSender extends Sender {
    private final List<InetSocketAddress> _servers;
    private DatagramSocket _socket;
    private MulticastSocket _mcast;
    private final PacketWriter _writer;

    public UdpSender() {
        _servers = new ArrayList<InetSocketAddress>();
        _writer = new PacketWriter();
    }

    @Override
    protected void write(Values data) throws IOException {
        int len = _writer.getSize();
        _writer.write(data);
        if (_writer.getSize() >= Network.BUFFER_SIZE) {
            send(_writer.getBytes(), len);
            _writer.reset();
            _writer.write(data);//redo XXX better way?
        }
    }

    @Override
    protected void write(Notification data) throws IOException {
        //To change body of implemented methods use File | Settings | File Templates.
    }


    public void addServer(String server) {
        String ip;
        int ix = server.indexOf(':');
        int port;
        if (ix == -1) {
            ip = server;
            port = Network.DEFAULT_PORT;
        } else {
            ip = server.substring(0, ix);
            port = Integer.parseInt(server.substring(ix + 1));
        }
        addServer(new InetSocketAddress(ip, port));
    }

    void addServer(InetSocketAddress server) {
        _servers.add(server);
    }

    private DatagramSocket getSocket() throws SocketException {
        if (_socket == null) {
            _socket = new DatagramSocket();
        }
        return _socket;
    }

    private MulticastSocket getMulticastSocket() throws IOException {
        if (_mcast == null) {
            _mcast = new MulticastSocket();
            _mcast.setTimeToLive(1);
        }
        return _mcast;
    }

    private void send(byte[] buffer, int len) throws IOException {
        for (InetSocketAddress address : _servers) {
            DatagramPacket packet =
                    new DatagramPacket(buffer, len, address);
            if (address.getAddress().isMulticastAddress()) {
                getMulticastSocket().send(packet);
            } else {
                getSocket().send(packet);
            }
        }
    }

    public void flush() throws IOException {
        if (_writer.getSize() == 0) {
            return;
        }
        byte[] buffer = _writer.getBytes();
        send(buffer, buffer.length);
        _writer.reset();
    }
}
