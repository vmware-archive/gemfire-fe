package io.pivotal.bds.gemfire.util;

import com.gemstone.gemfire.cache.CacheListener;

public abstract class DelegateCacheListener<K, V> implements CacheListener<K, V> {

    public DelegateCacheListener(DelegatingCacheListener<K, V> cl) {
        cl.addDelegate(this);
    }

}
