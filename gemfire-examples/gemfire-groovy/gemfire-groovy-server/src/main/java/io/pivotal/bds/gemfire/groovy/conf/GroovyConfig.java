package io.pivotal.bds.gemfire.groovy.conf;

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
import io.pivotal.bds.gemfire.groovy.function.ScriptExecutionFunction;
import io.pivotal.bds.gemfire.groovy.util.GemfireURLStreamHandler;

@Configuration("GroovyConfig")
public class GroovyConfig {

    @Resource(name = "connectionRegion")
    private Region<URL, URLConnection> connectionRegion;

    @Autowired
    private GroovyScriptEngine engine;

    private static final Logger LOG = LoggerFactory.getLogger(GroovyConfig.class);

    @Bean(name = "connectionRegion")
    public Region<URL, URLConnection> createConnectionRegion(Cache cache) {
        LOG.info("creating connection Region");
        RegionFactory<URL, URLConnection> rf = cache.createRegionFactory(RegionShortcut.LOCAL);
        return rf.create("connection");
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
        URL url = new URL(null, "gf:/", handler);
        URL[] urls = { url };
        return new GroovyScriptEngine(urls);
    }

    @PostConstruct
    public void post() {
        LOG.info("registering ScriptExecutionFunction");
        FunctionService.registerFunction(new ScriptExecutionFunction(engine));
    }
}
