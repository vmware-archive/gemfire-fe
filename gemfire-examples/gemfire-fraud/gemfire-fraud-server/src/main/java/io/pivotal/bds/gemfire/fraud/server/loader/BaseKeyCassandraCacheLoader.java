package io.pivotal.bds.gemfire.fraud.server.loader;

import com.datastax.driver.mapping.Mapper;

import io.pivotal.bds.gemfire.key.BaseKey;

public class BaseKeyCassandraCacheLoader<K extends BaseKey<?>, V> extends AbstractCassandraCacheLoader<K, V> {

    public BaseKeyCassandraCacheLoader(Mapper<V> mapper) {
        super(mapper);
    }

    @Override
    protected V get(K key) {
        Object id = key.getId();
        LOG.debug("get: id={}", id);
        return mapper.get(id);
    }

}
