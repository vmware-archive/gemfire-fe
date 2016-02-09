package io.pivotal.bds.gemfire.kite.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericRecord;
import org.kitesdk.data.Dataset;
import org.kitesdk.data.DatasetWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.Operation;
import com.gemstone.gemfire.cache.asyncqueue.AsyncEvent;
import com.gemstone.gemfire.cache.asyncqueue.AsyncEventListener;
import com.gemstone.gemfire.pdx.PdxInstance;

import io.pivotal.bds.gemfire.kite.util.AvroHelper;
import io.pivotal.bds.gemfire.kite.util.DatasetHelper;

public class BucketingAsyncEventListener implements AsyncEventListener, Declarable {

    private String bucketNumberFieldName = "bucketNumber";

    private static final Logger LOG = LoggerFactory.getLogger(BucketingAsyncEventListener.class);

    public BucketingAsyncEventListener() {
    }

    @Override
    public void close() {
    }

    @Override
    public void init(Properties props) {
        bucketNumberFieldName = props.getProperty("bucketNumberFieldName", bucketNumberFieldName);
        LOG.info("init: hashFieldName={}", bucketNumberFieldName);
        Assert.hasText(bucketNumberFieldName, "Missing property 'bucketNumberFieldName'");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean processEvents(List<AsyncEvent> events) {
        LOG.debug("processEvents: events={}", events);

        try {
            Map<String, List<AsyncEvent>> map = new HashMap<>();

            for (AsyncEvent evt : events) {
                Operation op = evt.getOperation();

                if (op.isCreate() && !op.isLoad()) {
                    String rn = evt.getRegion().getName();

                    List<AsyncEvent> list = map.get(rn);

                    if (list == null) {
                        list = new ArrayList<>();
                        map.put(rn, list);
                    }

                    list.add(evt);
                } else {
                    LOG.debug("processEvents: got something other than create: evt={}", evt);
                }
            }

            for (Map.Entry<String, List<AsyncEvent>> e : map.entrySet()) {
                String rn = e.getKey();
                List<AsyncEvent> list = e.getValue();

                Schema schema = DatasetHelper.getSchema(rn);

                Dataset<GenericRecord> ds = getDataset(rn);
                DatasetWriter<GenericRecord> writer = ds.newWriter();

                try {
                    for (AsyncEvent evt : list) {
                        String key = (String) evt.getKey();
                        PdxInstance value = (PdxInstance) evt.getDeserializedValue();
                        LOG.debug("processEvents: key={}, value={}", key, value);

                        int hc = key.hashCode();
                        int bucketNumber = Math.abs(hc % DatasetHelper.getHashBucketCount());

                        long ts = System.currentTimeMillis();

                        GenericRecord record = AvroHelper.convertToAvro(value, schema);

                        record.put(bucketNumberFieldName, bucketNumber);
                        record.put("ts", ts);

                        LOG.debug("processEvents: bucketNumber={}, record={}, key={}, value={}", bucketNumber, record, key, value);

                        writer.write(record);
                    }
                } finally {
                    writer.close();
                }
            }

            return true;
        } catch (Exception x) {
            LOG.error("processEvents: x={}", x.toString(), x);
            return false;
        }
    }

    private Dataset<GenericRecord> getDataset(String name) {
        return DatasetHelper.getDataset(name);
    }
}
