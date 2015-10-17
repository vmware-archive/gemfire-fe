package io.pivotal.bds.gemfire.xrefs.server.listener;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.partition.PartitionListener;
import com.gemstone.gemfire.cache.partition.PartitionRegionHelper;

import io.pivotal.bds.gemfire.xrefs.common.AccountKey;
import io.pivotal.bds.gemfire.xrefs.common.ChangeRule;
import io.pivotal.bds.gemfire.xrefs.common.ChangeRuleKey;
import io.pivotal.bds.gemfire.xrefs.server.data.PDXConcurrentList;

public class AccountChangeRuleXrefPartitionListener implements PartitionListener {

    private Region<ChangeRuleKey, ChangeRule> changeRuleRegion;
    private Region<AccountKey, PDXConcurrentList<ChangeRuleKey>> accountChangeRuleXrefRegion;

    private static final Logger LOG = LoggerFactory.getLogger(AccountChangeRuleXrefPartitionListener.class);

    public AccountChangeRuleXrefPartitionListener(
            Region<AccountKey, PDXConcurrentList<ChangeRuleKey>> accountChangeRuleXrefRegion) {
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

            PDXConcurrentList<ChangeRuleKey> l = accountChangeRuleXrefRegion.get(ak);
            l.remove(crk);
            accountChangeRuleXrefRegion.put(ak, l);
        }
    }

    @Override
    public void afterPrimary(int bucketId) {
        LOG.info("afterPrimary: bucketId={}", bucketId);
        Region<ChangeRuleKey, ChangeRule> r = PartitionRegionHelper.getLocalPrimaryData(changeRuleRegion);

        for (Map.Entry<ChangeRuleKey, ChangeRule> entry : r.entrySet()) {
            ChangeRuleKey crk = entry.getKey();
            ChangeRule cr = entry.getValue();
            AccountKey ak = cr.getAccountKey();

            PDXConcurrentList<ChangeRuleKey> l = accountChangeRuleXrefRegion.get(ak);
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
