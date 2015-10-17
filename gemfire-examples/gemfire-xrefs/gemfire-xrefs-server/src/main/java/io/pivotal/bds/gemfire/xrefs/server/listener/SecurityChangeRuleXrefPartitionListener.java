package io.pivotal.bds.gemfire.xrefs.server.listener;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.partition.PartitionListener;
import com.gemstone.gemfire.cache.partition.PartitionRegionHelper;

import io.pivotal.bds.gemfire.xrefs.common.ChangeRule;
import io.pivotal.bds.gemfire.xrefs.common.ChangeRuleKey;
import io.pivotal.bds.gemfire.xrefs.common.SecurityKey;
import io.pivotal.bds.gemfire.xrefs.server.data.PDXConcurrentList;

public class SecurityChangeRuleXrefPartitionListener implements PartitionListener {

    private Region<ChangeRuleKey, ChangeRule> changeRuleRegion;
    private Region<SecurityKey, PDXConcurrentList<ChangeRuleKey>> xrefRegion;

    private static final Logger LOG = LoggerFactory.getLogger(SecurityChangeRuleXrefPartitionListener.class);

    public SecurityChangeRuleXrefPartitionListener(Region<SecurityKey, PDXConcurrentList<ChangeRuleKey>> xrefRegion) {
        this.xrefRegion = xrefRegion;
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
            SecurityKey sk = cr.getSecurityKey();

            PDXConcurrentList<ChangeRuleKey> l = xrefRegion.get(sk);
            l.remove(crk);
            xrefRegion.put(sk, l);
        }
    }

    @Override
    public void afterPrimary(int bucketId) {
        LOG.info("afterPrimary: bucketId={}", bucketId);
        Region<ChangeRuleKey, ChangeRule> r = PartitionRegionHelper.getLocalPrimaryData(changeRuleRegion);

        for (Map.Entry<ChangeRuleKey, ChangeRule> e : r.entrySet()) {
            ChangeRuleKey crk = e.getKey();
            ChangeRule cr = e.getValue();
            SecurityKey sk = cr.getSecurityKey();

            PDXConcurrentList<ChangeRuleKey> l = xrefRegion.get(sk);
            l.add(crk);
            xrefRegion.put(sk, l);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void afterRegionCreate(Region<?, ?> region) {
        LOG.info("afterRegionCreate: region={}", region.getName());
        changeRuleRegion = (Region<ChangeRuleKey, ChangeRule>) region;
    }

}
