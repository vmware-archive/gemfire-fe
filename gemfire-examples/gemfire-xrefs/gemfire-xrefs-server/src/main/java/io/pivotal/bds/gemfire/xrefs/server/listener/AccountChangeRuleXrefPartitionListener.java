package io.pivotal.bds.gemfire.xrefs.server.listener;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.partition.PartitionListener;
import org.apache.geode.internal.cache.PartitionedRegion;

import io.pivotal.bds.gemfire.data.securities.AccountKey;
import io.pivotal.bds.gemfire.data.securities.ChangeRule;
import io.pivotal.bds.gemfire.data.securities.ChangeRuleKey;

public class AccountChangeRuleXrefPartitionListener implements PartitionListener {

    private Region<ChangeRuleKey, ChangeRule> changeRuleRegion;
    private Region<AccountKey, Set<ChangeRuleKey>> accountChangeRuleXrefRegion;

    private static final Logger LOG = LoggerFactory.getLogger(AccountChangeRuleXrefPartitionListener.class);

    public AccountChangeRuleXrefPartitionListener(
            Region<AccountKey, Set<ChangeRuleKey>> accountChangeRuleXrefRegion) {
        this.accountChangeRuleXrefRegion = accountChangeRuleXrefRegion;
    }

    @Override
    public void afterBucketCreated(int bucketId, Iterable<?> keys) {
        LOG.info("afterBucketCreated: bucketId={}", bucketId);
    }

    @Override
    public void afterBucketRemoved(int bucketId, Iterable<?> keys) {
        LOG.info("afterBucketRemoved: bucketId={}", bucketId);

        for (Object ok : keys) {
            ChangeRuleKey crk = (ChangeRuleKey) ok;
            ChangeRule cr = changeRuleRegion.get(crk);
            AccountKey ak = cr.getAccountKey();

            Set<ChangeRuleKey> l = accountChangeRuleXrefRegion.get(ak);
            l.remove(crk);
            accountChangeRuleXrefRegion.put(ak, l);
        }
    }

    @Override
    public void afterPrimary(int bucketId) {
        LOG.info("afterPrimary: bucketId={}", bucketId);
        PartitionedRegion pr = (PartitionedRegion)changeRuleRegion;
        Set<?> keys = pr.getBucketKeys(bucketId);

        for (Object ok : keys) {
            ChangeRuleKey crk = (ChangeRuleKey)ok;
            ChangeRule cr = changeRuleRegion.get(crk);
            AccountKey ak = cr.getAccountKey();

            Set<ChangeRuleKey> l = accountChangeRuleXrefRegion.get(ak);
            l.add(crk);
            accountChangeRuleXrefRegion.put(ak, l);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void afterRegionCreate(Region<?, ?> region) {
        LOG.info("afterRegionCreate: region={}", region.getName());
        changeRuleRegion = (Region<ChangeRuleKey, ChangeRule>) region;
    }

}
