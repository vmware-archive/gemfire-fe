package io.pivotal.bds.gemfire.xrefs.server.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.EntryEvent;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.util.CacheListenerAdapter;

import io.pivotal.bds.gemfire.data.securities.AccountKey;
import io.pivotal.bds.gemfire.data.securities.Trade;
import io.pivotal.bds.gemfire.data.securities.TradeKey;
import io.pivotal.bds.gemfire.xrefs.server.data.PDXConcurrentList;

public class TradeAccountXrefCacheListener extends CacheListenerAdapter<TradeKey, Trade> {

    private Region<AccountKey, PDXConcurrentList<TradeKey>> accountTradeXrefRegion;

    private static final Logger LOG = LoggerFactory.getLogger(TradeAccountXrefCacheListener.class);

    public TradeAccountXrefCacheListener(Region<AccountKey, PDXConcurrentList<TradeKey>> accountTradeXrefRegion) {
        this.accountTradeXrefRegion = accountTradeXrefRegion;
    }

    @Override
    public void afterCreate(EntryEvent<TradeKey, Trade> event) {
        TradeKey tk = event.getKey();
        Trade tr = event.getNewValue();
        LOG.info("afterCreate: tk={}, tr={}", tk, tr);

        AccountKey ak = tr.getAccountKey();

        // add xref for account->trade
        PDXConcurrentList<TradeKey> cltr = accountTradeXrefRegion.get(ak);
        cltr.add(tk);
        accountTradeXrefRegion.put(ak, cltr);
    }
}
