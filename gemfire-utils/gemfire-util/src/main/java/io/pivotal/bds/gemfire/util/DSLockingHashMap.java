package io.pivotal.bds.gemfire.util;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class DSLockingHashMap<K, V> extends DSHashMap<K, V> {

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private Lock readLock = lock.readLock();
    private Lock writeLock = lock.writeLock();

    private static final long serialVersionUID = 1L;

    public DSLockingHashMap() {
    }

    public DSLockingHashMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    public DSLockingHashMap(int initialCapacity) {
        super(initialCapacity);
    }

    public DSLockingHashMap(Map<? extends K, ? extends V> m) {
        super(m);
    }

    @Override
    public void fromData(DataInput in) throws IOException, ClassNotFoundException {
        writeLock.lock();
        try {
            super.fromData(in);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public void toData(DataOutput out) throws IOException {
        writeLock.lock();
        try {
            super.toData(out);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public int size() {
        readLock.lock();
        try {
            return super.size();
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public boolean isEmpty() {
        readLock.lock();
        try {
            return super.isEmpty();
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public V get(Object key) {
        readLock.lock();
        try {
            return super.get(key);
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public boolean containsKey(Object key) {
        readLock.lock();
        try {
            return super.containsKey(key);
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public V put(K key, V value) {
        writeLock.lock();
        try {
            return super.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        writeLock.lock();
        try {
            super.putAll(m);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public V remove(Object key) {
        writeLock.lock();
        try {
            return super.remove(key);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public void clear() {
        writeLock.lock();
        try {
            super.clear();
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public boolean containsValue(Object value) {
        readLock.lock();
        try {
            return super.containsValue(value);
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public Set<K> keySet() {
        return super.keySet(); // TODO
    }

    @Override
    public Collection<V> values() {
        return super.values(); // TODO
    }

    @Override
    public Set<java.util.Map.Entry<K, V>> entrySet() {
        return super.entrySet(); // TODO
    }

    @Override
    public V getOrDefault(Object key, V defaultValue) {
        readLock.lock();
        try {
            return super.getOrDefault(key, defaultValue);
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public V putIfAbsent(K key, V value) {
        writeLock.lock();
        try {
            return super.putIfAbsent(key, value);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public boolean remove(Object key, Object value) {
        writeLock.lock();
        try {
            return super.remove(key, value);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        writeLock.lock();
        try {
            return super.replace(key, oldValue, newValue);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public V replace(K key, V value) {
        writeLock.lock();
        try {
            return super.replace(key, value);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        return super.computeIfAbsent(key, mappingFunction); // TODO
    }

    @Override
    public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return super.computeIfPresent(key, remappingFunction); // TODO
    }

    @Override
    public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return super.compute(key, remappingFunction); // TODO
    }

    @Override
    public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        return super.merge(key, value, remappingFunction); // TODO
    }

    @Override
    public void forEach(BiConsumer<? super K, ? super V> action) {
        writeLock.lock();
        try {
            super.forEach(action);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
        writeLock.lock();
        try {
            super.replaceAll(function);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public Object clone() {
        readLock.lock();
        try {
            return super.clone();
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public boolean equals(Object o) {
        readLock.lock();
        try {
            return super.equals(o);
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public int hashCode() {
        readLock.lock();
        try {
            return super.hashCode();
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public String toString() {
        readLock.lock();
        try {
            return super.toString();
        } finally {
            readLock.unlock();
        }
    }
}
