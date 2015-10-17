package io.pivotal.bds.gemfire.spark;

import java.io.Serializable;

import org.apache.spark.storage.StorageLevel;
import org.apache.spark.streaming.receiver.Receiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.CacheFactory;
import com.gemstone.gemfire.cache.EntryEvent;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.util.CacheListenerAdapter;

public class GemfireReceiver<K, V> extends Receiver<V> {

	private String regionName;
	private final Listener listener = new Listener();

	private static final Logger LOG = LoggerFactory.getLogger(GemfireReceiver.class);

	private static final long serialVersionUID = 1L;

	public GemfireReceiver(StorageLevel storageLevel, String regionName) {
		super(storageLevel);
		this.regionName = regionName;
	}

	@Override
	public void onStart() {
		LOG.info("Starting...");
		getRegion().getAttributesMutator().addCacheListener(listener);
	}

	@Override
	public void onStop() {
		LOG.info("Stopping...");
		getRegion().getAttributesMutator().removeCacheListener(listener);
	}

	private void store(EntryEvent<K, V> event) {
		V v = event.getNewValue();
		LOG.debug("storing: v={}", v);
		store(v);
	}

	private Region<K, V> getRegion() {
		Cache c = CacheFactory.getAnyInstance();
		return c.getRegion(regionName);
	}

	private class Listener extends CacheListenerAdapter<K, V>implements Serializable {

		private static final long serialVersionUID = 1L;

		@Override
		public void afterCreate(EntryEvent<K, V> event) {
			LOG.debug("afterCreate: event={}", event);
			store(event);
		}

		@Override
		public void afterUpdate(EntryEvent<K, V> event) {
			LOG.debug("afterUpdate: event={}", event);
			store(event);
		}
	}
}
