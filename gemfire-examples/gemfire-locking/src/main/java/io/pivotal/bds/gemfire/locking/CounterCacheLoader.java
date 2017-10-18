package io.pivotal.bds.gemfire.locking;

import org.apache.geode.cache.CacheLoader;
import org.apache.geode.cache.CacheLoaderException;
import org.apache.geode.cache.LoaderHelper;

public class CounterCacheLoader implements CacheLoader<String, Integer> {

    @Override
    public void close() {
    }

    @Override
    public Integer load(LoaderHelper<String, Integer> helper) throws CacheLoaderException {
        return new Integer(0);
    }
}
