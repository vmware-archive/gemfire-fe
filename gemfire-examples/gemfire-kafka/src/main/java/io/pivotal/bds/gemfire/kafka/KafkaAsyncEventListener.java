package io.pivotal.bds.gemfire.kafka;

import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.asyncqueue.AsyncEvent;
import com.gemstone.gemfire.cache.asyncqueue.AsyncEventListener;

public class KafkaAsyncEventListener implements AsyncEventListener, Declarable {

    private String topic;
    private static final Logger LOG = LoggerFactory.getLogger(KafkaAsyncEventListener.class);
    private static final AsyncEventSerializer serializer = new AsyncEventSerializer();

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public boolean processEvents(List<AsyncEvent> events) {
        LOG.debug("processEvents: events.size={}", events.size());

        try {
            for (AsyncEvent event : events) {
                LOG.debug("processEvents: event={}", event);
                byte[] value = serializer.serialize(topic, event);
                ProducerHelper.send(topic, value);
            }

            return true;
        } catch (Exception x) {
            LOG.error("processEvents: x={}", x.toString(), x);
            return false;
        }
    }

    @Override
    public void init(Properties props) {
        ProducerHelper.init();
        topic = props.getProperty("topic", "gemfire");
        LOG.info("init: topic={}", topic);
    }

    @Override
    public void close() {
    }

}
