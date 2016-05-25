package io.pivotal.bds.gemfire.util;

import com.gemstone.gemfire.cache.CacheWriter;

public abstract class DelegateCacheWriter<K, V> implements CacheWriter<K, V> {

    public DelegateCacheWriter(DelegatingCacheWriter<K, V> cl) {
        cl.addDelegate(this);
    }

}
