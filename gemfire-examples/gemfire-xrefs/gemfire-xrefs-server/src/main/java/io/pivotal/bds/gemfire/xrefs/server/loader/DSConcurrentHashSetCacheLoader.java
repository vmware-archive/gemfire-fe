package io.pivotal.bds.gemfire.xrefs.server.loader;

import java.util.Set;

import com.gemstone.gemfire.cache.CacheLoader;
import com.gemstone.gemfire.cache.CacheLoaderException;
import com.gemstone.gemfire.cache.LoaderHelper;

import io.pivotal.bds.gemfire.util.DSLockingHashSet;

public class DSConcurrentHashSetCacheLoader<K, V> implements CacheLoader<K, Set<V>> {

    @Override
    public void close() {
    }

    @Override
    public Set<V> load(LoaderHelper<K, Set<V>> helper) throws CacheLoaderException {
        return new DSLockingHashSet<>();
    }

}
