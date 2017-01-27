package io.pivotal.bds.gemfire.geojson.test;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientRegionFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.apache.geode.pdx.PdxInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

@Configuration
public class RegionConfig {
    
    private ClientCache cache;

    private static final Logger LOG = LoggerFactory.getLogger(RegionConfig.class);

    @Autowired
    public RegionConfig(ClientCache cache) {
        this.cache = cache;
    }

    @Bean
    public Region<String, String> jsonFeatureRegion() {
        LOG.info("jsonFeatureRegion");
        Assert.notNull(cache);
        ClientRegionFactory<String, String> crf = cache.createClientRegionFactory(ClientRegionShortcut.PROXY);
        return crf.create("jsonFeature");
    }

}
