package io.pivotal.bds.gemfire.hbase.util;

import java.io.Serializable;

public abstract class Factory<V> implements Serializable {

    private static final long serialVersionUID = 1L;

    public abstract V create();
}
