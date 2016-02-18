package io.pivotal.bds.gemfire.r.server.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.CacheFactory;
import com.gemstone.gemfire.cache.Operation;
import com.gemstone.gemfire.cache.Region;

import io.pivotal.bds.gemfire.r.common.Prediction;
import io.pivotal.bds.gemfire.r.common.PredictionKey;

public abstract class PredictHandler {

    private String modelId;

    private static final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static final Lock readLock = readWriteLock.readLock();
    private static final Lock writeLock = readWriteLock.writeLock();

    private static final Map<String, Map<String, PredictHandler>> handlers = new HashMap<>();

    private static Region<PredictionKey, Prediction> predictionRegion;

    private static final Logger LOG = LoggerFactory.getLogger(PredictHandler.class);

    public PredictHandler(String modelId) {
        this.modelId = modelId;
    }

    public static void handle(String regionName, Operation op, Object key, Object value) {
        LOG.debug("handle: regionName={}, op={}, key={}, value={}", regionName, op, key, value);

        readLock.lock();

        try {
            Map<String, PredictHandler> list = handlers.get(regionName);

            if (list != null && !list.isEmpty()) {
                for (PredictHandler h : list.values()) {
                    h.doHandle(regionName, op, key, value);
                }
            }
        } finally {
            readLock.unlock();
        }
    }

    protected static void addHandler(PredictHandler handler, String regionName) {
        LOG.debug("addHandler: handler={}, regionName={}", handler, regionName);

        writeLock.lock();

        try {
            Map<String, PredictHandler> list = handlers.get(regionName);

            if (list == null) {
                list = new HashMap<>();
                handlers.put(regionName, list);
            }

            list.put(handler.getModelId(), handler);
        } finally {
            writeLock.unlock();
        }
    }

    public static void removeHandler(String modelId, String regionName) {
        LOG.debug("removeHandler: modelId={}, regionName={}", modelId, regionName);

        writeLock.lock();

        try {
            Map<String, PredictHandler> list = handlers.get(regionName);

            if (list != null) {
                list.remove(modelId);
            }
        } finally {
            writeLock.unlock();
        }
    }

    public String getModelId() {
        return modelId;
    }

    @Override
    public String toString() {
        return "PredictHandler [modelId=" + modelId + "]";
    }

    public abstract void doHandle(String regionName, Operation op, Object key, Object value);

    protected static void send(PredictionKey key, Prediction prediction) {
        LOG.debug("send: key={}, prediction={}", key, prediction);
        getPredictionRegion().put(key, prediction);
    }

    private static Region<PredictionKey, Prediction> getPredictionRegion() {
        if (predictionRegion == null) {
            predictionRegion = CacheFactory.getAnyInstance().getRegion("prediction");
        }

        return predictionRegion;
    }
}
