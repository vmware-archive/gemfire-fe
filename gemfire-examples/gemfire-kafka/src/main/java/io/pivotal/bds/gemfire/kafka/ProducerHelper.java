package io.pivotal.bds.gemfire.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProducerHelper {

    private static Producer<byte[], byte[]> producer;
    private static final String propertyPrefix = "kafka.";
    private static final int propertyPrefixLength = propertyPrefix.length();
    private static final Logger LOG = LoggerFactory.getLogger(ProducerHelper.class);

    public static synchronized final void init() {
        if (producer == null) {
            Properties props = getProps();
            LOG.info("init: props={}", props);
            producer = new KafkaProducer<>(props);
        }
    }

    private static Properties getProps() {
        Properties sp = System.getProperties();
        Properties props = new Properties();

        for (String key : sp.stringPropertyNames()) {
            if (key.startsWith(propertyPrefix)) {
                if (key.length() <= propertyPrefixLength) {
                    throw new IllegalArgumentException("Invalid kafka property: " + key);
                }

                String value = sp.getProperty(key);
                key = key.substring(propertyPrefixLength);

                props.setProperty(key, value);
            }
        }

        return props;
    }

    public static void send(String topic, byte[] value) {
        LOG.debug("send: topic={}, value={}", topic, value);
        producer.send(new ProducerRecord<>(topic, value));
    }
}
