package io.pivotal.bds.gemfire.dao;

import java.util.List;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.execute.RegionFunctionContext;

public interface DAO<K, V> extends Region<K, V> {

    V store(K k, V v);

    V delete(K k);

    V retrieve(K k);

    List<V> query(String field, Object value);

    List<V> query(String field, Object value, RegionFunctionContext regionFunctionContext);
}
