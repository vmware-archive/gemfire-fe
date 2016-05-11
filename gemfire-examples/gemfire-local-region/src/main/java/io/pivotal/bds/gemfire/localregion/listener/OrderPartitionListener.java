package io.pivotal.bds.gemfire.localregion.listener;

import java.util.Properties;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.partition.PartitionListener;
import com.gemstone.gemfire.internal.cache.PartitionedRegion;

import io.pivotal.bds.gemfire.data.ecom.AccountKey;
import io.pivotal.bds.gemfire.data.ecom.Order;
import io.pivotal.bds.gemfire.data.ecom.OrderKey;
import io.pivotal.bds.gemfire.localregion.data.AccountAggregate;
import io.pivotal.bds.gemfire.localregion.data.OrderAccumulator;
import io.pivotal.bds.gemfire.util.RegionHelper;

public class OrderPartitionListener implements PartitionListener, Declarable {

    private Region<?, ?> region;
    private static final Logger LOG = LoggerFactory.getLogger(OrderPartitionListener.class);

    @Override
    public void afterBucketCreated(int bucketId, Iterable<?> keys) {
        LOG.info("afterBucketCreated: bucketId={}, region={}", bucketId, region.getName());
    }

    @Override
    public void afterBucketRemoved(int bucketId, Iterable<?> keys) {
        LOG.info("afterBucketRemoved: bucketId={}, region={}", bucketId, region.getName());
        Region<AccountKey, AccountAggregate> aggregateRegion = RegionHelper.getRegion("aggregate");
        Region<AccountKey, OrderAccumulator> accumulatorRegion = RegionHelper.getRegion("accumulator");
        Region<OrderKey, Order> orderRegion = RegionHelper.getRegion("order");

        for (Object okey : keys) {
            LOG.debug("afterBucketRemoved: bucketId={}, okey={}", bucketId, okey);
            OrderKey rkey = (OrderKey) okey;
            Order order = orderRegion.get(rkey);
            AccountKey akey = order.getAccountKey();

            AccountAggregate aggr = aggregateRegion.get(akey);
            aggr.getOrders().remove(rkey);
            aggregateRegion.put(akey, aggr);

            OrderAccumulator accum = accumulatorRegion.get(akey);
            accum.remove(order);
            accumulatorRegion.put(akey, accum);
        }
    }

    @Override
    public void afterPrimary(int bucketId) {
        LOG.info("afterPrimary: bucketId={}, region={}", bucketId, region.getName());
        Region<AccountKey, AccountAggregate> aggregateRegion = RegionHelper.getRegion("aggregate");
        Region<AccountKey, OrderAccumulator> accumulatorRegion = RegionHelper.getRegion("accumulator");
        Region<OrderKey, Order> orderRegion = RegionHelper.getRegion("order");
        PartitionedRegion preg = (PartitionedRegion) orderRegion;

        Set<?> keys = preg.getBucketKeys(bucketId);

        for (Object okey : keys) {
            LOG.debug("afterPrimary: bucketId={}, okey={}", bucketId, okey);
            OrderKey rkey = (OrderKey) okey;
            Order order = orderRegion.get(rkey);

            AccountKey akey = order.getAccountKey();

            AccountAggregate aggr = aggregateRegion.get(akey);
            aggr.getOrders().put(rkey, order);
            aggregateRegion.put(akey, aggr);

            OrderAccumulator accum = accumulatorRegion.get(akey);
            accum.add(order);
            accumulatorRegion.put(akey, accum);
        }
    }

    @Override
    public void afterRegionCreate(Region<?, ?> region) {
        LOG.info("afterRegionCreate: region={}", region.getName());
        this.region = region;
    }

    @Override
    public void init(Properties props) {
    }

}
