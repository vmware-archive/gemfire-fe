package io.pivotal.bds.gemfire.util;

import org.apache.geode.cache.partition.PartitionListener;

public abstract class DelegatePartitionListener implements PartitionListener {

    public DelegatePartitionListener(DelegatingPartitionListener pl) {
        pl.addDelegate(this);
    }

}
