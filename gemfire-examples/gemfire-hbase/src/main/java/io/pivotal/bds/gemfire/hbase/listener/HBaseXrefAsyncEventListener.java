package io.pivotal.bds.gemfire.hbase.listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Put;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.gemstone.gemfire.cache.Operation;
import com.gemstone.gemfire.cache.asyncqueue.AsyncEvent;
import com.gemstone.gemfire.pdx.PdxInstance;

import io.pivotal.bds.gemfire.hbase.util.HBaseHelper;
import io.pivotal.bds.gemfire.util.BackoffAsyncEventListener;

public class HBaseXrefAsyncEventListener extends BackoffAsyncEventListener {

    private String regionName;
    private String xrefFieldName;
    private int xrefFieldLength;
    private int keyFieldLength;

    private static final Logger LOG = LoggerFactory.getLogger(HBaseXrefAsyncEventListener.class);

    @Override
    public void init(Properties props) {
        super.init(props);

        regionName = props.getProperty("regionName");
        xrefFieldName = props.getProperty("xrefFieldName");
        String xfl = props.getProperty("xrefFieldLength");
        String kfl = props.getProperty("keyFieldLength");
        LOG.info("init: regionName={}, xrefFieldName={}, xrefFieldLength={}, keyFieldLength={}", regionName, xrefFieldName, xfl,
                kfl);

        Assert.hasText(regionName, "Missing property 'regionName'");
        Assert.hasText(xrefFieldName, "Missing property 'xrefFieldName'");
        Assert.hasText(xfl, "Missing property 'xrefFieldLength'");
        Assert.hasText(kfl, "Missing property 'keyFieldLength'");

        xrefFieldLength = Integer.parseInt(xfl);
        keyFieldLength = Integer.parseInt(kfl);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public void doProcessEvents(List<AsyncEvent> events) throws Exception {
        LOG.debug("processEvents: events={}", events);

        List<Put> puts = new ArrayList<>();
        List<Delete> dels = new ArrayList<>();

        for (AsyncEvent evt : events) {
            Object value = evt.getDeserializedValue();

            if (value instanceof PdxInstance) {
                PdxInstance inst = (PdxInstance) value;
                Object of = inst.getField(xrefFieldName);

                if (of != null) {
                    Object key = evt.getKey();
                    LOG.debug("processEvents: of={}, key={}, value={}", of, key, value);

                    byte[] bk = HBaseHelper.serialize(key);

                    if (bk.length > keyFieldLength) {
                        throw new IllegalArgumentException("Key too long: max=" + keyFieldLength + ", actual=" + bk.length);
                    }

                    byte[] bf = HBaseHelper.serialize(of);

                    if (bf.length > xrefFieldLength) {
                        throw new IllegalArgumentException("Field too long: max=" + xrefFieldLength + ", actual=" + bf.length);
                    }

                    byte[] b = new byte[xrefFieldLength + keyFieldLength];
                    Arrays.fill(b, (byte) 0);

                    System.arraycopy(bf, 0, b, 0, bf.length);
                    System.arraycopy(bk, 0, b, xrefFieldLength, bk.length);

                    if (LOG.isDebugEnabled()) {
                        LOG.debug("processEvents: of={}, bf={}, bk={}, b={}", of, Arrays.toString(bf), Arrays.toString(bk),
                                Arrays.toString(b));
                    }

                    Operation op = evt.getOperation();

                    if (op.isCreate() && !op.isLoad()) {
                        Put put = HBaseHelper.createPut(b, bk);
                        puts.add(put);
                    } else if (op.isDestroy() && !op.isEviction() && !op.isExpiration()) {
                        Delete del = new Delete(b);
                        dels.add(del);
                    } else {
                        LOG.debug("processEvents: event is not a create, update, or destroy: {}", evt.getOperation());
                    }
                } else {
                    LOG.debug("processEvents: xref field {} is null: {}", xrefFieldName, value);
                }
            } else {
                LOG.debug("processEvents: value is not a PdxInstance: {}", value);
            }
        }

        if (!puts.isEmpty()) {
            LOG.debug("processEvents: puts={}", puts);
            HBaseHelper.store(puts, regionName);
        } else {
            LOG.debug("processEvents: no entries");
        }

        if (!dels.isEmpty()) {
            LOG.debug("processEvents: dels={}", dels);
            HBaseHelper.delete(dels, regionName);
        } else {
            LOG.debug("processEvents: no entries");
        }
    }

}
