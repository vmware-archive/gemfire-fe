package io.pivotal.bds.gemfire.util;

import java.util.Properties;
import java.util.Set;

import com.gemstone.gemfire.cache.CacheLoader;
import com.gemstone.gemfire.cache.CacheLoaderException;
import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.LoaderHelper;

public class DSLockingLinkedHashSetCacheLoader<K, E> implements CacheLoader<K, Set<E>>, Declarable {

    @Override
    public Set<E> load(LoaderHelper<K, Set<E>> helper) throws CacheLoaderException {
        return new DSLockingLinkedHashSet<>();
    }

    @Override
    public void init(Properties props) {
    }

    @Override
    public void close() {
    }

}
