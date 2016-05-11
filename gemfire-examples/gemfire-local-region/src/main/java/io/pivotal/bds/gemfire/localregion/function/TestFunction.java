package io.pivotal.bds.gemfire.localregion.function;

import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.execute.Function;
import com.gemstone.gemfire.cache.execute.FunctionContext;

import io.pivotal.bds.gemfire.data.ecom.AccountKey;
import io.pivotal.bds.gemfire.data.ecom.Order;
import io.pivotal.bds.gemfire.data.ecom.OrderKey;
import io.pivotal.bds.gemfire.localregion.data.AccountAggregate;
import io.pivotal.bds.gemfire.localregion.data.OrderAccumulator;
import io.pivotal.bds.gemfire.util.RegionHelper;

@SuppressWarnings("serial")
public class TestFunction implements Function, Declarable {

    private static final Logger LOG = LoggerFactory.getLogger(TestFunction.class);

    @Override
    public void execute(FunctionContext ctx) {
        Region<AccountKey, AccountAggregate> aggregateRegion = RegionHelper.getRegion("aggregate");
        Region<AccountKey, OrderAccumulator> accumulatorRegion = RegionHelper.getRegion("accumulator");

        for (Map.Entry<AccountKey, AccountAggregate> entry : aggregateRegion.entrySet()) {
            AccountKey key = entry.getKey();
            AccountAggregate aggr = entry.getValue();
            LOG.info("execute: accountKey={}, aggregate={}", key, aggr);

            Map<OrderKey, Order> orders = aggr.getOrders();

            for (Map.Entry<OrderKey, Order> oe : orders.entrySet()) {
                LOG.info("execute: orderKey={}, order={}", oe.getKey(), oe.getValue());
            }
        }

        for (Map.Entry<AccountKey, OrderAccumulator> entry : accumulatorRegion.entrySet()) {
            AccountKey key = entry.getKey();
            OrderAccumulator accum = entry.getValue();
            LOG.info("execute: accountKey={}, accumulator={}", key, accum);
        }
    }

    @Override
    public String getId() {
        return "TestFunction";
    }

    @Override
    public boolean hasResult() {
        return false;
    }

    @Override
    public boolean isHA() {
        return false;
    }

    @Override
    public boolean optimizeForWrite() {
        return false;
    }

    @Override
    public void init(Properties props) {
    }

}
