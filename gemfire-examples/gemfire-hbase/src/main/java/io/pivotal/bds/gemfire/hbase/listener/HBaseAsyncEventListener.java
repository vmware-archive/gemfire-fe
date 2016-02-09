package io.pivotal.bds.gemfire.hbase.listener;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.Operation;
import com.gemstone.gemfire.cache.asyncqueue.AsyncEvent;
import com.gemstone.gemfire.cache.asyncqueue.AsyncEventListener;
import com.gemstone.gemfire.pdx.PdxInstance;
import com.gemstone.gemfire.pdx.internal.PdxOutputStream;

import io.pivotal.bds.gemfire.hbase.util.HBaseHelper;
import io.pivotal.bds.metrics.timer.Timer;

public class HBaseAsyncEventListener implements AsyncEventListener, Declarable {

    private byte[] family;
    private byte[] qualifier;
    private String keyFieldName;

    private final Timer timer = new Timer("HBaseAsyncEventListener");

    private static final Logger LOG = LoggerFactory.getLogger(HBaseAsyncEventListener.class);

    @SuppressWarnings("rawtypes")
    @Override
    public boolean processEvents(List<AsyncEvent> events) {
        LOG.trace("processEvents: events={}", events);

        try {
            // collect all creates or updates that are not from CacheLoader and sort by region
            Map<String, List<AsyncEvent>> creates = new HashMap<>();

            for (AsyncEvent evt : events) {
                Operation op = evt.getOperation();
                String rn = evt.getRegion().getName();

                if ((op.isCreate() || op.isUpdate()) && !op.isLoad()) {
                    List<AsyncEvent> list = creates.get(rn);

                    if (list == null) {
                        list = new ArrayList<>();
                        creates.put(rn, list);
                    }

                    list.add(evt);
                }
            }

            // do batch puts into hbase for each region
            for (Map.Entry<String, List<AsyncEvent>> e : creates.entrySet()) {
                String regionName = e.getKey();
                LOG.debug("processEvents: regionName={}", regionName);

                Table table = HBaseHelper.getTable(regionName);
                List<AsyncEvent> list = e.getValue();
                List<Put> puts = new ArrayList<>();

                for (AsyncEvent evt : list) {
                    Object ok = evt.getKey();

                    if (LOG.isDebugEnabled()) {
                        LOG.debug("processEvents: regionName={}, ok={}, value={}", regionName, ok, evt.getDeserializedValue());
                    }

                    byte[] key = convert(ok);
                    byte[] value = evt.getSerializedValue();

                    if (LOG.isDebugEnabled()) {
                        LOG.debug("processEvents: regionName={}, key.length={}, value.length={}, ok={}", regionName, key.length, value.length, ok);
                    }

                    Put put = new Put(key);
                    put.addColumn(family, qualifier, value);

                    puts.add(put);
                }

                if (LOG.isDebugEnabled()) {
                    LOG.debug("processEvents: regionName={}, puts.size={}", regionName, puts.size());
                }

                timer.start();
                table.put(puts);
                timer.end();
            }

            return true;
        } catch (Exception x) {
            LOG.error("processEvents: x={}", x.toString(), x);
            return false;
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

    @Override
    public void close() {
    }

}
