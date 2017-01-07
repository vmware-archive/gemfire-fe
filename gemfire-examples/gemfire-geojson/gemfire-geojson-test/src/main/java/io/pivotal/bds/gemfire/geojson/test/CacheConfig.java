package io.pivotal.bds.gemfire.geojson.test;

import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.Pool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {

    private static final Logger LOG = LoggerFactory.getLogger(CacheConfig.class);

    @Bean
    public ClientCache cache(PropertyConfig props) {
        String locatorHost = props.locatorHost;
        LOG.info("cache: locatorHost={}", locatorHost);

        ClientCacheFactory ccf = new ClientCacheFactory();
        ccf.setPdxReadSerialized(true);
        ccf.addPoolLocator(locatorHost, 10334);

        return ccf.create();
    }
    
    @Bean
    public Pool pool(ClientCache cache) {
        LOG.info("pool");
        return cache.getDefaultPool();
    }
}
