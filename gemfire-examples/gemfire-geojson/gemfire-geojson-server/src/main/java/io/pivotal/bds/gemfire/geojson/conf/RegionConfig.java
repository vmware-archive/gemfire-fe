package io.pivotal.bds.gemfire.geojson.conf;

import org.apache.geode.cache.Cache;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.RegionFactory;
import org.apache.geode.cache.RegionShortcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RegionConfig {

    private static final Logger LOG = LoggerFactory.getLogger(RegionConfig.class);

    @Bean
    public Region<Integer, Integer> routingRegion(Cache cache) {
        LOG.info("routingRegion");
        RegionFactory<Integer, Integer> rf = cache.createRegionFactory(RegionShortcut.PARTITION);
        return rf.create("routing");
    }
}
