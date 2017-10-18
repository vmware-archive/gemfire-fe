package io.pivotal.bds.gemfire.kafka;

import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.asyncqueue.AsyncEvent;
import org.apache.geode.cache.asyncqueue.AsyncEventListener;

public class KafkaAsyncEventListener implements AsyncEventListener, Declarable {

    private String topic;
    @SuppressWarnings("rawtypes")
    private Producer<Object, AsyncEvent> producer;
    private static final Logger LOG = LoggerFactory.getLogger(KafkaAsyncEventListener.class);

    @SuppressWarnings({ "rawtypes" })
    @Override
    public boolean processEvents(List<AsyncEvent> events) {
        LOG.debug("processEvents: events.size={}", events.size());

        try {
            for (AsyncEvent event : events) {
                LOG.debug("processEvents: topic={}, event={}", topic, event);
                producer.send(new ProducerRecord<Object, AsyncEvent>(topic, event));
            }

            return true;
        } catch (Exception x) {
            LOG.error("processEvents: x={}", x.toString(), x);
            return false;
        }
    }

    @Override
    public void init(Properties props) {
        LOG.info("init: props={}", props);
        topic = props.getProperty("topic", "gemfire");
        props.remove("topic");
        producer = ProducerHelper.getProducer(props);
    }

    @Override
    public void close() {
    }

}
