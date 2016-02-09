package io.pivotal.bds.gemfire.hbase.util;

import io.pivotal.bds.gemfire.util.DSLockingHashSet;

public class DSLockingHashSetFactory<K> extends Factory<DSLockingHashSet<K>> {

    private static final long serialVersionUID = 1L;

    @Override
    public DSLockingHashSet<K> create() {
        return new DSLockingHashSet<>();
    }

    @Override
    public String toString() {
        return "DSLockingHashSetFactory";
    }
}
