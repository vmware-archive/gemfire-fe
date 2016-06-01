package io.pivotal.bds.gemfire.fraud.server.loader;

import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.Mapper;

public abstract class AbstractCassandraXrefCacheLoader<K, V, T> extends AbstractXrefCacheLoader<K, V> {

    protected Mapper<T> mapper;
    protected Session session;

    public AbstractCassandraXrefCacheLoader(Mapper<T> mapper) {
        this.mapper = mapper;
        this.session = mapper.getManager().getSession();
    }

}
