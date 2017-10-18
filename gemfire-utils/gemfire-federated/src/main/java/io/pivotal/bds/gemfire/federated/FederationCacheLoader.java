package io.pivotal.bds.gemfire.federated;

import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.CacheLoader;
import org.apache.geode.cache.CacheLoaderException;
import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.LoaderHelper;
import org.apache.geode.cache.Operation;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.Pool;
import org.apache.geode.cache.client.PoolManager;
import org.apache.geode.cache.execute.FunctionService;
import org.apache.geode.cache.execute.ResultCollector;

public class FederationCacheLoader<K, V> implements CacheLoader<K, V>, Declarable {

	private Pool pool;

	private static final Logger LOG = LoggerFactory.getLogger(FederationCacheLoader.class);

	public FederationCacheLoader() {
	}

	public FederationCacheLoader(Pool pool) {
		this.pool = pool;
	}

	@SuppressWarnings("unchecked")
	@Override
	public V load(LoaderHelper<K, V> helper) throws CacheLoaderException {
		K key = helper.getKey();

		Region<K, V> region = helper.getRegion();
		String regionName = region.getName();

		LOG.debug("load: key={}, regionName={}", key, regionName);

		Object[] args = new Object[] { Operation.GET, regionName, key };
		ResultCollector<?, ?> coll = FunctionService.onServer(pool).withArgs(args).execute(FederationFunction.class.getSimpleName());

		if (coll == null) {
			return null;
		}

		List<?> list = (List<?>) coll.getResult();

		if (list == null || list.isEmpty()) {
			return null;
		}

		if (list.size() > 1) {
			throw new IllegalArgumentException("Function returned more than one object: " + list);
		}

		V v = (V) list.get(0);
		LOG.debug("load: key={}, regionName={}, value={}", key, regionName, v);

		return v;
	}

	@Override
	public void init(Properties props) {
		String poolName = System.getProperty("gemfire.utils.federation.pool-name", "federatedPool");
		poolName = props.getProperty("poolName", poolName);
		LOG.info("init: poolName={}", poolName);
		pool = PoolManager.find(poolName);
	}

	@Override
	public void close() {
	}

}
