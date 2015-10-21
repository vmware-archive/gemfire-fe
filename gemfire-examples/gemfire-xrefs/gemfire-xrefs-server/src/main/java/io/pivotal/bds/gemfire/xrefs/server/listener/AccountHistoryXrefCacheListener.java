package io.pivotal.bds.gemfire.xrefs.server.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.EntryEvent;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.util.CacheListenerAdapter;

import io.pivotal.bds.gemfire.data.securities.AccountHistory;
import io.pivotal.bds.gemfire.data.securities.AccountHistoryKey;
import io.pivotal.bds.gemfire.data.securities.AccountKey;
import io.pivotal.bds.gemfire.xrefs.server.data.PDXConcurrentList;

public class AccountHistoryXrefCacheListener extends CacheListenerAdapter<AccountHistoryKey, AccountHistory> {

    private Region<AccountKey, PDXConcurrentList<AccountHistoryKey>> accountHistoryXrefRegion;

    private static final Logger LOG = LoggerFactory.getLogger(AccountHistoryXrefCacheListener.class);

    public AccountHistoryXrefCacheListener(Region<AccountKey, PDXConcurrentList<AccountHistoryKey>> accountHistoryXrefRegion) {
        this.accountHistoryXrefRegion = accountHistoryXrefRegion;
    }

    @Override
    public void afterCreate(EntryEvent<AccountHistoryKey, AccountHistory> event) {
        AccountHistoryKey ahk = event.getKey();
        AccountHistory ah = event.getNewValue();
        LOG.info("afterCreate: ahk={}, ah={}", ahk, ah);

        AccountKey ak = ah.getAccountKey();

        // add xref for account->account history
        PDXConcurrentList<AccountHistoryKey> clah = accountHistoryXrefRegion.get(ak);
        clah.add(ahk);
        accountHistoryXrefRegion.put(ak, clah);
    }

}
