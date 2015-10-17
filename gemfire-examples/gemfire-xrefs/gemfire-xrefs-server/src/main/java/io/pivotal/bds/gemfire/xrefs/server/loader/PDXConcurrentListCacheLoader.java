package io.pivotal.bds.gemfire.xrefs.server.loader;

import com.gemstone.gemfire.cache.CacheLoader;
import com.gemstone.gemfire.cache.CacheLoaderException;
import com.gemstone.gemfire.cache.LoaderHelper;

import io.pivotal.bds.gemfire.xrefs.server.data.PDXConcurrentList;

public class PDXConcurrentListCacheLoader<K, V> implements CacheLoader<K, PDXConcurrentList<V>> {

    @Override
    public void close() {
    }

    @Override
    public PDXConcurrentList<V> load(LoaderHelper<K, PDXConcurrentList<V>> helper) throws CacheLoaderException {
        return new PDXConcurrentList<>();
    }

}
