package io.pivotal.bds.gemfire.complexobjs.client.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.Pool;
import org.apache.geode.pdx.ReflectionBasedAutoSerializer;

@Configuration
public class CacheConfig {

	@Autowired
	private PropertyConfig propertyConfig;

	private static final Logger LOG = LoggerFactory.getLogger(CacheConfig.class);

	@Bean
	public ClientCache createCache() {
		LOG.info("creating cache");
		ClientCacheFactory ccf = new ClientCacheFactory();

		String locators = propertyConfig.locators;

		String[] sa1 = locators.split(",");
		for (String st : sa1) {
			String[] sat = st.split(":");

			String host = sat[0];
			int port = sat.length > 1 ? Integer.parseInt(sat[1]) : 10334;
			LOG.info("creating cache: adding locator: host={}, port={}", host, port);

			ccf.addPoolLocator(host, port);
		}

		ccf.setPdxSerializer(new ReflectionBasedAutoSerializer("io.pivotal.bds.gemfire.complexobjs.common.*"));
		ccf.setPdxReadSerialized(false);

		return ccf.create();
	}

	@Bean
	public Pool createPool(ClientCache cache) {
		LOG.info("creating pool");
		return cache.getDefaultPool();
	}
}
