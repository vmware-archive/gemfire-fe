package io.pivotal.bds.gemfire.util;

import org.apache.geode.cache.CacheWriter;

public abstract class DelegateCacheWriter<K, V> implements CacheWriter<K, V> {

    public DelegateCacheWriter(DelegatingCacheWriter<K, V> cl) {
        cl.addDelegate(this);
    }

}
