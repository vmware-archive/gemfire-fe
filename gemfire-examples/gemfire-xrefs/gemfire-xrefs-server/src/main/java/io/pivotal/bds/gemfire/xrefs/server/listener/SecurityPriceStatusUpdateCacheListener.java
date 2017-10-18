package io.pivotal.bds.gemfire.xrefs.server.listener;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.EntryEvent;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.util.CacheListenerAdapter;

import io.pivotal.bds.gemfire.data.securities.SecurityKey;
import io.pivotal.bds.gemfire.data.securities.SecurityPriceHistory;
import io.pivotal.bds.gemfire.data.securities.SecurityPriceHistoryKey;
import io.pivotal.bds.gemfire.data.securities.SecurityPriceStatus;

public class SecurityPriceStatusUpdateCacheListener extends CacheListenerAdapter<SecurityPriceHistoryKey, SecurityPriceHistory> {

    private Region<SecurityKey, SecurityPriceStatus> priceStatusRegion;

    private static final Logger LOG = LoggerFactory.getLogger(SecurityPriceStatusUpdateCacheListener.class);

    public SecurityPriceStatusUpdateCacheListener(Region<SecurityKey, SecurityPriceStatus> priceStatusRegion) {
        this.priceStatusRegion = priceStatusRegion;
    }

    @Override
    public void afterCreate(EntryEvent<SecurityPriceHistoryKey, SecurityPriceHistory> event) {
        SecurityPriceHistory sph = event.getNewValue();
        SecurityKey sk = sph.getSecurityKey();
        LOG.info("afterCreate: sph={}, sk={}", sph, sk);

        double price = sph.getPrice();

        SecurityPriceStatus sps = priceStatusRegion.get(sk, price);
        SecurityPriceStatus nsps = new SecurityPriceStatus(sk, new Date(), price);
        LOG.info("afterCreate: sps={}, nsps={}, sk={}", sps, nsps, sk);

        priceStatusRegion.put(sk, nsps);
    }

}
