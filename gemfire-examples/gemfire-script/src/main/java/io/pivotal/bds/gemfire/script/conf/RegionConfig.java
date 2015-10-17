package io.pivotal.bds.gemfire.script.conf;

import javax.annotation.Resource;
import javax.script.ScriptEngine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.RegionFactory;
import com.gemstone.gemfire.cache.RegionShortcut;
import com.gemstone.gemfire.cache.execute.FunctionService;

import io.pivotal.bds.gemfire.script.function.ScriptExecutionFunction;

@Configuration
public class RegionConfig {

    @Autowired
    private ScriptEngine engine;

    @Resource(name = "ScriptRegionBean")
    private Region<String, String> scriptRegion;

    @Resource(name = "DataRegionBean")
    private Region<String, String> dataRegion;

    private static final Logger LOG = LoggerFactory.getLogger(RegionConfig.class);

    @Bean(name = "ScriptRegionBean")
    public Region<String, String> createScriptRegion(Cache cache) {
        LOG.info("creating Script region");
        RegionFactory<String, String> rf = cache.createRegionFactory(RegionShortcut.REPLICATE);
        return rf.create("Script");
    }

    @Bean(name = "DataRegionBean")
    public Region<String, String> createDataRegion(Cache cache) {
        LOG.info("creating Data region");
        RegionFactory<String, String> rf = cache.createRegionFactory(RegionShortcut.PARTITION);
        return rf.create("Data");
    }

    @Bean
    public ScriptExecutionFunction createFunction() {
        LOG.info("creating and registering ScriptExecutionFunction");
        ScriptExecutionFunction f = new ScriptExecutionFunction(scriptRegion, engine);
        FunctionService.registerFunction(f);
        return f;
    }
}
