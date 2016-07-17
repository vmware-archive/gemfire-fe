package io.pivotal.bds.gemfire.keyfw.generator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.Region;

public class RegionIntegerIDGenerator implements IDGenerator<Integer> {

    private Region<String, Integer> region;

    private static final Logger LOG = LoggerFactory.getLogger(RegionIntegerIDGenerator.class);

    public RegionIntegerIDGenerator(Region<String, Integer> region) {
        this.region = region;
    }

    @Override
    public synchronized Integer generate(String domain) {
        LOG.debug("generating id for domain={}", domain);

        Integer l = region.get(domain);
        l = l.intValue() + 1;
        LOG.debug("generating id for domain={}, id={}", domain, l);

        region.put(domain, l);

        return l;
    }
}
