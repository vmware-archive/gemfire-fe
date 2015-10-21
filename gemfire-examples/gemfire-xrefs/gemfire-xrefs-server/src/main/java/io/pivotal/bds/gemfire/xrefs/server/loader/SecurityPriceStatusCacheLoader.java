package io.pivotal.bds.gemfire.xrefs.server.loader;

import java.util.Date;

import com.gemstone.gemfire.cache.CacheLoader;
import com.gemstone.gemfire.cache.CacheLoaderException;
import com.gemstone.gemfire.cache.LoaderHelper;

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
