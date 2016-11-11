package io.pivotal.bds.gemfire.util;

import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.partition.PartitionListener;

public class QueuedPartitionListener implements PartitionListener, Declarable {

    private PartitionListener delegate;

    private BlockingQueue<Holder> afterBucketCreatedQueue;
    private BlockingQueue<Holder> afterBucketRemovedQueue;
    private BlockingQueue<Integer> afterPrimaryQueue;
    private BlockingQueue<Region<?, ?>> afterRegionCreateQueue;

    private boolean running = true;

    private static final Logger LOG = LogManager.getLogger(QueuedPartitionListener.class);

    public QueuedPartitionListener() {
    }

    public QueuedPartitionListener(PartitionListener delegate, int queueSize) {
        this.delegate = delegate;
        init(queueSize);
    }

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
            delegate = (PartitionListener) d;
        } catch (Exception x) {
            throw new IllegalArgumentException(x.toString(), x);
        }

        init(queueSize);
    }

    private void init(int queueSize) {
        afterBucketCreatedQueue = createQueue(queueSize);
        afterBucketRemovedQueue = createQueue(queueSize);
        afterPrimaryQueue = createQueue(queueSize);
        afterRegionCreateQueue = createQueue(queueSize);

        new AfterBucketCreatedRunner(afterBucketCreatedQueue).start();
        new AfterBucketRemovedRunner(afterBucketRemovedQueue).start();
        new AfterPrimaryRunner(afterPrimaryQueue).start();
        new AfterRegionCreateRunner(afterRegionCreateQueue).start();
    }

    private <E> BlockingQueue<E> createQueue(int queueSize) {
        return queueSize <= 0 ? new LinkedBlockingQueue<>() : new LinkedBlockingQueue<>(queueSize);
    }

    @Override
    public void afterBucketCreated(int bucketId, Iterable<?> keys) {
        LOG.debug("afterBucketCreated: bucketId={}, keys={}", bucketId, keys);
        try {
            afterBucketCreatedQueue.put(new Holder(bucketId, keys));
        } catch (Exception x) {
            throw new IllegalArgumentException(x.toString(), x);
        }
    }

    @Override
    public void afterBucketRemoved(int bucketId, Iterable<?> keys) {
        LOG.debug("afterBucketRemoved: bucketId={}, keys={}", bucketId, keys);
        try {
            afterBucketRemovedQueue.put(new Holder(bucketId, keys));
        } catch (Exception x) {
            throw new IllegalArgumentException(x.toString(), x);
        }
    }

    @Override
    public void afterPrimary(int bucketId) {
        LOG.debug("afterPrimary: bucketId={}", bucketId);
        try {
            afterPrimaryQueue.put(bucketId);
        } catch (Exception x) {
            throw new IllegalArgumentException(x.toString(), x);
        }
    }

    @Override
    public void afterRegionCreate(Region<?, ?> region) {
        LOG.debug("afterRegionCreate: region={}", region);
        try {
            afterRegionCreateQueue.put(region);
        } catch (Exception x) {
            throw new IllegalArgumentException(x.toString(), x);
        }
    }

    private static class Holder {

        public int bucketId;
        public Iterable<?> keys;

        public Holder(int bucketId, Iterable<?> keys) {
            this.bucketId = bucketId;
            this.keys = keys;
        }

        @Override
        public String toString() {
            return "Holder [bucketId=" + bucketId + ", keys=" + keys + "]";
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
                        LOG.error("{}: inner: x={}", getClass().getSimpleName(), x.toString(), x);
                    }
                }
            } catch (Exception x) {
                LOG.error("{}: x={}", getClass().getSimpleName(), x.toString(), x);
            }
        }
    }

    private class AfterBucketCreatedRunner extends AbstractRunner<Holder> {

        public AfterBucketCreatedRunner(BlockingQueue<Holder> queue) {
            super(queue);
        }

        @Override
        protected void process(Holder e) {
            delegate.afterBucketCreated(e.bucketId, e.keys);
        }
    }

    private class AfterBucketRemovedRunner extends AbstractRunner<Holder> {

        public AfterBucketRemovedRunner(BlockingQueue<Holder> queue) {
            super(queue);
        }

        @Override
        protected void process(Holder e) {
            delegate.afterBucketRemoved(e.bucketId, e.keys);
        }
    }

    private class AfterPrimaryRunner extends AbstractRunner<Integer> {

        public AfterPrimaryRunner(BlockingQueue<Integer> queue) {
            super(queue);
        }

        @Override
        protected void process(Integer e) {
            delegate.afterPrimary(e);
        }
    }

    private class AfterRegionCreateRunner extends AbstractRunner<Region<?, ?>> {

        public AfterRegionCreateRunner(BlockingQueue<Region<?, ?>> queue) {
            super(queue);
        }

        @Override
        protected void process(Region<?, ?> e) {
            delegate.afterRegionCreate(e);
        }
    }

}
