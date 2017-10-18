package io.pivotal.bds.gemfire.pmml.server.conf;

import org.apache.geode.cache.Cache;
import org.apache.geode.cache.CacheFactory;
import org.apache.geode.cache.server.CacheServer;
import org.apache.geode.pdx.ReflectionBasedAutoSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(PropertyConfig.class)
public class CacheConfig {

    private static final Logger LOG = LoggerFactory.getLogger(CacheConfig.class);

    @Bean
    public Cache cache(PropertyConfig propertyConfig) throws Exception {
        LOG.info("creating Cache");
        CacheFactory cf = new CacheFactory();

        String locators = propertyConfig.locators;
        int port = propertyConfig.port;

        LOG.info("creating Cache, locators={}, port={}", locators, port);
        cf.set("locators", locators);

        cf.setPdxSerializer(new ReflectionBasedAutoSerializer("io.pivotal.bds.gemfire.analytics.common.*"));
        cf.setPdxReadSerialized(false);
        cf.setPdxPersistent(true);

        Cache c = cf.create();

        LOG.info("creating CacheServer");
        CacheServer cs = c.addCacheServer();
        cs.setPort(port);
        cs.start();

        return c;
    }

}
