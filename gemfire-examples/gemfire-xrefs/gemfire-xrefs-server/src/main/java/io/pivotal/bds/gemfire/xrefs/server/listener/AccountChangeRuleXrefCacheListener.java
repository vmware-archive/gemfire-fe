package io.pivotal.bds.gemfire.xrefs.server.listener;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.EntryEvent;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.util.CacheListenerAdapter;

import io.pivotal.bds.gemfire.data.securities.AccountKey;
import io.pivotal.bds.gemfire.data.securities.ChangeRule;
import io.pivotal.bds.gemfire.data.securities.ChangeRuleKey;

public class AccountChangeRuleXrefCacheListener extends CacheListenerAdapter<ChangeRuleKey, ChangeRule> {

    private Region<AccountKey, Set<ChangeRuleKey>> xrefRegion;

    private static final Logger LOG = LoggerFactory.getLogger(AccountChangeRuleXrefCacheListener.class);

    public AccountChangeRuleXrefCacheListener(Region<AccountKey, Set<ChangeRuleKey>> xrefRegion) {
        this.xrefRegion = xrefRegion;
    }

    @Override
    public void afterCreate(EntryEvent<ChangeRuleKey, ChangeRule> event) {
        ChangeRuleKey crk = event.getKey();
        ChangeRule cr = event.getNewValue();
        LOG.info("afterCreate: crk={}, cr={}", crk, cr);

        AccountKey ak = cr.getAccountKey();

        Set<ChangeRuleKey> l = xrefRegion.get(ak);
        l.add(crk);
        xrefRegion.put(ak, l);
    }

}
