package io.pivotal.bds.gemfire.keyfw.generator;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.CacheLoader;
import com.gemstone.gemfire.cache.CacheLoaderException;
import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.LoaderHelper;

public class DistIDPrefixCacheLoader implements CacheLoader<Integer, Long>, Declarable {
	
	private static final Logger LOG = LoggerFactory.getLogger(DistIDPrefixCacheLoader.class);

	@Override
	public void close() {
	}

	@Override
	public void init(Properties props) {
	}

	@Override
	public Long load(LoaderHelper<Integer, Long> helper) throws CacheLoaderException {
		LOG.info("returning 0");
		return 0L;
	}

}
