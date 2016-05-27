package io.pivotal.bds.gemfire.util;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.springframework.util.Assert;

import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.partition.PartitionListener;

public class DelegatingPartitionListener implements PartitionListener, Declarable {

    private Set<PartitionListener> delegates = new HashSet<>();

    public void addDelegate(PartitionListener pl) {
        Assert.notNull(pl);
        delegates.add(pl);
    }

    public void removeDelegate(PartitionListener pl) {
        Assert.notNull(pl);
        delegates.remove(pl);
    }

    @Override
    public void init(Properties props) {
    }

    @Override
    public void afterBucketCreated(int bucketId, Iterable<?> keys) {
        for (PartitionListener pl : delegates) {
            pl.afterBucketCreated(bucketId, keys);
        }
    }

    @Override
    public void afterBucketRemoved(int bucketId, Iterable<?> keys) {
        for (PartitionListener pl : delegates) {
            pl.afterBucketRemoved(bucketId, keys);
        }
    }

    @Override
    public void afterPrimary(int bucketId) {
        for (PartitionListener pl : delegates) {
            pl.afterPrimary(bucketId);
        }
    }

    @Override
    public void afterRegionCreate(Region<?, ?> region) {
        for (PartitionListener pl : delegates) {
            pl.afterRegionCreate(region);
        }
    }

}
