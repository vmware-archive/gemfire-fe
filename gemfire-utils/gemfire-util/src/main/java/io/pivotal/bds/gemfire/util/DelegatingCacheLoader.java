package io.pivotal.bds.gemfire.util;

import java.util.Properties;

import org.springframework.util.Assert;

import com.gemstone.gemfire.cache.CacheLoader;
import com.gemstone.gemfire.cache.CacheLoaderException;
import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.LoaderHelper;

public class DelegatingCacheLoader<K, V> implements CacheLoader<K, V>, Declarable {

    private CacheLoader<K, V> delegate;

    public CacheLoader<K, V> getDelegate() {
        return delegate;
    }

    public void setDelegate(CacheLoader<K, V> delegate) {
        Assert.isNull(delegate);
        this.delegate = delegate;
    }

    @Override
    public void close() {
    }

    @Override
    public void init(Properties props) {
    }

    @Override
    public V load(LoaderHelper<K, V> helper) throws CacheLoaderException {
        return delegate.load(helper);
    }

}
