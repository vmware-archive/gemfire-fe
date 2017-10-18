package io.pivotal.bds.gemfire.pmml.predict.conf;

import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.Pool;
import org.apache.geode.pdx.ReflectionBasedAutoSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.pivotal.bds.gemfire.util.LocatorHelper;

@Configuration
@EnableConfigurationProperties(GemfireProperties.class)
public class CacheConfig {
    
    private static final Logger LOG = LoggerFactory.getLogger(CacheConfig.class);

    @Bean
    public ClientCache cache(GemfireProperties gemfireProperties) {
        LOG.info("cache: locators={}", gemfireProperties.locators);
        ClientCacheFactory ccf = new ClientCacheFactory();
        
        LocatorHelper.addLocators(ccf, gemfireProperties.locators);
        
        ccf.setPdxSerializer(new ReflectionBasedAutoSerializer("io.pivotal.bds.gemfire.pmml.common.data.*"));
        ccf.setPdxPersistent(false);
        ccf.setPdxReadSerialized(false);
        
        return ccf.create();
    }
    
    @Bean
    public Pool pool(ClientCache cache) {
        return cache.getDefaultPool();
    }
}
