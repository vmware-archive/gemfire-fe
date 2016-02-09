package io.pivotal.bds.gemfire.hbase.listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.hadoop.hbase.client.Put;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.Operation;
import com.gemstone.gemfire.cache.asyncqueue.AsyncEvent;
import com.gemstone.gemfire.cache.asyncqueue.AsyncEventListener;
import com.gemstone.gemfire.pdx.PdxInstance;

import io.pivotal.bds.gemfire.hbase.util.HBaseHelper;

public class HBaseXrefAsyncEventListener implements AsyncEventListener, Declarable {

    private String regionName;
    private String xrefFieldName;
    private int xrefFieldLength;
    private int keyFieldLength;

    private static final Logger LOG = LoggerFactory.getLogger(HBaseXrefAsyncEventListener.class);

    @Override
    public void close() {
    }

    @Override
    public void init(Properties props) {
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
    public boolean processEvents(List<AsyncEvent> events) {
        LOG.debug("processEvents: events={}", events);

        try {
            List<Put> puts = new ArrayList<>();

            for (AsyncEvent evt : events) {
                Operation op = evt.getOperation();
                if (op.isCreate() && !op.isLoad()) {
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
                                throw new IllegalArgumentException(
                                        "Field too long: max=" + xrefFieldLength + ", actual=" + bf.length);
                            }

                            byte[] b = new byte[xrefFieldLength + keyFieldLength];
                            Arrays.fill(b, (byte) 0);

                            System.arraycopy(bf, 0, b, 0, bf.length);
                            System.arraycopy(bk, 0, b, xrefFieldLength, bk.length);

                            if (LOG.isDebugEnabled()) {
                                LOG.debug("processEvents: of={}, bf={}, bk={}, b={}", of, Arrays.toString(bf), Arrays.toString(bk),
                                        Arrays.toString(b));
                            }

                            Put put = HBaseHelper.createPut(b, bk);
                            puts.add(put);
                        } else {
                            LOG.debug("processEvents: field {} is null in value {}", xrefFieldName, inst);
                        }
                    } else {
                        LOG.debug("processEvents: value is not a PdxInstance: {}", value);
                    }
                } else {
                    LOG.debug("processEvents: event is not a create: {}", evt.getOperation());
                }
            }

            if (!puts.isEmpty()) {
                LOG.debug("processEvents: puts={}", puts);
                HBaseHelper.store(puts, regionName);
            } else {
                LOG.debug("processEvents: no entries");
            }

            return true;
        } catch (Exception x) {
            LOG.error("processEvents: x={}", x.toString(), x);
            return false;
        }
    }

}
