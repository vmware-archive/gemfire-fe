package io.pivotal.bds.gemfire.xrefs.server.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.EntryEvent;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.util.CacheListenerAdapter;

import io.pivotal.bds.gemfire.xrefs.common.ChangeRule;
import io.pivotal.bds.gemfire.xrefs.common.ChangeRuleKey;
import io.pivotal.bds.gemfire.xrefs.common.SecurityKey;
import io.pivotal.bds.gemfire.xrefs.server.data.PDXConcurrentList;

public class SecurityChangeRuleXrefCacheListener extends CacheListenerAdapter<ChangeRuleKey, ChangeRule> {

    private Region<SecurityKey, PDXConcurrentList<ChangeRuleKey>> xrefRegion;

    private static final Logger LOG = LoggerFactory.getLogger(SecurityChangeRuleXrefCacheListener.class);

    public SecurityChangeRuleXrefCacheListener(Region<SecurityKey, PDXConcurrentList<ChangeRuleKey>> xrefRegion) {
        this.xrefRegion = xrefRegion;
    }

    @Override
    public void afterCreate(EntryEvent<ChangeRuleKey, ChangeRule> event) {
        ChangeRuleKey crk = event.getKey();
        ChangeRule cr = event.getNewValue();
        LOG.info("afterCreate: crk={}, cr={}", crk, cr);
        
        SecurityKey sk = cr.getSecurityKey();
        PDXConcurrentList<ChangeRuleKey> l = xrefRegion.get(sk);
        l.add(crk);
        xrefRegion.put(sk, l);
    }

    @Override
    public void afterDestroy(EntryEvent<ChangeRuleKey, ChangeRule> event) {
        ChangeRuleKey crk = event.getKey();
        ChangeRule cr = event.getOldValue();
        LOG.info("afterDestroy: crk={}, cr={}", crk, cr);
        
        SecurityKey sk = cr.getSecurityKey();
        PDXConcurrentList<ChangeRuleKey> l = xrefRegion.get(sk);
        l.remove(crk);
        xrefRegion.put(sk, l);
    }

}
