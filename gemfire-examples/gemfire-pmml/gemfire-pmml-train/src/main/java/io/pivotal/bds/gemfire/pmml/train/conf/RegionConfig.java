package io.pivotal.bds.gemfire.pmml.train.conf;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientRegionFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.pivotal.bds.gemfire.pmml.common.data.Model;
import io.pivotal.bds.gemfire.pmml.common.keys.ModelKey;

@Configuration
public class RegionConfig {

    private static final Logger LOG = LoggerFactory.getLogger(RegionConfig.class);
    
    @Bean
    public Region<ModelKey, Model> modelRegion(ClientCache cache) {
        LOG.info("modelRegion");
        ClientRegionFactory<ModelKey, Model> crf = cache.createClientRegionFactory(ClientRegionShortcut.PROXY);
        return crf.create("model");
    }
}
