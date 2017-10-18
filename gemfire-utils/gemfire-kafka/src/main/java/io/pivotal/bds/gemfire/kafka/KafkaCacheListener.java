package io.pivotal.bds.gemfire.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.EntryEvent;
import org.apache.geode.cache.util.CacheListenerAdapter;

public class KafkaCacheListener<K, V> extends CacheListenerAdapter<K, V>implements Declarable {

    private String topic;
    private Producer<Object, EntryEvent<K, V>> producer;
    private static final Logger LOG = LoggerFactory.getLogger(KafkaCacheListener.class);

    @Override
    public void afterCreate(EntryEvent<K, V> event) {
        LOG.debug("afterCreate: event={}", event);
        producer.send(new ProducerRecord<Object, EntryEvent<K, V>>(topic, event));
    }

    @Override
    public void afterDestroy(EntryEvent<K, V> event) {
        LOG.debug("afterDestroy: event={}", event);
        producer.send(new ProducerRecord<Object, EntryEvent<K, V>>(topic, event));
    }

    @Override
    public void afterUpdate(EntryEvent<K, V> event) {
        LOG.debug("afterUpdate: event={}", event);
        producer.send(new ProducerRecord<Object, EntryEvent<K, V>>(topic, event));
    }

    @Override
    public void init(Properties props) {
        LOG.info("init: props={}", props);
        topic = props.getProperty("topic", "gemfire");
        producer = ProducerHelper.getProducer(props);
    }

}
