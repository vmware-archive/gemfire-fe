package io.pivotal.bds.gemfire.util;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.geode.cache.CacheListener;
import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.EntryEvent;
import org.apache.geode.cache.Operation;
import org.apache.geode.cache.RegionEvent;

public class ExecutorCacheListener<K, V> implements CacheListener<K, V>, Declarable {

    private CacheListener<K, V> delegate;
    private ExecutorService exec;
    private Set<Operation> allowedOperations;
    private Set<Operation> ignoredOperations;

    private static final Logger LOG = LogManager.getLogger(ExecutorCacheListener.class);

    public ExecutorCacheListener() {
    }

    public ExecutorCacheListener(CacheListener<K, V> delegate, ExecutorService exec) {
        this.delegate = delegate;
        this.exec = exec;
        this.allowedOperations = new HashSet<>();
        this.ignoredOperations = new HashSet<>();
    }

    public ExecutorCacheListener(CacheListener<K, V> delegate, int threadCount) {
        this.delegate = delegate;
        this.exec = Executors.newFixedThreadPool(threadCount);
        this.allowedOperations = new HashSet<>();
        this.ignoredOperations = new HashSet<>();
    }

    public Set<Operation> getAllowedOperations() {
        return allowedOperations;
    }

    public Set<Operation> getIgnoredOperations() {
        return ignoredOperations;
    }

    @Override
    public void close() {
    }

    @SuppressWarnings("unchecked")
    @Override
    public void init(Properties props) {
        String delegateClassName = props.getProperty("delegateClassName");
        int threadCount = Integer.parseInt(props.getProperty("threadCount", "10"));
        String allowedOps = props.getProperty("allowedOperations");
        String ignoredOps = props.getProperty("ignoredOperations");
        LOG.info("init: delegateClassName={}, threadCount={}, allowedOperations={}, ignoredOperations={}", delegateClassName,
                threadCount, allowedOps, ignoredOps);

        if (delegateClassName == null || delegateClassName.trim().length() == 0) {
            throw new IllegalArgumentException("Missing property 'delegateClassName'");
        }

        try {
            Class<?> c = Class.forName(delegateClassName);
            Declarable d = (Declarable) c.newInstance();
            d.init(props);
            delegate = (CacheListener<K, V>) d;
        } catch (Exception x) {
            throw new IllegalArgumentException(x.toString(), x);
        }

        exec = Executors.newFixedThreadPool(threadCount);
        
        if (allowedOps != null && allowedOps.trim().length() > 0) {
            String[] ss = allowedOps.split(",");
            
            for (String s: ss) {
                // TODO
            }
        }
        
        if (ignoredOps != null && ignoredOps.trim().length() > 0) {
            String[] ss = ignoredOps.split(",");
            
            for (String s: ss) {
                // TODO
            }
        }
    }

    private boolean check(Operation op) {
        if (!allowedOperations.isEmpty() && !allowedOperations.contains(op)) {
            return false;
        }

        if (!ignoredOperations.isEmpty() && ignoredOperations.contains(op)) {
            return false;
        }

        return true;
    }

    @Override
    public void afterCreate(EntryEvent<K, V> event) {
        LOG.debug("afterCreate: event={}", event);

        if (check(event.getOperation())) {
            exec.execute(new Runnable() {

                @Override
                public void run() {
                    LOG.debug("afterCreate: run: event={}", event);
                    delegate.afterCreate(event);
                }
            });
        }
    }

    @Override
    public void afterDestroy(EntryEvent<K, V> event) {
        LOG.debug("afterDestroy: event={}", event);

        if (check(event.getOperation())) {
            exec.execute(new Runnable() {

                @Override
                public void run() {
                    LOG.debug("afterDestroy: run: event={}", event);
                    delegate.afterDestroy(event);
                }
            });
        }
    }

    @Override
    public void afterInvalidate(EntryEvent<K, V> event) {
        LOG.debug("afterInvalidate: event={}", event);

        if (check(event.getOperation())) {
            exec.execute(new Runnable() {

                @Override
                public void run() {
                    LOG.debug("afterInvalidate: run: event={}", event);
                    delegate.afterInvalidate(event);
                }
            });
        }
    }

    @Override
    public void afterRegionClear(RegionEvent<K, V> event) {
        LOG.debug("afterRegionClear: event={}", event);

        if (check(event.getOperation())) {
            exec.execute(new Runnable() {

                @Override
                public void run() {
                    LOG.debug("afterRegionClear: run: event={}", event);
                    delegate.afterRegionClear(event);
                }
            });
        }
    }

    @Override
    public void afterRegionCreate(RegionEvent<K, V> event) {
        LOG.debug("afterRegionCreate: event={}", event);

        if (check(event.getOperation())) {
            exec.execute(new Runnable() {

                @Override
                public void run() {
                    LOG.debug("afterRegionCreate: run: event={}", event);
                    delegate.afterRegionCreate(event);
                }
            });
        }
    }

    @Override
    public void afterRegionDestroy(RegionEvent<K, V> event) {
        LOG.debug("afterRegionDestroy: event={}", event);

        if (check(event.getOperation())) {
            exec.execute(new Runnable() {

                @Override
                public void run() {
                    LOG.debug("afterRegionDestroy: run: event={}", event);
                    delegate.afterRegionDestroy(event);
                }
            });
        }
    }

    @Override
    public void afterRegionInvalidate(RegionEvent<K, V> event) {
        LOG.debug("afterRegionInvalidate: event={}", event);

        if (check(event.getOperation())) {
            exec.execute(new Runnable() {

                @Override
                public void run() {
                    LOG.debug("afterRegionInvalidate: run: event={}", event);
                    delegate.afterRegionInvalidate(event);
                }
            });
        }
    }

    @Override
    public void afterRegionLive(RegionEvent<K, V> event) {
        LOG.debug("afterRegionLive: event={}", event);

        if (check(event.getOperation())) {
            exec.execute(new Runnable() {

                @Override
                public void run() {
                    LOG.debug("afterRegionLive: run: event={}", event);
                    delegate.afterRegionLive(event);
                }
            });
        }
    }

    @Override
    public void afterUpdate(EntryEvent<K, V> event) {
        LOG.debug("afterUpdate: event={}", event);

        if (check(event.getOperation())) {
            exec.execute(new Runnable() {

                @Override
                public void run() {
                    LOG.debug("afterUpdate: run: event={}", event);
                    delegate.afterUpdate(event);
                }
            });
        }
    }
}
