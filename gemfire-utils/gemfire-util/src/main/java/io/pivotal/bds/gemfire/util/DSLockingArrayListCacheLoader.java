package io.pivotal.bds.gemfire.util;

import java.util.List;
import java.util.Properties;

import com.gemstone.gemfire.cache.CacheLoader;
import com.gemstone.gemfire.cache.CacheLoaderException;
import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.LoaderHelper;

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
