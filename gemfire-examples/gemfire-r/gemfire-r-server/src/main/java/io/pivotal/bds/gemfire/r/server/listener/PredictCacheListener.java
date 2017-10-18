package io.pivotal.bds.gemfire.r.server.listener;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.EntryEvent;
import org.apache.geode.cache.Operation;
import org.apache.geode.cache.util.CacheListenerAdapter;

import io.pivotal.bds.gemfire.r.server.util.PredictHandler;

public class PredictCacheListener<K, V> extends CacheListenerAdapter<K, V>implements Declarable {

    private static final Logger LOG = LoggerFactory.getLogger(PredictCacheListener.class);

    @Override
    public void afterCreate(EntryEvent<K, V> event) {
        LOG.debug("afterCreate: event={}", event);
        handle(event);
    }

    @Override
    public void afterUpdate(EntryEvent<K, V> event) {
        LOG.debug("afterUpdate: event={}", event);
        handle(event);
    }

    @Override
    public void init(Properties props) {
    }

    private void handle(EntryEvent<K, V> event) {
        String regionName = event.getRegion().getName();
        Operation op = event.getOperation();
        K key = event.getKey();
        V value = event.getNewValue();
        
        PredictHandler.handle(regionName, op, key, value);
    }
}
