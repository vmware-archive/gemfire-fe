package io.pivotal.bds.gemfire.spring.boot.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientRegionFactory;
import com.gemstone.gemfire.cache.client.ClientRegionShortcut;
import com.gemstone.gemfire.cache.client.Pool;
import com.gemstone.gemfire.pdx.PdxInstance;

@Configuration
public class RegionConfig {

    private static final Logger LOG = LoggerFactory.getLogger(RegionConfig.class);

    @Bean(name = "paymentRegion")
    public Region<PdxInstance, PdxInstance> allocationRegion(ClientCache cache, Pool pool) {
        LOG.info("creating paymentRegion");
        
        ClientRegionFactory<PdxInstance, PdxInstance> crf = cache.createClientRegionFactory(ClientRegionShortcut.PROXY);
        crf.setPoolName(pool.getName());
        
        Region<PdxInstance, PdxInstance> r = crf.create("payment");
        return r;
    }
}
