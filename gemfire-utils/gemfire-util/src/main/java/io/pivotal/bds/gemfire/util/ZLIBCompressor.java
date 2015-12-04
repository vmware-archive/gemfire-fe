package io.pivotal.bds.gemfire.util;

import java.util.Properties;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.compression.Compressor;

public class ZLIBCompressor implements Compressor, Declarable {

    @Override
    public void init(Properties props) {
    }

    @Override
    public byte[] compress(byte[] data) {
        try {
            byte[] b = new byte[data.length];
            Deflater deflater = new Deflater(9);
            deflater.setInput(data);
            deflater.finish();
            int len = deflater.deflate(b);
            deflater.end();
            byte[] out = new byte[len];
            System.arraycopy(b, 0, out, 0, len);
            return out;
        } catch (Exception x) {
            throw new IllegalArgumentException(x.toString(), x);
        }
    }

    @Override
    public byte[] decompress(byte[] data) {
        try {
            byte[] b = new byte[data.length*2];
            Inflater inflater = new Inflater();
            inflater.setInput(data);
            int len = inflater.inflate(b);
            inflater.end();
            byte[] out = new byte[len];
            System.arraycopy(b, 0, out, 0, len);
            return out;
        } catch (Exception x) {
            throw new IllegalArgumentException(x.toString(), x);
        }
    }

    public static void main(String[] args) throws Exception {
        ZLIBCompressor c = new ZLIBCompressor();
        String s = "This is some text for testing";
        byte[] in = s.getBytes();
        byte[] comp = c.compress(in);
        byte[] uncomp = c.decompress(comp);

        System.out.println("in.length=" + in.length + ", comp.length=" + comp.length + ", uncomp.length=" + uncomp.length);
    }
}
