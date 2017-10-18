package io.pivotal.bds.gemfire.util;

import org.apache.geode.cache.CacheLoader;

public abstract class DelegateCacheLoader<K, V> implements CacheLoader<K, V> {

    public DelegateCacheLoader(DelegatingCacheLoader<K, V> cl) {
        cl.setDelegate(this);
    }

}
