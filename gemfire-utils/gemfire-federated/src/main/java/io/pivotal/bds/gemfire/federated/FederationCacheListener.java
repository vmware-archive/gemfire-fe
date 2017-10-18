package io.pivotal.bds.gemfire.federated;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.EntryEvent;
import org.apache.geode.cache.Operation;
import org.apache.geode.cache.client.Pool;
import org.apache.geode.cache.client.PoolManager;
import org.apache.geode.cache.execute.FunctionService;
import org.apache.geode.cache.execute.ResultCollector;
import org.apache.geode.cache.util.CacheListenerAdapter;

public class FederationCacheListener<K, V> extends CacheListenerAdapter<K, V>implements Declarable {

	private Pool pool;

	private static final Logger LOG = LoggerFactory.getLogger(FederationCacheListener.class);

	public FederationCacheListener() {
	}

	public FederationCacheListener(Pool pool) {
		this.pool = pool;
	}

	@Override
	public void afterCreate(EntryEvent<K, V> event) {
		K key = event.getKey();
		V value = event.getNewValue();
		String regionName = event.getRegion().getName();
		LOG.debug("afterCreate: key={}, value={}, regionName={}", key, value, regionName);

		Object[] args = new Object[] { Operation.CREATE, regionName, key, value };
		execute(args);
	}

	@Override
	public void afterDestroy(EntryEvent<K, V> event) {
		K key = event.getKey();
		String regionName = event.getRegion().getName();
		LOG.debug("afterDestroy: key={}, regionName={}", key, regionName);

		Object[] args = new Object[] { Operation.DESTROY, regionName, key };
		execute(args);
	}

	@Override
	public void afterUpdate(EntryEvent<K, V> event) {
		K key = event.getKey();
		V value = event.getNewValue();
		String regionName = event.getRegion().getName();
		LOG.debug("afterUpdate: key={}, value={}, regionName={}", key, value, regionName);

		Object[] args = new Object[] { Operation.UPDATE, regionName, key, value };
		execute(args);
	}

	private void execute(Object[] args) {
		ResultCollector<?, ?> coll = FunctionService.onServer(pool).withArgs(args)
				.execute(FederationFunction.class.getSimpleName());
		coll.getResult();
	}

	@Override
	public void init(Properties props) {
		String poolName = System.getProperty("gemfire.utils.federation.pool-name", "federatedPool");
		poolName = props.getProperty("poolName", poolName);
		LOG.info("init: poolName={}", poolName);
		pool = PoolManager.find(poolName);
	}

}
