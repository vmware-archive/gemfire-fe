package io.pivotal.bds.gemfire.spring.boot.conf;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.Pool;

import io.pivotal.spring.cloud.service.gemfire.GemfireServiceConnectorConfig;

@Configuration
public class CacheConfig {

    @Resource(name = "cache")
    private ClientCache cache;

    private static final Logger LOG = LoggerFactory.getLogger(CacheConfig.class);

    @Bean(name = "cache")
    public ClientCache createCache() throws Exception {
        LOG.info("creating cache");

        Map<String, String> env = System.getenv();
        LOG.info("env={}", env);

        GemfireServiceConnectorConfig gemfireConfig = new GemfireServiceConnectorConfig();
        gemfireConfig.setPdxReadSerialized(false);
        CloudFactory cloudFactory = new CloudFactory();
        Cloud cloud = cloudFactory.getCloud();
        cache = cloud.getServiceConnector("gemfire_dev", ClientCache.class, gemfireConfig);
        return cache;
    }

    @Bean
    public Pool createPool() {
        LOG.info("creating pool");
        return cache.getDefaultPool();
    }
}
