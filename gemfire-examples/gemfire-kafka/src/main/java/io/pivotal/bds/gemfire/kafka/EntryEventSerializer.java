package io.pivotal.bds.gemfire.kafka;

import java.util.Map;

import com.gemstone.gemfire.cache.EntryEvent;
import com.gemstone.gemfire.cache.Operation;

public class EntryEventSerializer<K, V> extends BaseSerializer<EntryEvent<K, V>> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public byte[] serialize(String topic, EntryEvent<K, V> event) {
        LOG.debug("serialize: topic={}, event={}", topic, event);
        Operation op = event.getOperation();
        Object key = event.getKey();
        Object value = op.isDestroy() ? event.getOldValue() : event.getNewValue();
        return serialize(key, value, op);
    }

    @Override
    public void close() {
    }

}
