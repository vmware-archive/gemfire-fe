package io.pivotal.bds.gemfire.r.server.listener;

import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.Operation;
import org.apache.geode.cache.asyncqueue.AsyncEvent;

import io.pivotal.bds.gemfire.r.server.util.Handler;
import io.pivotal.bds.gemfire.util.BackoffAsyncEventListener;

public class HandlerAsyncEventListener extends BackoffAsyncEventListener implements Declarable {

    private static final Logger LOG = LoggerFactory.getLogger(HandlerAsyncEventListener.class);

    @SuppressWarnings("rawtypes")
    @Override
    protected void doProcessEvents(List<AsyncEvent> events) throws Exception {
        LOG.debug("doProcessEvents: events.size={}", events.size());

        for (AsyncEvent evt : events) {
            LOG.debug("doProcessEvents: evt={}", evt);

            Operation op = evt.getOperation();
            String regionName = evt.getRegion().getName();
            Object key = evt.getKey();
            Object value = evt.getDeserializedValue();

            Handler.handle(regionName, op, key, value);
        }
    }

    @Override
    public void init(Properties props) {
    }

    @Override
    public void close() {
    }

}
