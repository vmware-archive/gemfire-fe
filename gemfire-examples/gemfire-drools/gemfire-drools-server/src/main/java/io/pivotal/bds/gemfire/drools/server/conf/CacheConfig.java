package io.pivotal.bds.gemfire.drools.server.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.CacheFactory;
import com.gemstone.gemfire.cache.server.CacheServer;
import com.gemstone.gemfire.pdx.ReflectionBasedAutoSerializer;

@Configuration
public class CacheConfig {

    @Value("${locators:localhost[10334]}")
    private String locators;

    @Value("${cache-server.port:40404}")
    private int port;

    private static final Logger LOG = LoggerFactory.getLogger(CacheConfig.class);

    @Bean
    public Cache createCache() throws Exception {
        LOG.info("creating Cache: locators={}, port={}", locators, port);
        CacheFactory cf = new CacheFactory();
        cf.set("locators", locators);

        cf.setPdxPersistent(true);
        cf.setPdxSerializer(new ReflectionBasedAutoSerializer("io.pivotal.bds.gemfire.data.ecom.*"));

        Cache c = cf.create();

        LOG.info("creating CacheServer");
        CacheServer cs = c.addCacheServer();
        cs.setPort(port);
        cs.start();

        return c;
    }
}
