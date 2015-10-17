package io.pivotal.bds.gemfire.xrefs.server.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.EntryEvent;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.util.CacheListenerAdapter;

import io.pivotal.bds.gemfire.xrefs.common.AccountKey;
import io.pivotal.bds.gemfire.xrefs.common.ChangeRule;
import io.pivotal.bds.gemfire.xrefs.common.ChangeRuleKey;
import io.pivotal.bds.gemfire.xrefs.server.data.PDXConcurrentList;

public class AccountChangeRuleXrefCacheListener extends CacheListenerAdapter<ChangeRuleKey, ChangeRule> {

    private Region<AccountKey, PDXConcurrentList<ChangeRuleKey>> xrefRegion;

    private static final Logger LOG = LoggerFactory.getLogger(AccountChangeRuleXrefCacheListener.class);

    public AccountChangeRuleXrefCacheListener(Region<AccountKey, PDXConcurrentList<ChangeRuleKey>> xrefRegion) {
        this.xrefRegion = xrefRegion;
    }

    @Override
    public void afterCreate(EntryEvent<ChangeRuleKey, ChangeRule> event) {
        ChangeRuleKey crk = event.getKey();
        ChangeRule cr = event.getNewValue();
        LOG.info("afterCreate: crk={}, cr={}", crk, cr);
        
        AccountKey ak = cr.getAccountKey();

        PDXConcurrentList<ChangeRuleKey> l = xrefRegion.get(ak);
        l.add(crk);
        xrefRegion.put(ak, l);
    }

}
