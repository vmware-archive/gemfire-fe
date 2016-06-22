package io.pivotal.bds.gemfire.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.CacheWriterException;
import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.EntryEvent;
import com.gemstone.gemfire.cache.util.CacheWriterAdapter;

public class KafkaCacheWriter<K, V> extends CacheWriterAdapter<K, V>implements Declarable {

    private String topic;
    private Producer<Object, EntryEvent<K, V>> producer;
    private static final Logger LOG = LoggerFactory.getLogger(KafkaCacheWriter.class);

    @Override
    public void beforeCreate(EntryEvent<K, V> event) throws CacheWriterException {
        LOG.debug("beforeCreate: event={}", event);
        producer.send(new ProducerRecord<Object, EntryEvent<K, V>>(topic, event));
    }

    @Override
    public void beforeDestroy(EntryEvent<K, V> event) throws CacheWriterException {
        LOG.debug("beforeDestroy: event={}", event);
        producer.send(new ProducerRecord<Object, EntryEvent<K, V>>(topic, event));
    }

    @Override
    public void beforeUpdate(EntryEvent<K, V> event) throws CacheWriterException {
        LOG.debug("beforeUpdate: event={}", event);
        producer.send(new ProducerRecord<Object, EntryEvent<K, V>>(topic, event));
    }

    @Override
    public void init(Properties props) {
        LOG.info("init: props={}", props);
        topic = props.getProperty("topic", "gemfire");
        producer = ProducerHelper.getProducer(props);
    }

}
