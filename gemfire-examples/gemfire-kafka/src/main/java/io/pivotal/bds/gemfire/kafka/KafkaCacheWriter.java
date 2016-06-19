package io.pivotal.bds.gemfire.kafka;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.CacheWriterException;
import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.EntryEvent;
import com.gemstone.gemfire.cache.util.CacheWriterAdapter;

public class KafkaCacheWriter<K, V> extends CacheWriterAdapter<K, V>implements Declarable {

    private String topic;
    private static final Logger LOG = LoggerFactory.getLogger(KafkaCacheWriter.class);
    private final EntryEventSerializer<K, V> serializer = new EntryEventSerializer<>();

    @Override
    public void beforeCreate(EntryEvent<K, V> event) throws CacheWriterException {
        LOG.debug("beforeCreate: event={}", event);
        byte[] data = serializer.serialize(topic, event);
        ProducerHelper.send(topic, data);
    }

    @Override
    public void beforeDestroy(EntryEvent<K, V> event) throws CacheWriterException {
        LOG.debug("beforeDestroy: event={}", event);
        byte[] data = serializer.serialize(topic, event);
        ProducerHelper.send(topic, data);
    }

    @Override
    public void beforeUpdate(EntryEvent<K, V> event) throws CacheWriterException {
        LOG.debug("beforeUpdate: event={}", event);
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
