package io.pivotal.bds.gemfire.xrefs.server.listener;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.partition.PartitionListener;
import com.gemstone.gemfire.internal.cache.PartitionedRegion;

import io.pivotal.bds.gemfire.data.securities.ChangeRule;
import io.pivotal.bds.gemfire.data.securities.ChangeRuleKey;
import io.pivotal.bds.gemfire.data.securities.SecurityKey;

public class SecurityChangeRuleXrefPartitionListener implements PartitionListener {

    private Region<ChangeRuleKey, ChangeRule> changeRuleRegion;
    private Region<SecurityKey, Set<ChangeRuleKey>> xrefRegion;

    private static final Logger LOG = LoggerFactory.getLogger(SecurityChangeRuleXrefPartitionListener.class);

    public SecurityChangeRuleXrefPartitionListener(Region<SecurityKey, Set<ChangeRuleKey>> xrefRegion) {
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

            Set<ChangeRuleKey> l = xrefRegion.get(sk);
            l.remove(crk);
            xrefRegion.put(sk, l);
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
            SecurityKey sk = cr.getSecurityKey();

            Set<ChangeRuleKey> l = xrefRegion.get(sk);
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
