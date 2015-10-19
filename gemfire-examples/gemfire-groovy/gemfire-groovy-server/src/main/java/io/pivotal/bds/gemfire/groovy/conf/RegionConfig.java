package io.pivotal.bds.gemfire.groovy.conf;

import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

import javax.annotation.Resource;

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

import io.pivotal.bds.gemfire.groovy.listener.ScriptCacheListener;

@Configuration
public class RegionConfig {

    @Resource(name = "connectionRegion")
    private Region<URL, URLConnection> connectionRegion;

    private static final Logger LOG = LoggerFactory.getLogger(RegionConfig.class);

    @Bean(name = "scriptRegion")
    @DependsOn("connectionRegion")
    public Region<String, String> createScriptRegion(Cache cache, URLStreamHandler handler) {
        LOG.info("creating script Region");
        
        Assert.notNull(handler, "handler is null");
        Assert.notNull(connectionRegion, "connectionRegion is null");
        
        RegionFactory<String, String> rf = cache.createRegionFactory(RegionShortcut.REPLICATE);
        rf.addCacheListener(new ScriptCacheListener(handler, connectionRegion));
        
        return rf.create("script");
    }

    @Bean(name = "dataRegion")
    public Region<String, String> createDataRegion(Cache cache) {
        LOG.info("creating data Region");
        RegionFactory<String, String> rf = cache.createRegionFactory(RegionShortcut.PARTITION);
        return rf.create("data");
    }
}
