package io.pivotal.bds.gemfire.util;

import java.util.List;
import java.util.Properties;

import org.apache.geode.cache.CacheLoader;
import org.apache.geode.cache.CacheLoaderException;
import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.LoaderHelper;

public class DSLockingArrayListCacheLoader<K, E> implements CacheLoader<K, List<E>>, Declarable {

    @Override
    public List<E> load(LoaderHelper<K, List<E>> helper) throws CacheLoaderException {
        return new DSLockingArrayList<>();
    }

    @Override
    public void init(Properties props) {
    }

    @Override
    public void close() {
    }

}
