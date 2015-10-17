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

import org.jcollectd.agent.api.DataSource;
import org.jcollectd.agent.api.Identifier;
import org.jcollectd.agent.api.Values;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;

/**
 * collectd/src/network.c:network_write
 */
public class PacketWriter {

    private final ByteArrayOutputStream _bos;
    private final DataOutputStream _os;
    private final TypesDB _types = TypesDB.getInstance();

    public PacketWriter() {
        this(new ByteArrayOutputStream(Network.BUFFER_SIZE));
    }

    private PacketWriter(ByteArrayOutputStream bos) {
        _bos = bos;
        _os = new DataOutputStream(_bos);
    }

    public int getSize() {
        return _bos.size();
    }

    public byte[] getBytes() {
        return _bos.toByteArray();
    }

    public boolean isFull() {
        return getSize() >= Network.BUFFER_SIZE;
    }

    public void reset() {
        _bos.reset();
    }

    public void write(Values data)
            throws IOException {

        String type = data.getType();

        writeString(Part.HOST.id, data.getHost());
        //TODO: support TIME_HIRES
        writeNumber(Part.TIME.id, data.getTime() / 1000);
        writeString(Part.PLUGIN.id, data.getPlugin());
        writeString(Part.PLUGIN_INSTANCE.id, data.getPluginInstance());
        writeString(Part.TYPE.id, type);
        writeString(Part.TYPE_INSTANCE.id, data.getTypeInstance());

            List<DataSource> ds = _types.getType(type);
            List<Number> values = data.getData();

            if ((ds != null) && (ds.size() != values.size())) {
                String msg =
                        type + " datasource mismatch, expecting " +
                                ds.size() + ", given " + values.size();
                throw new IOException(msg);
            }

            //TODO: support INTERVAL_HIRES
            writeNumber(Part.INTERVAL.id, data.getInterval());
            writeValues(ds, values);

    }



    private void writeHeader(int type, int len)
            throws IOException {
        _os.writeShort(type);
        _os.writeShort(len);
    }

    private void writeValues(List<DataSource> ds, List<Number> values)
            throws IOException {

        int num = values.size();
        int len =
                Network.HEADER_LEN +
                        Network.UINT16_LEN +
                        (num * Network.UINT8_LEN) +
                        (num * Network.UINT64_LEN);

        byte[] types = new byte[num];
        int ds_len;
        if (ds == null) {
            ds_len = 0;
        } else {
            ds_len = ds.size();
        }

        for (int i = 0; i < num; i++) {
            if (ds_len == 0) {
                if (values.get(i) instanceof Double) {
                    types[i] = (byte) DataSource.Type.GAUGE.value();
                } else {
                    types[i] = (byte) DataSource.Type.COUNTER.value();
                }
            } else {
                types[i] = (byte) ds.get(i).getType();
            }
        }

        writeHeader(Part.VALUES.id, len);
        _os.writeShort(num);
        _os.write(types);

        for (int i = 0; i < num; i++) {
            Number value = values.get(i);
            if (types[i] == DataSource.Type.COUNTER.value()) {
                _os.writeLong(value.longValue());
            } else {
                writeDouble(value.doubleValue());
            }
        }
    }

    private void writeDouble(double val)
            throws IOException {

        ByteBuffer bb = ByteBuffer.wrap(new byte[8]);
        //collectd uses x86 host order for doubles
        bb.order(ByteOrder.LITTLE_ENDIAN);
        bb.putDouble(val);
        _os.write(bb.array());
    }

    private void writeString(int type, String val)
            throws IOException {

        if (val == null || val.length() == 0) {
            return;
        }
        int len = Network.HEADER_LEN + val.length() + 1;
        writeHeader(type, len);
        _os.write(val.getBytes());
        _os.write('\0');
    }

    private void writeNumber(int type, long val)
            throws IOException {

        int len = Network.HEADER_LEN + Network.UINT64_LEN;
        writeHeader(type, len);
        _os.writeLong(val);
    }
}
