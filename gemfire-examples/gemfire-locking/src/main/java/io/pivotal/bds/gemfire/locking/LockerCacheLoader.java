package io.pivotal.bds.gemfire.locking;

import com.gemstone.gemfire.cache.CacheLoader;
import com.gemstone.gemfire.cache.CacheLoaderException;
import com.gemstone.gemfire.cache.LoaderHelper;

public class LockerCacheLoader<K> implements CacheLoader<LockerKey<K>, Locker> {

    @Override
    public void close() {
    }

    @Override
    public Locker load(LoaderHelper<LockerKey<K>, Locker> helper) throws CacheLoaderException {
        return new Locker();
    }

}
