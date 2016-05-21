package io.pivotal.bds.gemfire.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.AttributesMutator;
import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.CacheLoaderException;
import com.gemstone.gemfire.cache.CacheStatistics;
import com.gemstone.gemfire.cache.CacheWriterException;
import com.gemstone.gemfire.cache.EntryExistsException;
import com.gemstone.gemfire.cache.EntryNotFoundException;
import com.gemstone.gemfire.cache.InterestResultPolicy;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.RegionAttributes;
import com.gemstone.gemfire.cache.RegionExistsException;
import com.gemstone.gemfire.cache.RegionService;
import com.gemstone.gemfire.cache.StatisticsDisabledException;
import com.gemstone.gemfire.cache.TimeoutException;
import com.gemstone.gemfire.cache.execute.RegionFunctionContext;
import com.gemstone.gemfire.cache.query.FunctionDomainException;
import com.gemstone.gemfire.cache.query.NameResolutionException;
import com.gemstone.gemfire.cache.query.Query;
import com.gemstone.gemfire.cache.query.QueryInvocationTargetException;
import com.gemstone.gemfire.cache.query.QueryService;
import com.gemstone.gemfire.cache.query.SelectResults;
import com.gemstone.gemfire.cache.query.TypeMismatchException;
import com.gemstone.gemfire.cache.snapshot.RegionSnapshotService;

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

    @Override
    public void becomeLockGrantor() {
        region.becomeLockGrantor();
    }

    @Override
    public void close() {
        region.close();
    }

    @Override
    public boolean containsKeyOnServer(Object key) {
        return region.containsKeyOnServer(key);
    }

    @Override
    public boolean containsValueForKey(Object key) {
        return region.containsValueForKey(key);
    }

    @Override
    public void create(K key, V value, Object aCallbackArgument)
            throws TimeoutException, EntryExistsException, CacheWriterException {
        region.create(key, value, aCallbackArgument);
    }

    @Override
    public void create(K key, V value) throws TimeoutException, EntryExistsException, CacheWriterException {
        region.create(key, value);
    }

    @SuppressWarnings("deprecation")
    @Override
    public <SK, SV> Region<SK, SV> createSubregion(String subregionName, RegionAttributes<SK, SV> aRegionAttributes)
            throws RegionExistsException, TimeoutException {
        return region.createSubregion(subregionName, aRegionAttributes);
    }

    @Override
    public V destroy(Object key, Object aCallbackArgument) throws TimeoutException, EntryNotFoundException, CacheWriterException {
        return region.destroy(key, aCallbackArgument);
    }

    @Override
    public V destroy(Object key) throws TimeoutException, EntryNotFoundException, CacheWriterException {
        return region.destroy(key);
    }

    @Override
    public void destroyRegion() throws CacheWriterException, TimeoutException {
        region.destroyRegion();
    }

    @Override
    public void destroyRegion(Object aCallbackArgument) throws CacheWriterException, TimeoutException {
        region.destroyRegion(aCallbackArgument);
    }

    @SuppressWarnings("deprecation")
    @Override
    public Set<com.gemstone.gemfire.cache.Region.Entry<?, ?>> entries(boolean recursive) {
        return region.entries(recursive);
    }

    @Override
    public Set<com.gemstone.gemfire.cache.Region.Entry<?, ?>> entrySet(boolean recursive) {
        return region.entrySet(recursive);
    }

    @Override
    public boolean existsValue(String queryPredicate)
            throws FunctionDomainException, TypeMismatchException, NameResolutionException, QueryInvocationTargetException {
        return region.existsValue(queryPredicate);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void forceRolling() {
        region.forceRolling();
    }

    @Override
    public V get(Object key, Object aCallbackArgument) throws TimeoutException, CacheLoaderException {
        return region.get(key, aCallbackArgument);
    }

    @Override
    public Map<K, V> getAll(Collection<?> keys) {
        return region.getAll(keys);
    }

    @Override
    public <T extends K> Map<T, V> getAll(Collection<T> keys, Object aCallbackArgument) {
        return region.getAll(keys, aCallbackArgument);
    }

    @Override
    public RegionAttributes<K, V> getAttributes() {
        return region.getAttributes();
    }

    @Override
    public AttributesMutator<K, V> getAttributesMutator() {
        return region.getAttributesMutator();
    }

    @SuppressWarnings("deprecation")
    @Override
    public Cache getCache() {
        return region.getCache();
    }

    @Override
    public Lock getDistributedLock(Object key) throws IllegalStateException {
        return region.getDistributedLock(key);
    }

    @Override
    public com.gemstone.gemfire.cache.Region.Entry<K, V> getEntry(Object key) {
        return region.getEntry(key);
    }

    @Override
    public String getFullPath() {
        return region.getFullPath();
    }

    @Override
    public List<K> getInterestList() {
        return region.getInterestList();
    }

    @Override
    public List<String> getInterestListRegex() {
        return region.getInterestListRegex();
    }

    @Override
    public String getName() {
        return region.getName();
    }

    @Override
    public <PK, PV> Region<PK, PV> getParentRegion() {
        return region.getParentRegion();
    }

    @Override
    public Lock getRegionDistributedLock() throws IllegalStateException {
        return region.getRegionDistributedLock();
    }

    @Override
    public RegionService getRegionService() {
        return region.getRegionService();
    }

    @Override
    public RegionSnapshotService<K, V> getSnapshotService() {
        return region.getSnapshotService();
    }

    @Override
    public CacheStatistics getStatistics() throws StatisticsDisabledException {
        return region.getStatistics();
    }

    @Override
    public <SK, SV> Region<SK, SV> getSubregion(String path) {
        return region.getSubregion(path);
    }

    @Override
    public Object getUserAttribute() {
        return region.getUserAttribute();
    }

    @Override
    public void invalidate(Object key, Object aCallbackArgument) throws TimeoutException, EntryNotFoundException {
        region.invalidate(key, aCallbackArgument);
    }

    @Override
    public void invalidate(Object key) throws TimeoutException, EntryNotFoundException {
        region.invalidate(key);
    }

    @Override
    public void invalidateRegion() throws TimeoutException {
        region.invalidateRegion();
    }

    @Override
    public void invalidateRegion(Object aCallbackArgument) throws TimeoutException {
        region.invalidateRegion(aCallbackArgument);
    }

    @Override
    public boolean isDestroyed() {
        return region.isDestroyed();
    }

    @Override
    public Set<K> keySetOnServer() {
        return region.keySetOnServer();
    }

    @SuppressWarnings("deprecation")
    @Override
    public Set<K> keys() {
        return region.keys();
    }

    @SuppressWarnings("deprecation")
    @Override
    public void loadSnapshot(InputStream inputStream)
            throws IOException, ClassNotFoundException, CacheWriterException, TimeoutException {
        region.loadSnapshot(inputStream);
    }

    @Override
    public void localClear() {
        region.localClear();
    }

    @Override
    public void localDestroy(Object key, Object aCallbackArgument) throws EntryNotFoundException {
        region.localDestroy(key, aCallbackArgument);
    }

    @Override
    public void localDestroy(Object key) throws EntryNotFoundException {
        region.localDestroy(key);
    }

    @Override
    public void localDestroyRegion() {
        region.localDestroyRegion();
    }

    @Override
    public void localDestroyRegion(Object aCallbackArgument) {
        region.localDestroyRegion(aCallbackArgument);
    }

    @Override
    public void localInvalidate(Object key, Object aCallbackArgument) throws EntryNotFoundException {
        region.localInvalidate(key, aCallbackArgument);
    }

    @Override
    public void localInvalidate(Object key) throws EntryNotFoundException {
        region.localInvalidate(key);
    }

    @Override
    public void localInvalidateRegion() {
        region.localInvalidateRegion();
    }

    @Override
    public void localInvalidateRegion(Object aCallbackArgument) {
        region.localInvalidateRegion(aCallbackArgument);
    }

    @Override
    public V put(K key, V value, Object aCallbackArgument) throws TimeoutException, CacheWriterException {
        return region.put(key, value, aCallbackArgument);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map, Object aCallbackArgument) {
        region.putAll(map, aCallbackArgument);
    }

    @Override
    public <E> SelectResults<E> query(String queryPredicate)
            throws FunctionDomainException, TypeMismatchException, NameResolutionException, QueryInvocationTargetException {
        return region.query(queryPredicate);
    }

    @Override
    public void registerInterest(K key, boolean isDurable, boolean receiveValues) {
        region.registerInterest(key, isDurable, receiveValues);
    }

    @Override
    public void registerInterest(K key, boolean isDurable) {
        region.registerInterest(key, isDurable);
    }

    @Override
    public void registerInterest(K key, InterestResultPolicy policy, boolean isDurable, boolean receiveValues) {
        region.registerInterest(key, policy, isDurable, receiveValues);
    }

    @Override
    public void registerInterest(K key, InterestResultPolicy policy, boolean isDurable) {
        region.registerInterest(key, policy, isDurable);
    }

    @Override
    public void registerInterest(K key, InterestResultPolicy policy) {
        region.registerInterest(key, policy);
    }

    @Override
    public void registerInterest(K key) {
        region.registerInterest(key);
    }

    @Override
    public void registerInterestRegex(String regex, boolean isDurable, boolean receiveValues) {
        region.registerInterestRegex(regex, isDurable, receiveValues);
    }

    @Override
    public void registerInterestRegex(String regex, boolean isDurable) {
        region.registerInterestRegex(regex, isDurable);
    }

    @Override
    public void registerInterestRegex(String regex, InterestResultPolicy policy, boolean isDurable, boolean receiveValues) {
        region.registerInterestRegex(regex, policy, isDurable, receiveValues);
    }

    @Override
    public void registerInterestRegex(String regex, InterestResultPolicy policy, boolean isDurable) {
        region.registerInterestRegex(regex, policy, isDurable);
    }

    @Override
    public void registerInterestRegex(String regex, InterestResultPolicy policy) {
        region.registerInterestRegex(regex, policy);
    }

    @Override
    public void registerInterestRegex(String regex) {
        region.registerInterestRegex(regex);
    }

    @Override
    public void removeAll(Collection<? extends K> keys, Object aCallbackArgument) {
        region.removeAll(keys, aCallbackArgument);
    }

    @Override
    public void removeAll(Collection<? extends K> keys) {
        region.removeAll(keys);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void saveSnapshot(OutputStream outputStream) throws IOException {
        region.saveSnapshot(outputStream);
    }

    @Override
    public Object selectValue(String queryPredicate)
            throws FunctionDomainException, TypeMismatchException, NameResolutionException, QueryInvocationTargetException {
        return region.selectValue(queryPredicate);
    }

    @Override
    public void setUserAttribute(Object value) {
        region.setUserAttribute(value);
    }

    @Override
    public Set<Region<?, ?>> subregions(boolean recursive) {
        return region.subregions(recursive);
    }

    @Override
    public void unregisterInterest(K key) {
        region.unregisterInterest(key);
    }

    @Override
    public void unregisterInterestRegex(String regex) {
        region.unregisterInterestRegex(regex);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void writeToDisk() {
        region.writeToDisk();
    }

}
