package io.pivotal.bds.gemfire.r.server.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.Operation;

public abstract class Handler {

    private Object key;
    private String regionName;

    private static final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static final Lock readLock = readWriteLock.readLock();
    private static final Lock writeLock = readWriteLock.writeLock();

    private static final Map<String, Map<Object, Handler>> handlers = new HashMap<>();

    private static final Logger HANDLER_LOG = LoggerFactory.getLogger(Handler.class);
    protected final Logger LOG;

    public static void handle(String regionName, Operation op, Object key, Object value) {
        HANDLER_LOG.debug("handle: regionName={}, op={}, key={}, value={}", regionName, op, key, value);

        readLock.lock();

        try {
            Map<Object, Handler> map = handlers.get(regionName);

            if (map != null && !map.isEmpty()) {
                for (Handler h : map.values()) {
                    h.doHandle(regionName, op, key, value);
                }
            }
        } finally {
            readLock.unlock();
        }
    }

    protected static void addHandler(Handler handler) {
        HANDLER_LOG.debug("addHandler: handler={}", handler);
        Object key = handler.key;
        String regionName = handler.regionName;

        writeLock.lock();

        try {
            Map<Object, Handler> map = handlers.get(regionName);

            if (map == null) {
                map = new HashMap<>();
                handlers.put(regionName, map);
            }

            map.put(key, handler);
        } finally {
            writeLock.unlock();
        }
    }

    public static void removeHandler(Object key, String regionName) {
        HANDLER_LOG.debug("removeHandler: key={}, regionName={}", key, regionName);

        writeLock.lock();

        try {
            Map<Object, Handler> map = handlers.get(regionName);

            if (map != null) {
                map.remove(key);

                if (map.isEmpty()) {
                    handlers.remove(regionName);
                }
            }

        } finally {
            writeLock.unlock();
        }
    }

    public Handler(Object key, String regionName) {
        this.LOG = LoggerFactory.getLogger(getClass());
        this.key = key;
        this.regionName = regionName;
        addHandler(this);
    }

    public Object getKey() {
        return key;
    }

    public String getRegionName() {
        return regionName;
    }

    public abstract void doHandle(String regionName, Operation op, Object key, Object value);

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [key=" + key + "]";
    }
}
