package io.pivotal.bds.gemfire.pmml.server.conf;

import org.apache.geode.cache.Cache;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.RegionFactory;
import org.apache.geode.cache.RegionShortcut;
import org.dmg.pmml.PMML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.pivotal.bds.gemfire.pmml.common.data.EvaluatorParams;
import io.pivotal.bds.gemfire.pmml.common.data.EvaluatorResults;
import io.pivotal.bds.gemfire.pmml.common.data.Model;
import io.pivotal.bds.gemfire.pmml.common.keys.EvalKey;
import io.pivotal.bds.gemfire.pmml.common.keys.ModelKey;
import io.pivotal.bds.gemfire.pmml.server.listener.EvaluatorCacheListener;
import io.pivotal.bds.gemfire.pmml.server.listener.ModelCacheListener;

@Configuration
public class RegionConfig {

    private static final Logger LOG = LoggerFactory.getLogger(RegionConfig.class);

    @Bean
    public Region<ModelKey, PMML> pmmlRegion(Cache cache) {
        LOG.info("pmmlRegion");
        RegionFactory<ModelKey, PMML> rf = cache.createRegionFactory(RegionShortcut.LOCAL);
        Region<ModelKey, PMML> r = rf.create("pmml");
        return r;
    }

    @Bean
    public Region<ModelKey, Model> modelRegion(Cache cache, Region<ModelKey, PMML> pmmlRegion, ModelCacheListener listener) {
        LOG.info("modelRegion");

        RegionFactory<ModelKey, Model> rf = cache.createRegionFactory(RegionShortcut.REPLICATE_PERSISTENT);
        rf.addCacheListener(listener);

        return rf.create("model");
    }
    
    @Bean
    public Region<EvalKey, EvaluatorParams> paramsRegion(Cache cache, EvaluatorCacheListener evaluatorCacheListener) {
        LOG.info("paramsRegion");
        
        RegionFactory<EvalKey, EvaluatorParams> rf = cache.createRegionFactory(RegionShortcut.PARTITION_PERSISTENT_OVERFLOW);
        rf.addCacheListener(evaluatorCacheListener);
        
        return rf.create("params");
    }
    
    @Bean
    public Region<EvalKey, EvaluatorResults> resultsRegion(Cache cache) {
        LOG.info("resultsRegion");
        
        RegionFactory<EvalKey, EvaluatorResults> rf = cache.createRegionFactory(RegionShortcut.PARTITION_PERSISTENT_OVERFLOW);
        
        return rf.create("eval");
    }
}
