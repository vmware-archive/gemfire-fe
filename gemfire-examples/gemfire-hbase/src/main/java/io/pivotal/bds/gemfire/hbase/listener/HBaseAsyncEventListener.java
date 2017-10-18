package io.pivotal.bds.gemfire.hbase.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Put;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.Operation;
import org.apache.geode.cache.asyncqueue.AsyncEvent;

import io.pivotal.bds.gemfire.hbase.util.HBaseHelper;
import io.pivotal.bds.gemfire.util.BackoffAsyncEventListener;
import io.pivotal.bds.metrics.timer.Timer;

public class HBaseAsyncEventListener extends BackoffAsyncEventListener {

    private final Timer putsTimer = new Timer("HBaseAsyncEventListener-puts");
    private final Timer deletesTimer = new Timer("HBaseAsyncEventListener-deletes");

    private static final Logger LOG = LoggerFactory.getLogger(HBaseAsyncEventListener.class);

    @SuppressWarnings("rawtypes")
    @Override
    public void doProcessEvents(List<AsyncEvent> events) throws Exception {
        LOG.trace("processEvents: events={}", events);

        // collect all creates, updates, or destroys that are not from load, expire, or evict, and sort by region
        Map<String, List<AsyncEvent>> stores = new HashMap<>();
        Map<String, List<AsyncEvent>> deletes = new HashMap<>();

        for (AsyncEvent evt : events) {
            Operation op = evt.getOperation();
            String rn = evt.getRegion().getName();

            if ((op.isCreate() || op.isUpdate()) && !op.isLoad()) {
                List<AsyncEvent> list = stores.get(rn);

                if (list == null) {
                    list = new ArrayList<>();
                    stores.put(rn, list);
                }

                list.add(evt);
            } else if (op.isDestroy() && !op.isEviction() && !op.isExpiration()) {
                List<AsyncEvent> list = deletes.get(rn);

                if (list == null) {
                    list = new ArrayList<>();
                    deletes.put(rn, list);
                }

                list.add(evt);
            } else {
                LOG.debug("processEvents: not a create, update, or destroy, or is load, eviction, or expiration: evt={}", evt);
            }
        }

        // do batch puts into hbase for each region
        for (Map.Entry<String, List<AsyncEvent>> e : stores.entrySet()) {
            String regionName = e.getKey();
            List<AsyncEvent> list = e.getValue();
            LOG.debug("processEvents: put: regionName={}", regionName);

            List<Put> puts = new ArrayList<>();

            for (AsyncEvent evt : list) {
                Object ok = evt.getKey();
                byte[] value = evt.getSerializedValue();

                if (LOG.isDebugEnabled()) {
                    LOG.debug("processEvents: put: regionName={}, value.length={}, ok={}", regionName, value.length, ok);
                }

                Put put = HBaseHelper.createPut(ok, value);
                puts.add(put);
            }

            if (LOG.isDebugEnabled()) {
                LOG.debug("processEvents: put: regionName={}, puts.size={}", regionName, puts.size());
            }

            putsTimer.start();
            HBaseHelper.store(puts, regionName);
            putsTimer.end();
        }

        // do batch deletes from hbase for each region
        for (Map.Entry<String, List<AsyncEvent>> e : deletes.entrySet()) {
            String regionName = e.getKey();
            LOG.debug("processEvents: delete: regionName={}", regionName);

            List<AsyncEvent> list = e.getValue();
            List<Delete> dels = new ArrayList<>();

            for (AsyncEvent evt : list) {
                Object ok = evt.getKey();

                if (LOG.isDebugEnabled()) {
                    LOG.debug("processEvents: delete: regionName={}, ok={}", regionName, ok);
                }

                Delete del = HBaseHelper.createDelete(ok);
                dels.add(del);
            }

            if (LOG.isDebugEnabled()) {
                LOG.debug("processEvents: delete: regionName={}, dels.size={}", regionName, dels.size());
            }

            deletesTimer.start();
            HBaseHelper.delete(dels, regionName);
            deletesTimer.end();
        }
    }

    @Override
    public void close() {
    }

}
