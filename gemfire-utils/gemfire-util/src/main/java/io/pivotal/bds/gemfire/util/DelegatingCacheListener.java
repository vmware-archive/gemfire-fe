package io.pivotal.bds.gemfire.util;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import com.gemstone.gemfire.cache.CacheListener;
import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.EntryEvent;
import com.gemstone.gemfire.cache.RegionEvent;

public class DelegatingCacheListener<K, V> implements CacheListener<K, V>, Declarable {

    private Set<CacheListener<K, V>> delegates = new HashSet<>();
    
    public void addDelegate(CacheListener<K, V> cl) {
        delegates.add(cl);
    }
    
    public void removeDelegate(CacheListener<K, V> cl) {
        delegates.remove(cl);
    }
    
    @Override
    public void close() {
    }

    @Override
    public void init(Properties props) {
    }

    @Override
    public void afterCreate(EntryEvent<K, V> event) {
        for (CacheListener<K, V> cl: delegates) {
            cl.afterCreate(event);
        }
    }

    @Override
    public void afterDestroy(EntryEvent<K, V> event) {
        for (CacheListener<K, V> cl: delegates) {
            cl.afterDestroy(event);
        }
    }

    @Override
    public void afterInvalidate(EntryEvent<K, V> event) {
        for (CacheListener<K, V> cl: delegates) {
            cl.afterInvalidate(event);
        }
    }

    @Override
    public void afterRegionClear(RegionEvent<K, V> event) {
        for (CacheListener<K, V> cl: delegates) {
            cl.afterRegionClear(event);
        }
    }

    @Override
    public void afterRegionCreate(RegionEvent<K, V> event) {
        for (CacheListener<K, V> cl: delegates) {
            cl.afterRegionCreate(event);
        }
    }

    @Override
    public void afterRegionDestroy(RegionEvent<K, V> event) {
        for (CacheListener<K, V> cl: delegates) {
            cl.afterRegionDestroy(event);
        }
    }

    @Override
    public void afterRegionInvalidate(RegionEvent<K, V> event) {
        for (CacheListener<K, V> cl: delegates) {
            cl.afterRegionInvalidate(event);
        }
    }

    @Override
    public void afterRegionLive(RegionEvent<K, V> event) {
        for (CacheListener<K, V> cl: delegates) {
            cl.afterRegionLive(event);
        }
    }

    @Override
    public void afterUpdate(EntryEvent<K, V> event) {
        for (CacheListener<K, V> cl: delegates) {
            cl.afterUpdate(event);
        }
    }

}
