package io.pivotal.bds.gemfire.geojson.conf;

import org.apache.geode.cache.Cache;
import org.apache.geode.cache.CacheFactory;
import org.apache.geode.cache.control.ResourceManager;
import org.apache.geode.cache.server.CacheServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {

    private static final Logger LOG = LoggerFactory.getLogger(CacheConfig.class);

    @Bean
    public Cache createCache(PropertyConfig props) throws Exception {

        String locators = props.locators;
        int port = props.port;
        LOG.info("creating Cache: locators={}, port={}", locators, port);

        CacheFactory cf = new CacheFactory();
        cf.set("locators", locators);
        
        cf.setPdxPersistent(true);
        cf.setPdxReadSerialized(true);

        Cache c = cf.create();

        ResourceManager rm = c.getResourceManager();
        rm.setEvictionHeapPercentage((float) 70.0);
        rm.setCriticalHeapPercentage((float) 80.0);

        LOG.info("creating CacheServer");
        CacheServer cs = c.addCacheServer();
        cs.setPort(port);
        cs.start();

        return c;
    }
}
