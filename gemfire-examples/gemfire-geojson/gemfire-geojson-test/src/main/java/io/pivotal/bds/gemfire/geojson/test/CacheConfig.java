package io.pivotal.bds.gemfire.geojson.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.cache.client.Pool;

import io.pivotal.bds.gemfire.util.LocatorHelper;

@Configuration
public class CacheConfig {

    private static final Logger LOG = LoggerFactory.getLogger(CacheConfig.class);

    @Bean
    public ClientCache cache(PropertyConfig props) {
        String locators = props.locators;
        LOG.info("cache: locators={}", locators);

        ClientCacheFactory ccf = new ClientCacheFactory();
        LocatorHelper.addLocators(ccf, locators);
        ccf.setPdxReadSerialized(true);

        return ccf.create();
    }
    
    @Bean
    public Pool pool(ClientCache cache) {
        LOG.info("pool");
        return cache.getDefaultPool();
    }
}
