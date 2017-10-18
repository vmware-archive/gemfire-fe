package io.pivotal.bds.gemfire.localregion.listener;

import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.Operation;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.asyncqueue.AsyncEvent;
import org.apache.geode.cache.asyncqueue.AsyncEventListener;

import io.pivotal.bds.gemfire.data.ecom.AccountKey;
import io.pivotal.bds.gemfire.data.ecom.Order;
import io.pivotal.bds.gemfire.localregion.data.OrderAccumulator;
import io.pivotal.bds.gemfire.util.RegionHelper;

public class AccumulatorAsyncEventListener implements AsyncEventListener, Declarable {

    private static final Logger LOG = LoggerFactory.getLogger(AccumulatorAsyncEventListener.class);

    @SuppressWarnings("rawtypes")
    @Override
    public boolean processEvents(List<AsyncEvent> events) {
        try {
            Region<AccountKey, OrderAccumulator> accumulatorRegion = RegionHelper.getRegion("accumulator");

            for (AsyncEvent event : events) {
                Operation op = event.getOperation();

                Order order = (Order) event.getDeserializedValue();
                AccountKey accountKey = order.getAccountKey();

                LOG.debug("processEvents: op={}, order={}", op, order);

                OrderAccumulator accum = accumulatorRegion.get(accountKey);

                if (op.isCreate()) {
                    accum.add(order);
                    accumulatorRegion.put(accountKey, accum);
                } else if (op.isDestroy()) {
                    accum.remove(order);
                    accumulatorRegion.put(accountKey, accum);
                }
            }

            return true;
        } catch (Exception x) {
            LOG.error(x.toString(), x);
        }

        return false;
    }

    @Override
    public void init(Properties props) {
    }

    @Override
    public void close() {
    }

}
