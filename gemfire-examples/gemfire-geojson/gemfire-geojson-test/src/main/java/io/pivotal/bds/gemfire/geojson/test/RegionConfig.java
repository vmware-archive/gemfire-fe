package io.pivotal.bds.gemfire.geojson.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientRegionFactory;
import com.gemstone.gemfire.cache.client.ClientRegionShortcut;

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
