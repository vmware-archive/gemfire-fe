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

public class XCodec extends TypeCodec<double[][]> {

    public XCodec() {
        super(DataType.blob(), double[][].class);
    }

    @Override
    public ByteBuffer serialize(double[][] value, ProtocolVersion protocolVersion) throws InvalidTypeException {
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
    public double[][] deserialize(ByteBuffer bytes, ProtocolVersion protocolVersion) throws InvalidTypeException {
        try {
            byte[] b = bytes.array();
            ByteArrayInputStream bis = new ByteArrayInputStream(b);
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (double[][]) ois.readObject();
        } catch (Exception x) {
            throw new InvalidTypeException(x.toString(), x);
        }
    }

    @Override
    public double[][] parse(String value) throws InvalidTypeException {
        try {
            Decoder dec = Base64.getDecoder();
            byte[] b = dec.decode(value);
            ByteArrayInputStream bis = new ByteArrayInputStream(b);
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (double[][]) ois.readObject();
        } catch (Exception x) {
            throw new InvalidTypeException(x.toString(), x);
        }
    }

    @Override
    public String format(double[][] value) throws InvalidTypeException {
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
