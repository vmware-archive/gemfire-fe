package io.pivotal.bds.gemfire.r.server.loader;

import java.util.Properties;

import org.springframework.util.Assert;

import org.apache.geode.cache.CacheLoader;
import org.apache.geode.cache.CacheLoaderException;
import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.LoaderHelper;

import io.pivotal.bds.gemfire.r.common.Window;
import io.pivotal.bds.gemfire.r.common.WindowKey;

public class WindowCacheLoader<K, V> implements CacheLoader<WindowKey<K>, Window<V>>, Declarable {

    @Override
    public Window<V> load(LoaderHelper<WindowKey<K>, Window<V>> helper) throws CacheLoaderException {
        Integer size = (Integer) helper.getArgument();
        Assert.notNull(size, "Missing size in WindowCacheLoader");
        return new Window<V>(size);
    }

    @Override
    public void init(Properties props) {
    }

    @Override
    public void close() {
    }

}
