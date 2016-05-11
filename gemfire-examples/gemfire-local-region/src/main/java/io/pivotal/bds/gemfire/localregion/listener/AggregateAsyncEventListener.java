package io.pivotal.bds.gemfire.localregion.listener;

import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.Operation;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.asyncqueue.AsyncEvent;
import com.gemstone.gemfire.cache.asyncqueue.AsyncEventListener;

import io.pivotal.bds.gemfire.data.ecom.Account;
import io.pivotal.bds.gemfire.data.ecom.AccountKey;
import io.pivotal.bds.gemfire.data.ecom.Order;
import io.pivotal.bds.gemfire.data.ecom.OrderKey;
import io.pivotal.bds.gemfire.localregion.data.AccountAggregate;
import io.pivotal.bds.gemfire.util.RegionHelper;

public class AggregateAsyncEventListener implements AsyncEventListener, Declarable {

    private static final Logger LOG = LoggerFactory.getLogger(AggregateAsyncEventListener.class);

    @SuppressWarnings("rawtypes")
    @Override
    public boolean processEvents(List<AsyncEvent> events) {
        Region<OrderKey, Order> orderRegion = RegionHelper.getRegion("order");
        Region<AccountKey, AccountAggregate> aggregateRegion = RegionHelper.getRegion("aggregate");

        try {
            for (AsyncEvent event : events) {
                Operation op = event.getOperation();
                Object okey = event.getKey();
                Region<?, ?> region = event.getRegion();

                LOG.debug("processEvents: okey={}, op={}, region={}", okey, op, region.getName());

                if (okey instanceof AccountKey) {
                    AccountKey akey = (AccountKey) okey;

                    if (op.isDestroy()) {
                        aggregateRegion.remove(akey);
                    } else if (op.isCreate()) {
                        Account acct = (Account) event.getDeserializedValue();
                        aggregateRegion.get(akey, acct); // uses AggregateCacheLoader
                    } else if (op.isUpdate()) {
                        Account acct = (Account) event.getDeserializedValue();
                        AccountAggregate aggr = aggregateRegion.get(akey);
                        aggr.setAccount(acct);
                        aggregateRegion.put(akey, aggr);
                    }
                } else if (okey instanceof OrderKey) {
                    if (op.isDestroy()) {
                        OrderKey rkey = (OrderKey) okey;
                        Order order = orderRegion.get(rkey);
                        AccountKey akey = order.getAccountKey();
                        AccountAggregate aggr = aggregateRegion.get(akey);
                        aggr.getOrders().remove(rkey);
                        aggregateRegion.put(akey, aggr);
                    } else if (op.isCreate() || op.isUpdate()) {
                        OrderKey rkey = (OrderKey) okey;
                        Order order = orderRegion.get(rkey);
                        AccountKey akey = order.getAccountKey();
                        AccountAggregate aggr = aggregateRegion.get(akey);
                        aggr.getOrders().put(rkey, order);
                        aggregateRegion.put(akey, aggr);
                    }
                }
            }

            return true;
        } catch (Exception x) {
            LOG.error("processEvents: x={}", x.toString(), x);
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
