package io.pivotal.bds.gemfire.util;

import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.partition.PartitionListener;

public class ExecutorPartitionListener implements PartitionListener, Declarable {

    private PartitionListener delegate;
    private ExecutorService exec;

    private static final Logger LOG = LogManager.getLogger(ExecutorPartitionListener.class);

    public ExecutorPartitionListener() {
    }

    public ExecutorPartitionListener(PartitionListener delegate, ExecutorService exec) {
        this.delegate = delegate;
        this.exec = exec;
    }

    public ExecutorPartitionListener(PartitionListener delegate, int threadCount) {
        this.delegate = delegate;
        this.exec = Executors.newFixedThreadPool(threadCount);
    }

    @Override
    public void init(Properties props) {
        String delegateClassName = props.getProperty("delegateClassName");
        int threadCount = Integer.parseInt(props.getProperty("threadCount", "10"));
        LOG.info("init: delegateClassName={}, threadCount={}", delegateClassName, threadCount);

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

        exec = Executors.newFixedThreadPool(threadCount);
    }

    @Override
    public void afterBucketCreated(int bucketId, Iterable<?> keys) {
        LOG.debug("afterBucketCreated: bucketId={}, keys={}", bucketId, keys);
        exec.execute(new Runnable() {

            @Override
            public void run() {
                LOG.debug("afterBucketCreated: run: bucketId={}, keys={}", bucketId, keys);
                delegate.afterBucketCreated(bucketId, keys);
            }
        });
    }

    @Override
    public void afterBucketRemoved(int bucketId, Iterable<?> keys) {
        LOG.debug("afterBucketRemoved: bucketId={}, keys={}", bucketId, keys);
        exec.execute(new Runnable() {

            @Override
            public void run() {
                LOG.debug("afterBucketRemoved: run: bucketId={}, keys={}", bucketId, keys);
                delegate.afterBucketRemoved(bucketId, keys);
            }
        });
    }

    @Override
    public void afterPrimary(int bucketId) {
        LOG.debug("afterPrimary: bucketId={}", bucketId);
        exec.execute(new Runnable() {

            @Override
            public void run() {
                LOG.debug("afterPrimary: run: bucketId={}", bucketId);
                delegate.afterPrimary(bucketId);
            }
        });
    }

    @Override
    public void afterRegionCreate(Region<?, ?> region) {
        LOG.debug("afterRegionCreate: region={}", region);
        exec.execute(new Runnable() {

            @Override
            public void run() {
                LOG.debug("afterRegionCreate: run: region={}", region);
                delegate.afterRegionCreate(region);
            }
        });
    }
}
