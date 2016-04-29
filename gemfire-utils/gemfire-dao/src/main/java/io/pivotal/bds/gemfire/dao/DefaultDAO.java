package io.pivotal.bds.gemfire.dao;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.execute.RegionFunctionContext;
import com.gemstone.gemfire.cache.query.Query;
import com.gemstone.gemfire.cache.query.QueryService;
import com.gemstone.gemfire.cache.query.SelectResults;

import io.pivotal.bds.gemfire.dao.exception.DuplicateException;
import io.pivotal.bds.gemfire.dao.exception.NotFoundException;

public class DefaultDAO<K, V> implements DAO<K, V> {

    protected Region<K, V> region;
    protected QueryService service;
    protected final Logger log;

    public DefaultDAO(Region<K, V> region) {
        this.log = LoggerFactory.getLogger(getClass());
        this.region = region;
        this.service = region.getRegionService().getQueryService();
    }

    @Override
    public V store(K key, V value) {
        V v = region.putIfAbsent(key, value);

        if (v != null) {
            throw new DuplicateException("Value for key " + key + " is duplicated");
        }

        return null;
    }

    @Override
    public V delete(K key) {
        V v = region.remove(key);

        if (v == null) {
            throw new NotFoundException("Value for key " + key + " not found");
        }

        return v;
    }

    @Override
    public V retrieve(K key) {
        V v = region.get(key);

        if (v == null) {
            throw new NotFoundException("Value for key " + key + " not found");
        }

        return v;
    }

    @Override
    public List<V> query(String field, Object value) {
        return query(field, value, null);
    }

    @Override
    public List<V> query(String field, Object value, RegionFunctionContext regionFunctionContext) {
        log.debug("query: field={}, value={}, regionFunctionContext={}", field, value, regionFunctionContext);
        String q = String.format("select distinct * from %s where %s=$1", region.getFullPath(), field);
        Object[] args = new Object[] { value };
        return doQuery(q, args, regionFunctionContext);
    }

    @SuppressWarnings("unchecked")
    protected List<V> doQuery(String query, Object[] args, RegionFunctionContext regionFunctionContext) {
        if (log.isDebugEnabled()) {
            log.debug("query: query={}, args={}, regionFunctionContext={}", query, Arrays.toString(args), regionFunctionContext);
        }

        try {
            Query q = service.newQuery(query);
            SelectResults<V> res = null;

            if (args == null || args.length == 0) {
                if (regionFunctionContext == null) {
                    res = (SelectResults<V>) q.execute();
                } else {
                    res = (SelectResults<V>) q.execute(regionFunctionContext);
                }
            } else {
                if (regionFunctionContext == null) {
                    res = (SelectResults<V>) q.execute(args);
                } else {
                    res = (SelectResults<V>) q.execute(regionFunctionContext, args);
                }
            }

            List<V> list = res.asList();

            if (log.isTraceEnabled()) {
                log.trace("query: query={}, args={}, list={}", query, Arrays.toString(args), list);
            } else if (log.isDebugEnabled()) {
                log.debug("query: query={}, args={}, list.size()={}", query, Arrays.toString(args), list.size());
            }

            return list;
        } catch (Exception x) {
            log.error(x.toString(), x);
            throw new IllegalArgumentException(x.toString(), x);
        }
    }

    @Override
    public int size() {
        return region.size();
    }

    @Override
    public boolean isEmpty() {
        return region.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return region.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return region.containsValue(value);
    }

    @Override
    public V get(Object key) {
        return region.get(key);
    }

    @Override
    public V put(K key, V value) {
        return region.put(key, value);
    }

    @Override
    public V remove(Object key) {
        return region.remove(key);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        region.putAll(m);
    }

    @Override
    public void clear() {
        region.clear();
    }

    @Override
    public Set<K> keySet() {
        return region.keySet();
    }

    @Override
    public Collection<V> values() {
        return region.values();
    }

    @Override
    public Set<java.util.Map.Entry<K, V>> entrySet() {
        return region.entrySet();
    }

    @Override
    public V putIfAbsent(K key, V value) {
        return region.putIfAbsent(key, value);
    }

    @Override
    public boolean remove(Object key, Object value) {
        return region.remove(key, value);
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        return region.replace(key, oldValue, newValue);
    }

    @Override
    public V replace(K key, V value) {
        return region.replace(key, value);
    }

}
