package io.pivotal.bds.gemfire.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Properties;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.apache.geode.cache.Declarable;
import org.apache.geode.compression.Compressor;

public class GZIPCompressor implements Compressor, Declarable {

    @Override
    public void init(Properties props) {
    }

    @Override
    public byte[] compress(byte[] data) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            GZIPOutputStream gos = new GZIPOutputStream(bos);
            gos.write(data);
            gos.flush();
            gos.close();
            return bos.toByteArray();
        } catch (Exception x) {
            throw new IllegalArgumentException(x.toString(), x);
        }
    }

    @Override
    public byte[] decompress(byte[] data) {
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(data);
            GZIPInputStream gis = new GZIPInputStream(bis);
            byte[] b = new byte[100000];
            int len = gis.read(b);
            byte[] b2 = new byte[len];
            System.arraycopy(b, 0, b2, 0, len);
            return b2;
        } catch (Exception x) {
            throw new IllegalArgumentException(x.toString(), x);
        }
    }

}
