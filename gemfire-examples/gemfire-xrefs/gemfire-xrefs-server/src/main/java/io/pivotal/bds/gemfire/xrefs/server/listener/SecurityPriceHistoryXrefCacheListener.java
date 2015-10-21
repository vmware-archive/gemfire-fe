package io.pivotal.bds.gemfire.xrefs.server.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.EntryEvent;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.util.CacheListenerAdapter;

import io.pivotal.bds.gemfire.data.securities.SecurityKey;
import io.pivotal.bds.gemfire.data.securities.SecurityPriceHistory;
import io.pivotal.bds.gemfire.data.securities.SecurityPriceHistoryKey;
import io.pivotal.bds.gemfire.xrefs.server.data.PDXConcurrentList;

public class SecurityPriceHistoryXrefCacheListener extends CacheListenerAdapter<SecurityPriceHistoryKey, SecurityPriceHistory> {

    private Region<SecurityKey, PDXConcurrentList<SecurityPriceHistoryKey>> securityPriceXrefRegion;

    private static final Logger LOG = LoggerFactory.getLogger(SecurityPriceHistoryXrefCacheListener.class);

    public SecurityPriceHistoryXrefCacheListener(
            Region<SecurityKey, PDXConcurrentList<SecurityPriceHistoryKey>> securityPriceXrefRegion) {
        this.securityPriceXrefRegion = securityPriceXrefRegion;
    }

    @Override
    public void afterCreate(EntryEvent<SecurityPriceHistoryKey, SecurityPriceHistory> event) {
        SecurityPriceHistoryKey sphk = event.getKey();
        SecurityPriceHistory sph = event.getNewValue();
        LOG.info("afterCreate: sphk={}, sph={}", sphk, sph);

        SecurityKey sk = sph.getSecurityKey();

        // add xref for security->price history
        PDXConcurrentList<SecurityPriceHistoryKey> cls = securityPriceXrefRegion.get(sk);
        cls.add(sphk);
        securityPriceXrefRegion.put(sk, cls);
    }

}
