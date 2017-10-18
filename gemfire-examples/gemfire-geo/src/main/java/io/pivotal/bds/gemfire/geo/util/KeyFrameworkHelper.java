package io.pivotal.bds.gemfire.geo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.Region;

import io.pivotal.bds.gemfire.geo.Constants;
import io.pivotal.bds.gemfire.keyfw.generator.ColocationKeyGenerator;
import io.pivotal.bds.gemfire.keyfw.generator.DefaultColocationKeyGenerator;
import io.pivotal.bds.gemfire.keyfw.generator.IDGenerator;
import io.pivotal.bds.gemfire.keyfw.generator.RegionLongIDGenerator;
import io.pivotal.bds.gemfire.util.RegionHelper;

public class KeyFrameworkHelper implements Constants {

    private static ColocationKeyGenerator<Long, Long> keyGenerator;
    private static final Logger LOG = LoggerFactory.getLogger(KeyFrameworkHelper.class);

    public static synchronized ColocationKeyGenerator<Long, Long> getKeyGenerator() {
        if (keyGenerator == null) {
            LOG.info("Creating KeyGenerator using region {}", ID_REGION_NAME);
            Region<String, Long> region = RegionHelper.getRegion(ID_REGION_NAME);
            IDGenerator<Long> idgen = new RegionLongIDGenerator(region);
            keyGenerator = new DefaultColocationKeyGenerator<>(idgen);
        }

        return keyGenerator;
    }
}
