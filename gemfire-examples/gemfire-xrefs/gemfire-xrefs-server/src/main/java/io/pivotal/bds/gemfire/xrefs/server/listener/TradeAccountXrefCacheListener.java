package io.pivotal.bds.gemfire.xrefs.server.listener;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.EntryEvent;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.util.CacheListenerAdapter;

import io.pivotal.bds.gemfire.data.securities.AccountKey;
import io.pivotal.bds.gemfire.data.securities.Trade;
import io.pivotal.bds.gemfire.data.securities.TradeKey;

public class TradeAccountXrefCacheListener extends CacheListenerAdapter<TradeKey, Trade> {

    private Region<AccountKey, Set<TradeKey>> accountTradeXrefRegion;

    private static final Logger LOG = LoggerFactory.getLogger(TradeAccountXrefCacheListener.class);

    public TradeAccountXrefCacheListener(Region<AccountKey, Set<TradeKey>> accountTradeXrefRegion) {
        this.accountTradeXrefRegion = accountTradeXrefRegion;
    }

    @Override
    public void afterCreate(EntryEvent<TradeKey, Trade> event) {
        TradeKey tk = event.getKey();
        Trade tr = event.getNewValue();
        LOG.info("afterCreate: tk={}, tr={}", tk, tr);

        AccountKey ak = tr.getAccountKey();

        // add xref for account->trade
        Set<TradeKey> cltr = accountTradeXrefRegion.get(ak);
        cltr.add(tk);
        accountTradeXrefRegion.put(ak, cltr);
    }
}
