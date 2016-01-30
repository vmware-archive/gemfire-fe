package io.pivotal.bds.gemfire.pmml.server.conf;

import javax.annotation.Resource;

import org.dmg.pmml.PMML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.util.Assert;

import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.RegionFactory;
import com.gemstone.gemfire.cache.RegionShortcut;

import io.pivotal.bds.gemfire.pmml.common.data.Model;
import io.pivotal.bds.gemfire.pmml.common.data.ModelKey;
import io.pivotal.bds.gemfire.pmml.server.listener.ModelCacheListener;

@Configuration
public class RegionConfig {

    @Resource(name = "PMMLRegionBean")
    private Region<ModelKey, PMML> pmmlRegion;

    private static final Logger LOG = LoggerFactory.getLogger(RegionConfig.class);

    @Bean(name = "PMMLRegionBean")
    public Region<ModelKey, PMML> createPMMLRegion(Cache cache) {
        LOG.info("creating PMMLRegionBean");
        RegionFactory<ModelKey, PMML> rf = cache.createRegionFactory(RegionShortcut.LOCAL);
        Region<ModelKey, PMML> r = rf.create("PMML");
        return r;
    }

    @Bean(name = "ModelRegionBean")
    @DependsOn("PMMLRegionBean")
    public Region<ModelKey, Model> createModelRegion(Cache cache) {
        LOG.info("creating ModelRegionBean");

        Assert.notNull(pmmlRegion, "PMMLRegionBean is null");

        RegionFactory<ModelKey, Model> rf = cache.createRegionFactory(RegionShortcut.REPLICATE_PERSISTENT);
        ModelCacheListener listener = new ModelCacheListener(pmmlRegion);
        rf.addCacheListener(listener);

        Region<ModelKey, Model> r = rf.create("Model");
        return r;
    }
}
