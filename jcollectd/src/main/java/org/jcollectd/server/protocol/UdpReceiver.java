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
import org.jcollectd.agent.protocol.Part;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * collectd UDP protocol receiver. See collectd/src/network.c:parse_packet
 */
public class UdpReceiver {

    private static final Logger _log = Logger.getLogger(UdpReceiver.class.getName());
    private Dispatcher _dispatcher;
    private DatagramSocket _socket;
    private int _port = Network.DEFAULT_PORT;
    private String _bindAddress;
    private String _ifAddress;
    private boolean _isShutdown = false;

    public UdpReceiver() {
        String addr = Network.getProperty("laddr", Network.DEFAULT_V4_ADDR);
        if (addr != null) {
            int ix = addr.indexOf(':'); // XXX ipv6
            if (ix == -1) {
                _bindAddress = addr;
            } else {
                _bindAddress = addr.substring(0, ix);
                _port = Integer.parseInt(addr.substring(ix + 1));
            }
        }
        addr = Network.getProperty("ifaddr");
        if (addr != null) {
            try {
                // -Djcd.ifaddr=tun0
                _ifAddress = NetworkInterface.getByName(addr).getInetAddresses().nextElement().getHostAddress();
            } catch (Exception e) {
                // -Djcd.ifaddr=10.2.0.43
                _ifAddress = addr;
            }
            _log.fine("Using interface address=" + _ifAddress);
        }
    }

    private UdpReceiver(Dispatcher dispatcher) {
        this();
        setDispatcher(dispatcher);
    }

    public void setDispatcher(Dispatcher dispatcher) {
        _dispatcher = dispatcher;
    }

    protected int getPort() {
        return _port;
    }

    public void setPort(int port) {
        _port = port;
    }

    public String getListenAddress() {
        return _bindAddress;
    }

    public void setListenAddress(String address) {
        _bindAddress = address;
    }

    public String getInterfaceAddress() {
        return _ifAddress;
    }

    public void setInterfaceAddress(String address) {
        _ifAddress = address;
    }

    public DatagramSocket getSocket() throws IOException {
        if (_socket == null) {
            if (_bindAddress == null) {
                _socket = new DatagramSocket(_port);
            } else {
                InetAddress addr = InetAddress.getByName(_bindAddress);
                if (addr.isMulticastAddress()) {
                    MulticastSocket mcast = new MulticastSocket(_port);
                    if (_ifAddress != null) {
                        mcast.setInterface(InetAddress.getByName(_ifAddress));
                    }
                    mcast.joinGroup(addr);
                    _socket = mcast;
                } else {
                    _socket = new DatagramSocket(_port, addr);
                }
            }
        }
        return _socket;
    }

    public void setSocket(DatagramSocket socket) {
        _socket = socket;
    }

    private String readString(DataInputStream is, int len) throws IOException {
        byte[] buf = new byte[len];
        is.read(buf, 0, len);
        return new String(buf, 0, len - 1); // -1 -> skip \0
    }

    private List<Number> readValues(DataInputStream is) throws IOException {
        int nvalues = is.readUnsignedShort();

        int[] types = new int[nvalues];
        for (int i = 0; i < nvalues; i++) {
            types[i] = is.readByte();
        }

        List<Number> values = new ArrayList<Number>();
        for (int i = 0; i < nvalues; i++) {
            byte[] dbuff = new byte[8];
            is.read(dbuff);
            ByteBuffer bb = ByteBuffer.wrap(dbuff);

            Number val;

            switch (types[i]) {
                case 0: { // COUNTER
                    val = bb.getLong();
                    break;
                }
                case 1: { // GAUGE
                    bb.order(ByteOrder.LITTLE_ENDIAN);
                    val = bb.getDouble();
                    break;
                }
                case 2: { // DERIVE
                    val = bb.getLong();
                    break;
                }
                case 3: { // ABSOLUTE
                    val = bb.getLong();
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Invalid type: " + types[i]);
                }
            }

            values.add(val);
        }
        /*
         * if (_dispatcher != null) { _dispatcher.dispatch(values); }
         */
        return values;
    }

    public Packet<?> parse(byte[] packet) throws IOException {
        int total = packet.length;
        ByteArrayInputStream buffer = new ByteArrayInputStream(packet);
        DataInputStream is = new DataInputStream(buffer);
        Identifier.Builder dataBuilder = Identifier.Builder.builder();

        long interval = -1;
        List<Number> values = null;
        String msg = null;
        Notification.Severity severity = null;

        while ((0 < total) && (total > Network.HEADER_LEN)) {
            int type = is.readUnsignedShort();
            int len = is.readUnsignedShort();

            if (len < Network.HEADER_LEN) {
                break; // packet was filled to the brim
            }

            total -= len;
            len -= Network.HEADER_LEN;

            switch (Part.find(type)) {
                case VALUES:
                    values = readValues(is);
                    break;
                case TIME:
                    long tmp = is.readLong();
                    dataBuilder.time(tmp);
                    break;
                case INTERVAL:
                    interval = is.readLong();
                    break;
                case TIME_HIRES:
                    long thi = is.readLong();
                    dataBuilder.time(thi);
                    break;
                case INTERVAL_HIRES:
                    interval = is.readLong();
                    break;
                case HOST:
                    String host = readString(is, len);
                    dataBuilder.host(host);
                    break;
                case PLUGIN:
                    String plugin = readString(is, len);
                    dataBuilder.plugin(plugin);
                    break;
                case PLUGIN_INSTANCE:
                    String pluginInstance = readString(is, len);
                    dataBuilder.pluginInstance(pluginInstance);
                    break;
                case TYPE:
                    String _type = readString(is, len);
                    dataBuilder.type(_type);
                    break;
                case TYPE_INSTANCE:
                    String tI = readString(is, len);
                    dataBuilder.typeInstance(tI);
                    break;
                case MESSAGE:
                    msg = readString(is, len);
                    break;
                case SEVERITY:
                    int sev = (int) is.readLong();
                    severity = Notification.Severity.find(sev);
                    break;
                default:
                    break;
            }
        }
        Identifier Identifier = dataBuilder.build();
        Packet<?> packetObj = null;

        if (values != null) {
            packetObj = new Values(Identifier, values);
        } else if (msg != null && !msg.isEmpty()) {
            packetObj = new Notification(Identifier, severity, msg);

        }
        packetObj.setInterval(interval);
        return packetObj;
    }

    public void listen() throws Exception {
        listen(getSocket());
    }

    void listen(DatagramSocket socket) throws IOException {
        while (true) {
            byte[] buf = new byte[Network.BUFFER_SIZE];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            try {
                socket.receive(packet);
            } catch (SocketException e) {
                if (_isShutdown) {
                    break;
                } else {
                    throw e;
                }
            }
            Packet<?> data = parse(packet.getData());
            if (_dispatcher != null) {
                if (data instanceof Notification) {
                    _dispatcher.dispatch((Notification) data);
                } else if (data instanceof Values) {
                    _dispatcher.dispatch((Values) data);
                }
            }

        }
    }

    public void shutdown() {
        if (_socket != null) {
            _isShutdown = true;
            _socket.close();
            _socket = null;
        }
    }

    public static void main(String[] args) throws Exception {
        new UdpReceiver(new StdoutDispatcher()).listen();
    }
}
