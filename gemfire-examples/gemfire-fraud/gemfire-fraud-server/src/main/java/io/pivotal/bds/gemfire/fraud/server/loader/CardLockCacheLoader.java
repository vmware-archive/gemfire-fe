package io.pivotal.bds.gemfire.fraud.server.loader;

import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.geode.cache.CacheLoader;
import org.apache.geode.cache.CacheLoaderException;
import org.apache.geode.cache.LoaderHelper;

import io.pivotal.bds.gemfire.fraud.common.key.CardKey;

public class CardLockCacheLoader implements CacheLoader<CardKey, ReentrantReadWriteLock> {

    @Override
    public void close() {
    }

    @Override
    public ReentrantReadWriteLock load(LoaderHelper<CardKey, ReentrantReadWriteLock> helper) throws CacheLoaderException {
        return new ReentrantReadWriteLock();
    }

}
