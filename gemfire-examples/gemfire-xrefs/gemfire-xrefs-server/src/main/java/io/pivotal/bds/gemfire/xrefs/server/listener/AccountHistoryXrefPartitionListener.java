package io.pivotal.bds.gemfire.xrefs.server.listener;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.partition.PartitionListener;
import org.apache.geode.internal.cache.PartitionedRegion;

import io.pivotal.bds.gemfire.data.securities.AccountHistory;
import io.pivotal.bds.gemfire.data.securities.AccountHistoryKey;
import io.pivotal.bds.gemfire.data.securities.AccountKey;

public class AccountHistoryXrefPartitionListener implements PartitionListener {

    private Region<AccountHistoryKey, AccountHistory> accountHistoryRegion;
    private Region<AccountKey, Set<AccountHistoryKey>> accountHistoryXrefRegion;

    private static final Logger LOG = LoggerFactory.getLogger(AccountHistoryXrefPartitionListener.class);

    public AccountHistoryXrefPartitionListener(Region<AccountKey, Set<AccountHistoryKey>> accountHistoryXrefRegion) {
        this.accountHistoryXrefRegion = accountHistoryXrefRegion;
    }

    @Override
    public void afterBucketCreated(int bucketId, Iterable<?> keys) {
        LOG.info("afterBucketCreated: bucketId={}", bucketId);
    }

    @Override
    public void afterBucketRemoved(int bucketId, Iterable<?> keys) {
        LOG.info("afterBucketRemoved: bucketId={}", bucketId);

        for (Object ok : keys) {
            AccountHistoryKey ahk = (AccountHistoryKey) ok;
            AccountHistory ah = accountHistoryRegion.get(ahk);
            AccountKey ak = ah.getAccountKey();

            Set<AccountHistoryKey> l = accountHistoryXrefRegion.get(ak);
            l.remove(ahk);
            accountHistoryXrefRegion.put(ak, l);
        }
    }

    @Override
    public void afterPrimary(int bucketId) {
        LOG.info("afterPrimary: bucketId={}", bucketId);
        PartitionedRegion pr = (PartitionedRegion) accountHistoryRegion;
        Set<?> keys = pr.getBucketKeys(bucketId);

        for (Object ok : keys) {
            AccountHistoryKey ahk = (AccountHistoryKey) ok;
            AccountHistory ah = accountHistoryRegion.get(ahk);
            AccountKey ak = ah.getAccountKey();

            Set<AccountHistoryKey> l = accountHistoryXrefRegion.get(ak);
            l.add(ahk);
            accountHistoryXrefRegion.put(ak, l);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void afterRegionCreate(Region<?, ?> region) {
        LOG.info("afterRegionCreate: region={}", region.getName());
        accountHistoryRegion = (Region<AccountHistoryKey, AccountHistory>) region;
    }

}
