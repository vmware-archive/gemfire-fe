package io.pivotal.bds.gemfire.fraud.server.listener;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.driver.mapping.Mapper;
import com.gemstone.gemfire.cache.Operation;
import com.gemstone.gemfire.cache.asyncqueue.AsyncEvent;
import com.gemstone.gemfire.cache.asyncqueue.AsyncEventListener;

public class CassandraAsyncEventListener<V> implements AsyncEventListener {

    private Mapper<V> mapper;
    private static final Logger LOG = LoggerFactory.getLogger(CassandraAsyncEventListener.class);

    public CassandraAsyncEventListener(Mapper<V> mapper) {
        this.mapper = mapper;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public boolean processEvents(List<AsyncEvent> events) {
        LOG.debug("processEvents: events.size={}", events.size());

        try {
            for (AsyncEvent event : events) {
                Operation op = event.getOperation();
                V value = (V) event.getDeserializedValue();
                LOG.debug("processEvents: op={}, value={}", op, value);

                if ((op.isCreate() || op.isUpdate()) && !op.isLoad()) {
                    mapper.save(value);
                } else if (op.isDestroy() && !op.isEviction() && !op.isExpiration()) {
                    mapper.delete(value);
                }
            }
        } catch (Exception x) {
            LOG.error("processEvents: x={}", x.toString(), x);
        }

        return true;
    }

    @Override
    public void close() {
    }

}
