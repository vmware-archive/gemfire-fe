package io.pivotal.bds.gemfire.groovy.server.conf;

import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.RegionFactory;
import com.gemstone.gemfire.cache.RegionShortcut;
import com.gemstone.gemfire.cache.execute.FunctionService;

import groovy.util.GroovyScriptEngine;
import io.pivotal.bds.gemfire.groovy.common.Constants;
import io.pivotal.bds.gemfire.groovy.server.function.ScriptExecutionFunction;
import io.pivotal.bds.gemfire.groovy.server.listener.ScriptCacheListener;
import io.pivotal.bds.gemfire.groovy.server.util.GemfireURLStreamHandler;

@Configuration("groovyConfig")
public class GroovyConfig implements Constants {

    @Resource(name = CONNECTION_REGION_BEAN_NAME)
    private Region<URL, URLConnection> connectionRegion;

    @Resource(name = SCRIPT_REGION_BEAN_NAME)
    private Region<String, String> scriptRegion;

    @Autowired
    private ScriptExecutionFunction function;

    private static final Logger LOG = LoggerFactory.getLogger(GroovyConfig.class);

    @Bean(name = CONNECTION_REGION_BEAN_NAME)
    public Region<URL, URLConnection> createConnectionRegion(Cache cache) {
        LOG.info("creating {}", CONNECTION_REGION_BEAN_NAME);
        RegionFactory<URL, URLConnection> rf = cache.createRegionFactory(RegionShortcut.LOCAL);
        return rf.create(CONNECTION_REGION_NAME);
    }

    @Bean(name = SCRIPT_REGION_BEAN_NAME)
    public Region<String, String> createScriptRegion(Cache cache, URLStreamHandler handler) {
        LOG.info("creating {}", SCRIPT_REGION_BEAN_NAME);

        Assert.notNull(handler, "handler is null");
        Assert.notNull(connectionRegion, "connectionRegion is null");

        RegionFactory<String, String> rf = cache.createRegionFactory(RegionShortcut.REPLICATE_PERSISTENT);
        rf.addCacheListener(new ScriptCacheListener(handler, connectionRegion));

        return rf.create(SCRIPT_REGION_NAME);
    }

    @Bean
    public URLStreamHandler createGemfireURLStreamHandler() {
        LOG.info("createGemfireURLStreamHandler");
        Assert.notNull(connectionRegion, "connectionRegion is null");
        return new GemfireURLStreamHandler(connectionRegion);
    }

    @Bean
    public GroovyScriptEngine createGroovyScriptEngine(URLStreamHandler handler) throws Exception {
        LOG.info("createGroovyScriptEngine");
        Assert.notNull(handler, "handler is null");
        
        URL url = new URL(null, "gf:/", handler);
        URL[] urls = { url };
        
        return new GroovyScriptEngine(urls);
    }

    @Bean
    public ScriptExecutionFunction createScriptExecutionFunction(GroovyScriptEngine engine) {
        LOG.info("createGroovyScriptEngine");
        Assert.notNull(engine, "engine is null");
        return new ScriptExecutionFunction(engine);
    }

    @PostConstruct
    public void post() {
        LOG.info("registering ScriptExecutionFunction");
        Assert.notNull(function, "function is null");
        FunctionService.registerFunction(function);
    }
}
