package io.pivotal.bds.gemfire.localregion.listener;

import java.util.Properties;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.partition.PartitionListener;
import com.gemstone.gemfire.internal.cache.PartitionedRegion;

import io.pivotal.bds.gemfire.data.ecom.Account;
import io.pivotal.bds.gemfire.data.ecom.AccountKey;
import io.pivotal.bds.gemfire.localregion.data.AccountAggregate;
import io.pivotal.bds.gemfire.localregion.data.OrderAccumulator;
import io.pivotal.bds.gemfire.util.RegionHelper;

public class AccountPartitionListener implements PartitionListener, Declarable {

    private Region<?, ?> region;
    private static final Logger LOG = LoggerFactory.getLogger(AccountPartitionListener.class);

    @Override
    public void afterBucketCreated(int bucketId, Iterable<?> keys) {
        LOG.info("afterBucketCreated: bucketId={}, region={}", bucketId, region.getName());
    }

    @Override
    public void afterBucketRemoved(int bucketId, Iterable<?> keys) {
        LOG.info("afterBucketRemoved: bucketId={}, region={}", bucketId, region.getName());
        Region<AccountKey, AccountAggregate> aggregateRegion = RegionHelper.getRegion("aggregate");
        Region<AccountKey, OrderAccumulator> accumulatorRegion = RegionHelper.getRegion("accumulator");

        for (Object okey : keys) {
            LOG.debug("afterBucketRemoved: bucketId={}, okey={}", bucketId, okey);
            AccountKey akey = (AccountKey) okey;
            aggregateRegion.remove(akey);
            accumulatorRegion.remove(akey);
        }
    }

    @Override
    public void afterPrimary(int bucketId) {
        LOG.info("afterPrimary: bucketId={}, region={}", bucketId, region.getName());
        Region<AccountKey, AccountAggregate> aggregateRegion = RegionHelper.getRegion("aggregate");
        Region<AccountKey, OrderAccumulator> accumulatorRegion = RegionHelper.getRegion("accumulator");

        Region<AccountKey, Account> accountRegion = RegionHelper.getRegion("account");
        PartitionedRegion preg = (PartitionedRegion) accountRegion;

        Set<?> keys = preg.getBucketKeys(bucketId);

        for (Object okey : keys) {
            LOG.debug("afterPrimary: bucketId={}, okey={}", bucketId, okey);
            AccountKey akey = (AccountKey) okey;
            Account account = accountRegion.get(akey);
            aggregateRegion.get(akey, account); // uses AggregateCacheLoader
            accumulatorRegion.remove(akey); // clean out, OrderPartitionListener will update
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
