package io.pivotal.bds.gemfire.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProducerHelper {

    private static final String propertyPrefix = "kafka.";
    private static final int propertyPrefixLength = propertyPrefix.length();
    private static final Logger LOG = LoggerFactory.getLogger(ProducerHelper.class);

    public static final <K, V> Producer<K, V> getProducer(Properties properties) {
        Properties props = getProps();
        props.putAll(properties);
        LOG.info("getProducer: props={}", props);
        return new KafkaProducer<>(props);
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
}
