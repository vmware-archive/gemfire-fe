package io.pivotal.bds.gemfire.locking;

import com.gemstone.gemfire.cache.CacheLoader;
import com.gemstone.gemfire.cache.CacheLoaderException;
import com.gemstone.gemfire.cache.LoaderHelper;

public class CounterCacheLoader implements CacheLoader<String, Integer> {

    @Override
    public void close() {
    }

    @Override
    public Integer load(LoaderHelper<String, Integer> helper) throws CacheLoaderException {
        return new Integer(0);
    }
}
