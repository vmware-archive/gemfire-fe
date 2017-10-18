package io.pivotal.bds.gemfire.bitcoinj.serializer;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;

import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.core.StoredBlock;

import org.apache.geode.DataSerializer;

public class StoredBlockSerializer extends DataSerializer {

    private static NetworkParameters params;

    public static void setParams(NetworkParameters params) {
        StoredBlockSerializer.params = params;
    }

    public StoredBlockSerializer() {
    }

    @Override
    public Object fromData(DataInput in) throws IOException, ClassNotFoundException {
        int len = in.readInt();
        byte[] data = new byte[len];
        in.readFully(data);
        ByteBuffer buf = ByteBuffer.wrap(data);
        StoredBlock block = StoredBlock.deserializeCompact(params, buf);
        return block;
    }

    @Override
    public int getId() {
        return 1000;
    }

    @Override
    public Class<?>[] getSupportedClasses() {
        return new Class<?>[] { StoredBlock.class };
    }

    @Override
    public boolean toData(Object o, DataOutput out) throws IOException {
        StoredBlock block = (StoredBlock) o;
        ByteBuffer buf = ByteBuffer.allocate(100);
        block.serializeCompact(buf);
        byte[] data = buf.array();
        int len = data.length;
        out.writeInt(len);
        out.write(data);
        return true;
    }

}
