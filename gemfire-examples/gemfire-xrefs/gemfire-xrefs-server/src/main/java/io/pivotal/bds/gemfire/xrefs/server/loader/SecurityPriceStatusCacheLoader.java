package io.pivotal.bds.gemfire.xrefs.server.loader;

import java.util.Date;

import org.apache.geode.cache.CacheLoader;
import org.apache.geode.cache.CacheLoaderException;
import org.apache.geode.cache.LoaderHelper;

import io.pivotal.bds.gemfire.data.securities.SecurityKey;
import io.pivotal.bds.gemfire.data.securities.SecurityPriceStatus;

public class SecurityPriceStatusCacheLoader implements CacheLoader<SecurityKey, SecurityPriceStatus> {

    @Override
    public void close() {
    }

    @Override
    public SecurityPriceStatus load(LoaderHelper<SecurityKey, SecurityPriceStatus> helper) throws CacheLoaderException {
        SecurityKey key = helper.getKey();
        Date now = new Date();
        double price = (double) helper.getArgument();
        return new SecurityPriceStatus(key, now, price);
    }

}
