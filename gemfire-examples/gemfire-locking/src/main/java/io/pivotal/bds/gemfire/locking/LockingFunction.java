package io.pivotal.bds.gemfire.locking;

import java.util.concurrent.locks.Lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.execute.Function;
import org.apache.geode.cache.execute.FunctionContext;
import org.apache.geode.cache.execute.FunctionException;
import org.apache.geode.cache.execute.ResultSender;

public class LockingFunction implements Function {

    private Region<String, Integer> counterRegion;
    private Region<LockerKey<String>, Locker> lockRegion;

    private static final long serialVersionUID = 1L;

    private static final Logger LOG = LoggerFactory.getLogger(LockingFunction.class);

    public LockingFunction(Region<String, Integer> counterRegion, Region<LockerKey<String>, Locker> lockRegion) {
        this.counterRegion = counterRegion;
        this.lockRegion = lockRegion;
    }

    @Override
    public void execute(FunctionContext context) {
        LOG.info("execute");

        try {
            ResultSender<Boolean> sender = context.getResultSender();

            String key = (String) context.getArguments();
            LOG.info("execute: key={}", key);

            LockerKey<String> lk = new LockerKey<String>(key);
            Locker locker = lockRegion.get(lk);

            LOG.info("execute: locking, key={}", key);
            Lock writeLock = locker.getWriteLock();
            writeLock.lock();

            try {
                Integer t = counterRegion.get(key);
                LOG.info("execute: key={}, t={}", key, t);
                Integer t1 = t + 1;

                LOG.info("execute: replacing, key={}, t={}, t1={}", key, t, t1);
                if (!counterRegion.replace(key, t, t1)) {
                    throw new IllegalStateException("Cannot update counter for " + key);
                }
            } finally {
                LOG.info("execute: unlocking, key={}", key);
                writeLock.unlock();
            }

            sender.lastResult(Boolean.TRUE);
        } catch (FunctionException x) {
            LOG.error(x.toString(), x);
            throw x;
        } catch (Exception x) {
            LOG.error(x.toString(), x);
            throw new FunctionException(x.toString(), x);
        }
    }

    @Override
    public String getId() {
        return LockingFunction.class.getSimpleName();
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
