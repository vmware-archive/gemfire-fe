package io.pivotal.bds.gemfire.fraud.common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import com.datastax.driver.core.DataType;
import com.datastax.driver.core.ProtocolVersion;
import com.datastax.driver.core.TypeCodec;
import com.datastax.driver.core.exceptions.InvalidTypeException;

public class YCodec extends TypeCodec<int[]> {

    public YCodec() {
        super(DataType.blob(), int[].class);
    }

    @Override
    public ByteBuffer serialize(int[] value, ProtocolVersion protocolVersion) throws InvalidTypeException {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(value);
            byte[] b = bos.toByteArray();
            return ByteBuffer.wrap(b);
        } catch (Exception x) {
            throw new InvalidTypeException(x.toString(), x);
        }
    }

    @Override
    public int[] deserialize(ByteBuffer bytes, ProtocolVersion protocolVersion) throws InvalidTypeException {
        try {
            byte[] b = bytes.array();
            ByteArrayInputStream bis = new ByteArrayInputStream(b);
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (int[]) ois.readObject();
        } catch (Exception x) {
            throw new InvalidTypeException(x.toString(), x);
        }
    }

    @Override
    public int[] parse(String value) throws InvalidTypeException {
        try {
            Decoder dec = Base64.getDecoder();
            byte[] b = dec.decode(value);
            ByteArrayInputStream bis = new ByteArrayInputStream(b);
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (int[]) ois.readObject();
        } catch (Exception x) {
            throw new InvalidTypeException(x.toString(), x);
        }
    }

    @Override
    public String format(int[] value) throws InvalidTypeException {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(value);
            byte[] b = bos.toByteArray();
            Encoder enc = Base64.getEncoder();
            return enc.encodeToString(b);
        } catch (Exception x) {
            throw new InvalidTypeException(x.toString(), x);
        }
    }

}
