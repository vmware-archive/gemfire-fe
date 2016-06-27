package io.pivotal.bds.gemfire.kafka;

import java.io.ByteArrayOutputStream;
import java.util.Map;

import org.apache.avro.io.BinaryEncoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.avro.specific.SpecificRecord;
import org.apache.kafka.common.serialization.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.EntryEvent;
import com.gemstone.gemfire.cache.Operation;

public class EntryEventSpecificRecordSerializer implements Serializer<EntryEvent<Object, SpecificRecord>> {

    private static final EncoderFactory factory = new EncoderFactory();
    private static final Logger LOG = LoggerFactory.getLogger(EntryEventSpecificRecordSerializer.class);

    @Override
    public byte[] serialize(String topic, EntryEvent<Object, SpecificRecord> data) {
        LOG.debug("serialize: topic={}, data={}", topic, data);

        try {
            Operation op = data.getOperation();
            SpecificRecord rec = op.isCreate() || op.isUpdate() ? data.getNewValue() : data.getOldValue();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            BinaryEncoder encoder = factory.directBinaryEncoder(bos, null);
            SpecificDatumWriter<SpecificRecord> writer = new SpecificDatumWriter<SpecificRecord>(rec.getSchema());
            writer.write(rec, encoder);
            byte[] b = bos.toByteArray();
            return b;
        } catch (Exception x) {
            LOG.error("serialize: topic={}, data={}, x={}", topic, data, x.toString(), x);
            throw new IllegalArgumentException(x.toString(), x);
        }
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public void close() {
    }

}
