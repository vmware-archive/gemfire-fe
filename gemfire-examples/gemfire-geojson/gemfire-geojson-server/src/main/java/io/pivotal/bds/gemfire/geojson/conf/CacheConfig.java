package io.pivotal.bds.gemfire.geojson.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.CacheFactory;
import com.gemstone.gemfire.cache.control.ResourceManager;
import com.gemstone.gemfire.cache.server.CacheServer;

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
        
        Cache c = cf.create();
        
        ResourceManager rm = c.getResourceManager();
        rm.setEvictionHeapPercentage((float)0.70);
        rm.setCriticalHeapPercentage((float)0.80);
        
        LOG.info("creating CacheServer");
        CacheServer cs = c.addCacheServer();
        cs.setPort(port);
        cs.start();

        return c;
    }
}
