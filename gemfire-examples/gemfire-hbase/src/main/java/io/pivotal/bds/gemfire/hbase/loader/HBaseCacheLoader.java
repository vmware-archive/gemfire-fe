package io.pivotal.bds.gemfire.hbase.loader;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.CacheLoader;
import com.gemstone.gemfire.cache.CacheLoaderException;
import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.LoaderHelper;
import com.gemstone.gemfire.pdx.PdxInstance;
import com.gemstone.gemfire.pdx.internal.PdxInputStream;
import com.gemstone.gemfire.pdx.internal.PdxOutputStream;

import io.pivotal.bds.gemfire.hbase.util.Factory;
import io.pivotal.bds.gemfire.hbase.util.HBaseHelper;
import io.pivotal.bds.metrics.timer.Timer;

public class HBaseCacheLoader<K, V> implements CacheLoader<K, V>, Declarable {

    private byte[] family;
    private byte[] qualifier;
    private String keyFieldName;

    private static final Map<String, Timer> timers = new HashMap<>();

    private static final Logger LOG = LoggerFactory.getLogger(HBaseCacheLoader.class);

    public HBaseCacheLoader() {
    }

    @SuppressWarnings("unchecked")
    @Override
    public V load(LoaderHelper<K, V> helper) throws CacheLoaderException {
        K pkey = helper.getKey();
        Factory<V> factory = (Factory<V>) helper.getArgument();

        String regionName = helper.getRegion().getName();
        LOG.debug("load: pkey={}, regionName={}, factory={}", pkey, regionName, factory);

        try {
            byte[] key = convert(pkey);

            if (LOG.isDebugEnabled()) {
                LOG.debug("load: pkey={}, regionName={}, key.length={}", pkey, regionName, key.length);
            }

            Timer timer = getTimer(regionName);

            V value = null;

            Table table = HBaseHelper.getTable(regionName);

            Get get = new Get(key);

            timer.start();
            Result result = table.get(get);
            timer.end();

            if (!result.isEmpty()) {
                Cell cell = result.getColumnLatestCell(family, qualifier);
                byte[] bval = CellUtil.cloneValue(cell);

                PdxInputStream is = new PdxInputStream(bval);

                try {
                    value = (V) is.readObject();
                } finally {
                    is.close();
                }

                LOG.debug("load: value found in hbase: pkey={}, regionName={}, value={}", pkey, regionName, value);
            } else {
                LOG.debug("load: not found in hbase: pkey={}, regionName={}", pkey, regionName);
            }

            if (value == null && factory != null) {
                LOG.debug("load: using factory, pkey={}, regionName={}", pkey, regionName);
                value = factory.create();
            }

            LOG.debug("load: pkey={}, regionName={}, value={}", pkey, regionName, value);
            return value;
        } catch (Exception x) {
            LOG.error(x.toString(), x);
            throw new CacheLoaderException(x.toString(), x);
        }
    }

    @Override
    public void close() {
    }

    @Override
    public void init(Properties props) {
        String sfam = props.getProperty("family", "gemfire");
        String squal = props.getProperty("qualifier", "gemfire");
        keyFieldName = props.getProperty("keyFieldName", "id");
        LOG.info("init: family={}, qualifier={}, keyFieldName={}", sfam, squal, keyFieldName);

        try {
            family = sfam.getBytes("UTF-8");
            qualifier = squal.getBytes("UTF-8");
        } catch (Exception x) {
            throw new IllegalArgumentException(x.toString(), x);
        }
    }

    private byte[] convert(Object o) throws Exception {
        if (o instanceof PdxInstance) {
            PdxInstance pi = (PdxInstance) o;
            Object t = pi.getField(keyFieldName);

            if (t == null) {
                PdxOutputStream pos = new PdxOutputStream();
                pos.writeObject(pi, false);
                return pos.toByteArray();
            } else {
                return convert(t);
            }
        } else if (o instanceof String) {
            String s = (String) o;
            return s.getBytes("UTF-8");
        } else if (o instanceof Integer) {
            Integer i = (Integer) o;
            ByteBuffer bb = ByteBuffer.allocate(4);
            bb.putInt(i);
            return bb.array();
        } else if (o instanceof Long) {
            Long l = (Long) o;
            ByteBuffer bb = ByteBuffer.allocate(8);
            bb.putLong(l);
            return bb.array();
        } else {
            throw new IllegalArgumentException("Cannot handle key type " + o.getClass().getName());
        }
    }

    private synchronized static Timer getTimer(String name) {
        Timer t = timers.get(name);

        if (t == null) {
            t = new Timer("hbase-" + name);
            timers.put(name, t);
        }

        return t;
    }
}
