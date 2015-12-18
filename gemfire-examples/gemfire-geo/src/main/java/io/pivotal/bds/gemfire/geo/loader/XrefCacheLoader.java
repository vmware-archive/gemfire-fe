package io.pivotal.bds.gemfire.geo.loader;

import java.util.Collection;
import java.util.Properties;

import com.gemstone.gemfire.cache.CacheLoader;
import com.gemstone.gemfire.cache.CacheLoaderException;
import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.LoaderHelper;

import io.pivotal.bds.gemfire.util.DSArrayList;

public class XrefCacheLoader<K, V> implements CacheLoader<K, Collection<V>>, Declarable {

    @Override
    public void close() {
    }

    @Override
    public void init(Properties props) {
    }

    @Override
    public Collection<V> load(LoaderHelper<K, Collection<V>> helper) throws CacheLoaderException {
        return new DSArrayList<>();
    }

}
