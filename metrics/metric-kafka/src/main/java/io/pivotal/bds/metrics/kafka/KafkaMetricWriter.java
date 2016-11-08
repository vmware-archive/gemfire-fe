package io.pivotal.bds.metrics.kafka;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.avro.io.BinaryEncoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import io.pivotal.bds.metrics.avro.AvroMetric;
import io.pivotal.bds.metrics.data.Metric;
import io.pivotal.bds.metrics.data.MetricValue;
import io.pivotal.bds.metrics.writer.MetricWriter;


public class KafkaMetricWriter extends MetricWriter {

    private String topic;
    private KafkaProducer<byte[], byte[]> producer;
    private static SpecificDatumWriter<AvroMetric> writer = new SpecificDatumWriter<>(AvroMetric.class);
    private static final EncoderFactory factory = EncoderFactory.get();

    public KafkaMetricWriter(String name, String topic, Properties props) {
        super(name);
        this.topic = topic;
        this.producer = new KafkaProducer<>(props);
    }

    @Override
    protected void doWrite(Metric metric) throws Exception {
        Map<CharSequence, CharSequence> tags = new HashMap<>();

        for (Map.Entry<String, String> e : metric.getTags().entrySet()) {
            tags.put(e.getKey(), e.getValue());
        }

        Map<CharSequence, Double> vals = new HashMap<>();

        for (MetricValue mv : metric.getValues()) {
            vals.put(mv.getName(), mv.getValue());
        }

        AvroMetric am = new AvroMetric(metric.getTs(), tags, vals);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        BinaryEncoder enc = factory.binaryEncoder(bos, null);
        writer.write(am, enc);
        enc.flush();

        ProducerRecord<byte[], byte[]> rec = new ProducerRecord<byte[], byte[]>(topic, bos.toByteArray());
        producer.send(rec);
    }

}
