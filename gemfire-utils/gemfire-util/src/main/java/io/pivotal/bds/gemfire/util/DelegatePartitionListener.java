package io.pivotal.bds.gemfire.util;

import com.gemstone.gemfire.cache.partition.PartitionListener;

public abstract class DelegatePartitionListener implements PartitionListener {

    public DelegatePartitionListener(DelegatingPartitionListener pl) {
        pl.addDelegate(this);
    }

}
