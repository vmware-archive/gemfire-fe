package io.pivotal.bds.gemfire.kafka;

import java.util.Map;

import org.apache.geode.cache.Operation;
import org.apache.geode.cache.asyncqueue.AsyncEvent;

public class AsyncEventJsonSerializer extends BaseJsonSerializer<AsyncEvent<Object, Object>> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public byte[] serialize(String topic, AsyncEvent<Object, Object> event) {
        LOG.debug("serialize: topic={}, event={}", topic, event);
        Object key = event.getKey();
        Object value = event.getDeserializedValue();
        Operation op = event.getOperation();
        return serialize(key, value, op);
    }

    @Override
    public void close() {
    }

}
