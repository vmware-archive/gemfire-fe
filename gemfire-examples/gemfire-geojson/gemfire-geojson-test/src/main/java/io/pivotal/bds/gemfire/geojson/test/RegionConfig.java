package io.pivotal.bds.gemfire.geojson.test;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientRegionFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RegionConfig {

    private static final Logger LOG = LoggerFactory.getLogger(RegionConfig.class);

    @Bean
    public Region<Integer, Integer> routingRegion(ClientCache cache) {
        LOG.info("routingRegion");
        ClientRegionFactory<Integer, Integer> crf = cache.createClientRegionFactory(ClientRegionShortcut.PROXY);
        return crf.create("routing");
    }
}
