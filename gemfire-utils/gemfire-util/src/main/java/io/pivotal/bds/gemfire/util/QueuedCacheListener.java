package io.pivotal.bds.gemfire.util;

import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.geode.cache.CacheListener;
import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.EntryEvent;
import org.apache.geode.cache.RegionEvent;

public class QueuedCacheListener<K, V> implements CacheListener<K, V>, Declarable {

    private CacheListener<K, V> delegate;

    private BlockingQueue<EntryEvent<K, V>> afterCreateQueue;
    private BlockingQueue<EntryEvent<K, V>> afterUpdateQueue;
    private BlockingQueue<EntryEvent<K, V>> afterDestroyQueue;
    private BlockingQueue<EntryEvent<K, V>> afterInvalidateQueue;
    private BlockingQueue<RegionEvent<K, V>> afterRegionClearQueue;
    private BlockingQueue<RegionEvent<K, V>> afterRegionCreateQueue;
    private BlockingQueue<RegionEvent<K, V>> afterRegionDestroyQueue;
    private BlockingQueue<RegionEvent<K, V>> afterRegionInvalidateQueue;
    private BlockingQueue<RegionEvent<K, V>> afterRegionLiveQueue;

    private boolean running = true;

    private static final Logger LOG = LogManager.getLogger(QueuedCacheListener.class);

    public QueuedCacheListener() {
    }

    public QueuedCacheListener(CacheListener<K, V> delegate, int queueSize) {
        this.delegate = delegate;
        init(queueSize);
    }

    private void init(int queueSize) {
        afterCreateQueue = createQueue(queueSize);
        afterUpdateQueue = createQueue(queueSize);
        afterDestroyQueue = createQueue(queueSize);
        afterInvalidateQueue = createQueue(queueSize);
        afterRegionClearQueue = createQueue(queueSize);
        afterRegionCreateQueue = createQueue(queueSize);
        afterRegionDestroyQueue = createQueue(queueSize);
        afterRegionInvalidateQueue = createQueue(queueSize);
        afterRegionLiveQueue = createQueue(queueSize);

        new AfterCreateRunner(afterCreateQueue).start();
        new AfterUpdateRunner(afterUpdateQueue).start();
        new AfterDestroyRunner(afterDestroyQueue).start();
        new AfterInvalidateRunner(afterInvalidateQueue).start();
        new AfterRegionClearRunner(afterRegionClearQueue).start();
        new AfterRegionCreateRunner(afterRegionCreateQueue).start();
        new AfterRegionDestroyRunner(afterRegionDestroyQueue).start();
        new AfterRegionInvalidateRunner(afterRegionInvalidateQueue).start();
        new AfterRegionLiveRunner(afterRegionLiveQueue).start();
    }

    private <E> BlockingQueue<E> createQueue(int queueSize) {
        return queueSize <= 0 ? new LinkedBlockingQueue<>() : new LinkedBlockingQueue<>(queueSize);
    }

    @Override
    public void close() {
        running = false; // TODO need to kill queues
    }

    @SuppressWarnings("unchecked")
    @Override
    public void init(Properties props) {
        String delegateClassName = props.getProperty("delegateClassName");
        int queueSize = Integer.parseInt(props.getProperty("queueSize", "0"));
        LOG.info("init: delegateClassName={}, queueSize={}", delegateClassName, queueSize);

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

        init(queueSize);
    }

    @Override
    public void afterCreate(EntryEvent<K, V> event) {
        LOG.debug("afterCreate: event={}", event);
        try {
            afterCreateQueue.put(event);
        } catch (Exception x) {
            LOG.error("afterCreate: x={}", x.toString(), x);
        }
    }

    @Override
    public void afterDestroy(EntryEvent<K, V> event) {
        LOG.debug("afterDestroy: event={}", event);
        try {
            afterDestroyQueue.put(event);
        } catch (Exception x) {
            LOG.error("afterCreate: x={}", x.toString(), x);
        }
    }

    @Override
    public void afterInvalidate(EntryEvent<K, V> event) {
        LOG.debug("afterInvalidate: event={}", event);
        try {
            afterInvalidateQueue.put(event);
        } catch (Exception x) {
            LOG.error("afterCreate: x={}", x.toString(), x);
        }
    }

    @Override
    public void afterRegionClear(RegionEvent<K, V> event) {
        LOG.debug("afterRegionClear: event={}", event);
        try {
            afterRegionClearQueue.put(event);
        } catch (Exception x) {
            LOG.error("afterCreate: x={}", x.toString(), x);
        }
    }

    @Override
    public void afterRegionCreate(RegionEvent<K, V> event) {
        LOG.debug("afterRegionCreate: event={}", event);
        try {
            afterRegionCreateQueue.put(event);
        } catch (Exception x) {
            LOG.error("afterCreate: x={}", x.toString(), x);
        }
    }

    @Override
    public void afterRegionDestroy(RegionEvent<K, V> event) {
        LOG.debug("afterRegionDestroy: event={}", event);
        try {
            afterRegionDestroyQueue.put(event);
        } catch (Exception x) {
            LOG.error("afterCreate: x={}", x.toString(), x);
        }
    }

    @Override
    public void afterRegionInvalidate(RegionEvent<K, V> event) {
        LOG.debug("afterRegionInvalidate: event={}", event);
        try {
            afterRegionInvalidateQueue.put(event);
        } catch (Exception x) {
            LOG.error("afterCreate: x={}", x.toString(), x);
        }
    }

    @Override
    public void afterRegionLive(RegionEvent<K, V> event) {
        LOG.debug("afterRegionLive: event={}", event);
        try {
            afterRegionLiveQueue.put(event);
        } catch (Exception x) {
            LOG.error("afterCreate: x={}", x.toString(), x);
        }
    }

    @Override
    public void afterUpdate(EntryEvent<K, V> event) {
        LOG.debug("afterUpdate: event={}", event);
        try {
            afterUpdateQueue.put(event);
        } catch (Exception x) {
            LOG.error("afterCreate: x={}", x.toString(), x);
        }
    }

    private abstract class AbstractRunner<E> extends Thread {

        private BlockingQueue<E> queue;
        private final Logger log;

        public AbstractRunner(BlockingQueue<E> queue) {
            this.log = LogManager.getLogger(getClass());
            this.queue = queue;
        }

        protected abstract void process(E e);

        @Override
        public void run() {
            try {
                while (running) {
                    log.debug("run: waiting...");
                    E e = queue.take();
                    log.debug("run: e={}", e);

                    try {
                        process(e);
                    } catch (Exception x) {
                        log.error("run: inner: x={}", x.toString(), x);
                    }
                }
            } catch (Exception x) {
                log.error("run: x={}", x.toString(), x);
            }
        }
    }

    private class AfterCreateRunner extends AbstractRunner<EntryEvent<K, V>> {

        public AfterCreateRunner(BlockingQueue<EntryEvent<K, V>> queue) {
            super(queue);
        }

        @Override
        protected void process(EntryEvent<K, V> e) {
            delegate.afterCreate(e);
        }
    }

    private class AfterUpdateRunner extends AbstractRunner<EntryEvent<K, V>> {

        public AfterUpdateRunner(BlockingQueue<EntryEvent<K, V>> queue) {
            super(queue);
        }

        @Override
        protected void process(EntryEvent<K, V> e) {
            delegate.afterUpdate(e);
        }
    }

    private class AfterDestroyRunner extends AbstractRunner<EntryEvent<K, V>> {

        public AfterDestroyRunner(BlockingQueue<EntryEvent<K, V>> queue) {
            super(queue);
        }

        @Override
        protected void process(EntryEvent<K, V> e) {
            delegate.afterDestroy(e);
        }
    }

    private class AfterInvalidateRunner extends AbstractRunner<EntryEvent<K, V>> {

        public AfterInvalidateRunner(BlockingQueue<EntryEvent<K, V>> queue) {
            super(queue);
        }

        @Override
        protected void process(EntryEvent<K, V> e) {
            delegate.afterInvalidate(e);
        }
    }

    private class AfterRegionCreateRunner extends AbstractRunner<RegionEvent<K, V>> {

        public AfterRegionCreateRunner(BlockingQueue<RegionEvent<K, V>> queue) {
            super(queue);
        }

        @Override
        protected void process(RegionEvent<K, V> e) {
            delegate.afterRegionCreate(e);
        }
    }

    private class AfterRegionClearRunner extends AbstractRunner<RegionEvent<K, V>> {

        public AfterRegionClearRunner(BlockingQueue<RegionEvent<K, V>> queue) {
            super(queue);
        }

        @Override
        protected void process(RegionEvent<K, V> e) {
            delegate.afterRegionClear(e);
        }
    }

    private class AfterRegionDestroyRunner extends AbstractRunner<RegionEvent<K, V>> {

        public AfterRegionDestroyRunner(BlockingQueue<RegionEvent<K, V>> queue) {
            super(queue);
        }

        @Override
        protected void process(RegionEvent<K, V> e) {
            delegate.afterRegionDestroy(e);
        }
    }

    private class AfterRegionInvalidateRunner extends AbstractRunner<RegionEvent<K, V>> {

        public AfterRegionInvalidateRunner(BlockingQueue<RegionEvent<K, V>> queue) {
            super(queue);
        }

        @Override
        protected void process(RegionEvent<K, V> e) {
            delegate.afterRegionInvalidate(e);
        }
    }

    private class AfterRegionLiveRunner extends AbstractRunner<RegionEvent<K, V>> {

        public AfterRegionLiveRunner(BlockingQueue<RegionEvent<K, V>> queue) {
            super(queue);
        }

        @Override
        protected void process(RegionEvent<K, V> e) {
            delegate.afterRegionLive(e);
        }
    }
}
