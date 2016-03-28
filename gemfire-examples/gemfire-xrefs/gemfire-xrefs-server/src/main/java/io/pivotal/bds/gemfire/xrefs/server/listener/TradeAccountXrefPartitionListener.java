package io.pivotal.bds.gemfire.xrefs.server.listener;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.partition.PartitionListener;
import com.gemstone.gemfire.internal.cache.PartitionedRegion;

import io.pivotal.bds.gemfire.data.securities.AccountKey;
import io.pivotal.bds.gemfire.data.securities.Trade;
import io.pivotal.bds.gemfire.data.securities.TradeKey;

public class TradeAccountXrefPartitionListener implements PartitionListener {

    private Region<TradeKey, Trade> tradeRegion;
    private Region<AccountKey, Set<TradeKey>> accountTradeXrefRegion;

    private static final Logger LOG = LoggerFactory.getLogger(TradeAccountXrefPartitionListener.class);

    public TradeAccountXrefPartitionListener(Region<AccountKey, Set<TradeKey>> accountTradeXrefRegion) {
        this.accountTradeXrefRegion = accountTradeXrefRegion;
    }

    @Override
    public void afterBucketCreated(int bucketId, Iterable<?> keys) {
        LOG.info("afterBucketCreated: bucketId={}", bucketId);
    }

    @Override
    public void afterBucketRemoved(int bucketId, Iterable<?> keys) {
        LOG.info("afterBucketRemoved: bucketId={}", bucketId);
        
        for (Object ok: keys) {
            TradeKey tk = (TradeKey) ok;
            Trade tr = tradeRegion.get(tk);
            AccountKey ak = tr.getAccountKey();
            
            Set<TradeKey> l = accountTradeXrefRegion.get(ak);
            l.remove(tk);
            accountTradeXrefRegion.put(ak, l);
        }
    }

    @Override
    public void afterPrimary(int bucketId) {
        LOG.info("afterPrimary: bucketId={}", bucketId);
        
        PartitionedRegion pr = (PartitionedRegion)tradeRegion;
        Set<?> keys = pr.getBucketKeys(bucketId);

        for (Object ok : keys) {
            TradeKey tk = (TradeKey)ok;
            Trade tr = tradeRegion.get(tk);
            AccountKey ak = tr.getAccountKey();
            
            Set<TradeKey> l = accountTradeXrefRegion.get(ak);
            l.add(tk);
            accountTradeXrefRegion.put(ak, l);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void afterRegionCreate(Region<?, ?> region) {
        LOG.info("afterRegionCreate: region={}", region.getName());
        tradeRegion = (Region<TradeKey, Trade>) region;
    }

}
