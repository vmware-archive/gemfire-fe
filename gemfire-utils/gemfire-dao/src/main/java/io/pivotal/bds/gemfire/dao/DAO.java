package io.pivotal.bds.gemfire.dao;

import java.util.List;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.execute.RegionFunctionContext;

public interface DAO<K, V> extends Region<K, V> {

    V store(K k, V v);

    V delete(K k);

    V retrieve(K k);

    List<V> query(String field, Object value);

    List<V> query(String field, Object value, RegionFunctionContext regionFunctionContext);
}
