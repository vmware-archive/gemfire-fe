package io.pivotal.bds.gemfire.kafka;

import java.io.ByteArrayOutputStream;
import java.util.Map;

import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.BinaryEncoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.kafka.common.serialization.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.asyncqueue.AsyncEvent;

@SuppressWarnings("rawtypes")
public class AsyncEventGenericRecordSerializer implements Serializer<AsyncEvent> {

    private static final EncoderFactory factory = new EncoderFactory();
    private static final Logger LOG = LoggerFactory.getLogger(AsyncEventGenericRecordSerializer.class);

    @Override
    public byte[] serialize(String topic, AsyncEvent data) {
        LOG.debug("serialize: topic={}, data={}", topic, data);

        try {
            GenericRecord rec = (GenericRecord) data.getDeserializedValue();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            BinaryEncoder encoder = factory.directBinaryEncoder(bos, null);
            GenericDatumWriter<GenericRecord> writer = new GenericDatumWriter<GenericRecord>(rec.getSchema());
            writer.write(rec, encoder);
            encoder.flush();
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
