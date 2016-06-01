package io.pivotal.bds.gemfire.fraud.server.loader;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.CacheLoader;
import com.gemstone.gemfire.cache.CacheLoaderException;
import com.gemstone.gemfire.cache.LoaderHelper;

import io.pivotal.bds.gemfire.util.DSLockingHashSet;

public abstract class AbstractXrefCacheLoader<K, V> implements CacheLoader<K, Collection<V>> {

    protected final Logger LOG;

    public AbstractXrefCacheLoader() {
        LOG = LoggerFactory.getLogger(getClass());
    }

    @Override
    public Collection<V> load(LoaderHelper<K, Collection<V>> helper) throws CacheLoaderException {
        K key = helper.getKey();
        LOG.debug("load: key={}", key);

        Boolean init = (Boolean) helper.getArgument();

        if (init == null || !init.booleanValue()) {
            LOG.debug("load: init is false: key={}", key);
            return load(key);
        } else {
            LOG.debug("load: init is true: key={}", key);
            return new DSLockingHashSet<>();
        }
    }

    protected abstract Collection<V> load(K key);

    @Override
    public void close() {
    }

}
