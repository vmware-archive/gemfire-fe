package io.pivotal.bds.gemfire.complexobjs.server.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.CacheFactory;
import com.gemstone.gemfire.cache.server.CacheServer;
import com.gemstone.gemfire.pdx.ReflectionBasedAutoSerializer;

@Configuration
public class CacheConfig {

	@Autowired
	private PropertyConfig propertyConfig;

	private static final Logger LOG = LoggerFactory.getLogger(CacheConfig.class);

	@Bean
	public Cache createCache() throws Exception {
		LOG.info("creating Cache");
		CacheFactory cf = new CacheFactory();

		String locators = propertyConfig.locators;
		LOG.info("creating Cache, locators={}", locators);
		cf.set("locators", locators);

		cf.setPdxSerializer(new ReflectionBasedAutoSerializer("io.pivotal.bds.gemfire.complexobjs.common.*"));
		cf.setPdxReadSerialized(false);
		cf.setPdxPersistent(true);
		
		Cache c = cf.create();
		
		LOG.info("creating CacheServer");
		CacheServer cs = c.addCacheServer();
		cs.setPort(40404);
		cs.start();
		
		return c;
	}
	
}
