package io.pivotal.bds.gemfire.keyfw.generator;

import org.apache.geode.cache.Region;
import io.pivotal.bds.gemfire.util.FunctionServiceHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

public class PartitionedRegionIDGenerator implements IDGenerator<Long> {

    private Region<String, Long> idRegion;
    private FunctionServiceHelper functionServiceHelper;

    private long nextId = -1L;
    private long lastId = -1L;

    private  static final Logger LOG = LoggerFactory.getLogger(PartitionedRegionIDGenerator.class);

    public PartitionedRegionIDGenerator(Region<String, Long> idRegion, FunctionServiceHelper functionServiceHelper) {
        this.idRegion = idRegion;
        this.functionServiceHelper = functionServiceHelper;
    }

    @Override
    public synchronized Long generate(String domain) {
        if (nextId < 0L || nextId > lastId) {
            Collection<long[]> coll = (Collection<long[]>) functionServiceHelper
                    .onRegion(idRegion)
                    .withArgs(domain)
                    .execute("PartitionedRegionIDGeneratorFunction")
                    .getResult();
            assert coll.size() == 1;

            long[] ids = coll.iterator().next();
            assert ids.length == 2;

            nextId = ids[0];
            lastId = ids[1];
        }

        LOG.debug("generate: domain={}, nextId={}, lastId={}", domain, nextId, lastId);
        return nextId++;
    }
}
