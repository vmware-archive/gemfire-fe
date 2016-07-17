package io.pivotal.bds.gemfire.keyfw.generator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.distributed.DistributedLockService;
import com.gemstone.gemfire.distributed.DistributedSystem;

public class ReplicateLockingIntegerIDGenerator implements IDGenerator<Integer> {

    private Region<String, Integer> idRegion;
    private DistributedSystem system;

    private static final String serviceName = "IDGenerator";
    private static final long waitTime = 1000L;
    private static final long leaseTime = 1000L;

    private static final Logger LOG = LoggerFactory.getLogger(ReplicateLockingIntegerIDGenerator.class);

    public ReplicateLockingIntegerIDGenerator(Region<String, Integer> idRegion, DistributedSystem system) {
        this.idRegion = idRegion;
        this.system = system;
    }

    @Override
    public Integer generate(String domain) {
        LOG.debug("generate: domain={}", domain);

        DistributedLockService dls = DistributedLockService.create(serviceName, system);
        boolean success = dls.lock(domain, waitTime, leaseTime);

        if (!success) {
            throw new IllegalStateException("cannot acquire lock for setting prefix");
        }

        try {
            int id = idRegion.get(domain);
            idRegion.put(domain, id + 1);

            LOG.debug("generate: domain={}, id={}", domain, id);
            return id;
        } finally {
            dls.unlock(domain);
        }
    }

}
