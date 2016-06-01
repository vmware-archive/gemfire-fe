package io.pivotal.bds.gemfire.fraud.server.loader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.driver.mapping.Mapper;
import com.gemstone.gemfire.cache.CacheLoader;
import com.gemstone.gemfire.cache.CacheLoaderException;
import com.gemstone.gemfire.cache.LoaderHelper;

public abstract class AbstractCassandraCacheLoader<K, V> implements CacheLoader<K, V> {

    protected Mapper<V> mapper;
    protected final Logger LOG;

    public AbstractCassandraCacheLoader(Mapper<V> mapper) {
        LOG = LoggerFactory.getLogger(getClass());
        this.mapper = mapper;
    }

    @Override
    public void close() {
    }

    @Override
    public V load(LoaderHelper<K, V> helper) throws CacheLoaderException {
        K key = helper.getKey();
        LOG.debug("load: key={}", key);
        V value = get(key);
        LOG.debug("load: key={}, value={}", key, value);
        return value;
    }

    protected abstract V get(K key);
}
