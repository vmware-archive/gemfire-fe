package io.pivotal.bds.gemfire.geo.function;

import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.execute.Function;

import io.pivotal.bds.gemfire.geo.Constants;

@SuppressWarnings("serial")
public abstract class BaseLockingFunction implements Function, Declarable, Constants {
    
    protected static final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    protected static final Lock readLock = readWriteLock.readLock();
    protected static final Lock writeLock = readWriteLock.writeLock();

    @Override
    public void init(Properties props) {
    }

    @Override
    public String getId() {
        return getClass().getSimpleName();
    }

    @Override
    public boolean hasResult() {
        return true;
    }

    @Override
    public boolean isHA() {
        return true;
    }

    @Override
    public boolean optimizeForWrite() {
        return true;
    }

}
