package io.pivotal.bds.gemfire.kafka;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.EntryEvent;
import com.gemstone.gemfire.cache.util.CacheListenerAdapter;

public class KafkaCacheListener<K, V> extends CacheListenerAdapter<K, V>implements Declarable {

    private String topic;
    private static final Logger LOG = LoggerFactory.getLogger(KafkaCacheListener.class);
    private final EntryEventSerializer<K, V> serializer = new EntryEventSerializer<>();

    @Override
    public void afterCreate(EntryEvent<K, V> event) {
        LOG.debug("afterCreate: event={}", event);
        byte[] data = serializer.serialize(topic, event);
        ProducerHelper.send(topic, data);
    }

    @Override
    public void afterDestroy(EntryEvent<K, V> event) {
        LOG.debug("afterDestroy: event={}", event);
        byte[] data = serializer.serialize(topic, event);
        ProducerHelper.send(topic, data);
    }

    @Override
    public void afterUpdate(EntryEvent<K, V> event) {
        LOG.debug("afterUpdate: event={}", event);
        byte[] data = serializer.serialize(topic, event);
        ProducerHelper.send(topic, data);
    }

    @Override
    public void init(Properties props) {
        ProducerHelper.init();
        topic = props.getProperty("topic", "gemfire");
        LOG.info("init: topic={}", topic);
    }

}
