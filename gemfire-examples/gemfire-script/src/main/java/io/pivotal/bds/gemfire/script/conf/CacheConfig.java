package io.pivotal.bds.gemfire.script.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.CacheFactory;
import com.gemstone.gemfire.cache.server.CacheServer;
import com.gemstone.gemfire.pdx.ReflectionBasedAutoSerializer;

@Configuration
public class CacheConfig {

    private static final Logger LOG = LoggerFactory.getLogger(CacheConfig.class);

    @Bean
    public Cache createCache() throws Exception {
        LOG.info("creating Cache");
        CacheFactory cf = new CacheFactory();
        cf.set("locators", "localhost[10334]");

        cf.setPdxPersistent(true);
        cf.setPdxSerializer(new ReflectionBasedAutoSerializer("io.pivotal.bds.gemfire.drools.data.*"));

        Cache c = cf.create();

        LOG.info("creating CacheServer");
        CacheServer cs = c.addCacheServer();
        cs.setPort(40404);
        cs.start();

        return c;
    }
}
