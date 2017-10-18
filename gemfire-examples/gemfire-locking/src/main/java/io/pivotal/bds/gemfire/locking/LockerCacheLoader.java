package io.pivotal.bds.gemfire.locking;

import org.apache.geode.cache.CacheLoader;
import org.apache.geode.cache.CacheLoaderException;
import org.apache.geode.cache.LoaderHelper;

public class LockerCacheLoader<K> implements CacheLoader<LockerKey<K>, Locker> {

    @Override
    public void close() {
    }

    @Override
    public Locker load(LoaderHelper<LockerKey<K>, Locker> helper) throws CacheLoaderException {
        return new Locker();
    }

}
