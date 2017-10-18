package io.pivotal.bds.gemfire.xrefs.server.listener;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.EntryEvent;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.util.CacheListenerAdapter;

import io.pivotal.bds.gemfire.data.securities.SecurityKey;
import io.pivotal.bds.gemfire.data.securities.SecurityPriceHistory;
import io.pivotal.bds.gemfire.data.securities.SecurityPriceHistoryKey;

public class SecurityPriceHistoryXrefCacheListener extends CacheListenerAdapter<SecurityPriceHistoryKey, SecurityPriceHistory> {

    private Region<SecurityKey, Set<SecurityPriceHistoryKey>> securityPriceXrefRegion;

    private static final Logger LOG = LoggerFactory.getLogger(SecurityPriceHistoryXrefCacheListener.class);

    public SecurityPriceHistoryXrefCacheListener(
            Region<SecurityKey, Set<SecurityPriceHistoryKey>> securityPriceXrefRegion) {
        this.securityPriceXrefRegion = securityPriceXrefRegion;
    }

    @Override
    public void afterCreate(EntryEvent<SecurityPriceHistoryKey, SecurityPriceHistory> event) {
        SecurityPriceHistoryKey sphk = event.getKey();
        SecurityPriceHistory sph = event.getNewValue();
        LOG.info("afterCreate: sphk={}, sph={}", sphk, sph);

        SecurityKey sk = sph.getSecurityKey();

        // add xref for security->price history
        Set<SecurityPriceHistoryKey> cls = securityPriceXrefRegion.get(sk);
        cls.add(sphk);
        securityPriceXrefRegion.put(sk, cls);
    }

}
