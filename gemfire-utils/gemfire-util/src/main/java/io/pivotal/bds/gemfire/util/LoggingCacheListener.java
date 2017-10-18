package io.pivotal.bds.gemfire.util;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.geode.cache.CacheListener;
import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.EntryEvent;
import org.apache.geode.cache.RegionEvent;

public class LoggingCacheListener<K, V> implements CacheListener<K, V>, Declarable {

    private static final Logger LOG = LogManager.getLogger(LoggingCacheListener.class);

    @Override
    public void close() {
    }

    @Override
    public void init(Properties props) {
    }

    @Override
    public void afterCreate(EntryEvent<K, V> evt) {
        LOG.info("afterCreate: evt={}", evt);
    }

    @Override
    public void afterDestroy(EntryEvent<K, V> evt) {
        LOG.info("afterDestroy: evt={}", evt);
    }

    @Override
    public void afterInvalidate(EntryEvent<K, V> evt) {
        LOG.info("afterInvalidate: evt={}", evt);
    }

    @Override
    public void afterRegionClear(RegionEvent<K, V> evt) {
        LOG.info("afterRegionClear: evt={}", evt);
    }

    @Override
    public void afterRegionCreate(RegionEvent<K, V> evt) {
        LOG.info("afterRegionCreate: evt={}", evt);
    }

    @Override
    public void afterRegionDestroy(RegionEvent<K, V> evt) {
        LOG.info("afterRegionDestroy: evt={}", evt);
    }

    @Override
    public void afterRegionInvalidate(RegionEvent<K, V> evt) {
        LOG.info("afterRegionInvalidate: evt={}", evt);
    }

    @Override
    public void afterRegionLive(RegionEvent<K, V> evt) {
        LOG.info("afterRegionLive: evt={}", evt);
    }

    @Override
    public void afterUpdate(EntryEvent<K, V> evt) {
        LOG.info("afterUpdate: evt={}", evt);
    }

}
