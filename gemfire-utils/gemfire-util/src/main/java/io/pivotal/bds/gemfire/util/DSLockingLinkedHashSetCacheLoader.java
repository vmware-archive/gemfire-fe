package io.pivotal.bds.gemfire.util;

import java.util.Properties;
import java.util.Set;

import org.apache.geode.cache.CacheLoader;
import org.apache.geode.cache.CacheLoaderException;
import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.LoaderHelper;

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
