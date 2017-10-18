package io.pivotal.bds.gemfire.mock;

import org.apache.geode.cache.*;
import org.apache.geode.cache.query.*;
import org.apache.geode.cache.snapshot.RegionSnapshotService;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;
import java.util.concurrent.locks.Lock;

@SuppressWarnings("serial")
public class MockRegion<K, V> extends HashMap<K, V> implements Region<K, V> {

    private String name;
    private CacheLoader<K, V> loader;

    public MockRegion(String name) {
        this.name = name;
    }

    public CacheLoader<K, V> getLoader() {
        return loader;
    }

    @Override
    public V get(Object key) {
        return get(key,null);
    }

    @Override
    public V get(Object key, Object callback) throws TimeoutException, CacheLoaderException {
        V v = super.get(key);

        if (v == null && loader != null) {
            v = loader.load(new LoaderHelper<K, V>() {
                @Override
                public V netSearch(boolean b) throws CacheLoaderException, TimeoutException {
                    return null;
                }

                @Override
                public K getKey() {
                    return (K)key;
                }

                @Override
                public Region<K, V> getRegion() {
                    return MockRegion.this;
                }

                @Override
                public Object getArgument() {
                    return callback;
                }
            });

            if (v != null) {
                put((K)key,v);
            }
        }

        return v;
    }

    public void setLoader(CacheLoader<K, V> loader) {
        this.loader = loader;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getFullPath() {
        return "/" + name;
    }

    @Override
    public <PK, PV> Region<PK, PV> getParentRegion() {
        throw new UnsupportedOperationException();
    }

    @Override
    public RegionAttributes<K, V> getAttributes() {
        throw new UnsupportedOperationException();
    }

    @Override
    public AttributesMutator<K, V> getAttributesMutator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public CacheStatistics getStatistics() throws StatisticsDisabledException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void invalidateRegion() throws TimeoutException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void invalidateRegion(Object o) throws TimeoutException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void localInvalidateRegion() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void localInvalidateRegion(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void destroyRegion() throws CacheWriterException, TimeoutException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void destroyRegion(Object o) throws CacheWriterException, TimeoutException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void localDestroyRegion() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void localDestroyRegion(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void close() {
    }

    @Override
    public RegionSnapshotService<K, V> getSnapshotService() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void saveSnapshot(OutputStream outputStream) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadSnapshot(InputStream inputStream) throws IOException, ClassNotFoundException, CacheWriterException, TimeoutException {
        throw new UnsupportedOperationException();
    }

    @Override
    public <SK, SV> Region<SK, SV> getSubregion(String s) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <SK, SV> Region<SK, SV> createSubregion(String s, RegionAttributes<SK, SV> regionAttributes) throws RegionExistsException, TimeoutException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<Region<?, ?>> subregions(boolean b) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Region.Entry<K, V> getEntry(Object o) {
        final Map.Entry<K, V> e = getEntry(o);

        return new Region.Entry<K, V>() {
            @Override
            public K getKey() {
                return e.getKey();
            }

            @Override
            public V getValue() {
                return e.getValue();
            }

            @Override
            public Region<K, V> getRegion() {
                return MockRegion.this;
            }

            @Override
            public boolean isLocal() {
                return false;
            }

            @Override
            public CacheStatistics getStatistics() {
                return null;
            }

            @Override
            public Object getUserAttribute() {
                return null;
            }

            @Override
            public Object setUserAttribute(Object o) {
                return null;
            }

            @Override
            public boolean isDestroyed() {
                return false;
            }

            @Override
            public V setValue(V v) {
                return MockRegion.this.put(e.getKey(), v);
            }
        };
    }

    @Override
    public V put(K k, V v, Object o) throws TimeoutException, CacheWriterException {
        return put(k, v);
    }

    @Override
    public void create(K k, V v) throws TimeoutException, EntryExistsException, CacheWriterException {
        putIfAbsent(k, v);
    }

    @Override
    public void create(K k, V v, Object o) throws TimeoutException, EntryExistsException, CacheWriterException {
        create(k,v);
    }

    @Override
    public void invalidate(Object o) throws TimeoutException, EntryNotFoundException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void invalidate(Object o, Object o1) throws TimeoutException, EntryNotFoundException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void localInvalidate(Object o) throws EntryNotFoundException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void localInvalidate(Object o, Object o1) throws EntryNotFoundException {
        throw new UnsupportedOperationException();
    }

    @Override
    public V destroy(Object o) throws TimeoutException, EntryNotFoundException, CacheWriterException {
        return remove(o);
    }

    @Override
    public V destroy(Object o, Object o1) throws TimeoutException, EntryNotFoundException, CacheWriterException {
        return destroy(o);
    }

    @Override
    public void localDestroy(Object o) throws EntryNotFoundException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void localDestroy(Object o, Object o1) throws EntryNotFoundException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<Region.Entry<?, ?>> entrySet(boolean b) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Cache getCache() {
        throw new UnsupportedOperationException();
    }

    @Override
    public RegionService getRegionService() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object getUserAttribute() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setUserAttribute(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isDestroyed() {
        return false;
    }

    @Override
    public boolean containsValueForKey(Object o) {
        return containsKey(o);
    }

    @Override
    public Lock getRegionDistributedLock() throws IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Lock getDistributedLock(Object o) throws IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void writeToDisk() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean existsValue(String s) throws FunctionDomainException, TypeMismatchException, NameResolutionException, QueryInvocationTargetException {
        throw new UnsupportedOperationException();
    }

    @Override
    public <E> SelectResults<E> query(String s) throws FunctionDomainException, TypeMismatchException, NameResolutionException, QueryInvocationTargetException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object selectValue(String s) throws FunctionDomainException, TypeMismatchException, NameResolutionException, QueryInvocationTargetException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void forceRolling() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void becomeLockGrantor() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void localClear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map, Object o) {
        super.putAll(map);
    }

    @Override
    public void removeAll(Collection<? extends K> collection) {
        for (K k : collection) {
            remove(k);
        }
    }

    @Override
    public void removeAll(Collection<? extends K> collection, Object o) {
        this.removeAll(collection);
    }

    @Override
    public Map<K, V> getAll(Collection<?> collection) {
        HashMap<K, V> map = new HashMap<>();
        for (K k: keySet()) {
            V v = get(k);
            map.put(k,v);
        }
        return map;
    }

    @Override
    public <T extends K> Map<T, V> getAll(Collection<T> collection, Object o) {
        HashMap<T, V> map = new HashMap<>();
        for (K k: keySet()) {
            V v = get(k, o);
            map.put((T)k,v);
        }
        return map;
    }

    @Override
    public void registerInterest(K k) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void registerInterest(K k, InterestResultPolicy interestResultPolicy) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void registerInterestRegex(String s) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void registerInterestRegex(String s, InterestResultPolicy interestResultPolicy) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void unregisterInterest(K k) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void unregisterInterestRegex(String s) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<K> getInterestList() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void registerInterest(K k, boolean b) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void registerInterest(K k, boolean b, boolean b1) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void registerInterest(K k, InterestResultPolicy interestResultPolicy, boolean b, boolean b1) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void registerInterest(K k, InterestResultPolicy interestResultPolicy, boolean b) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void registerInterestRegex(String s, boolean b) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void registerInterestRegex(String s, boolean b, boolean b1) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void registerInterestRegex(String s, InterestResultPolicy interestResultPolicy, boolean b) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void registerInterestRegex(String s, InterestResultPolicy interestResultPolicy, boolean b, boolean b1) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> getInterestListRegex() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<K> keySetOnServer() {
        return keySet();
    }

    @Override
    public boolean containsKeyOnServer(Object o) {
        return containsKey(o);
    }

    @Override
    public boolean isEmptyOnServer() {
        return isEmpty();
    }

    @Override
    public int sizeOnServer() {
        return size();
    }
}
