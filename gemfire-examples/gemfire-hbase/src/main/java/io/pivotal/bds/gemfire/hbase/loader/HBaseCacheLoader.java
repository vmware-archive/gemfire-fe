package io.pivotal.bds.gemfire.hbase.loader;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.CacheLoader;
import com.gemstone.gemfire.cache.CacheLoaderException;
import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.LoaderHelper;

import io.pivotal.bds.gemfire.hbase.util.HBaseHelper;
import io.pivotal.bds.metrics.timer.Timer;

public class HBaseCacheLoader<K, V> implements CacheLoader<K, V>, Declarable {

    private static final Timer timer = new Timer("HBaseCacheLoader");
    private static final Logger LOG = LoggerFactory.getLogger(HBaseCacheLoader.class);

    public HBaseCacheLoader() {
    }

    @Override
    public V load(LoaderHelper<K, V> helper) throws CacheLoaderException {
        K key = helper.getKey();

        String regionName = helper.getRegion().getName();
        LOG.debug("load: key={}, regionName={}", key, regionName);

        try {
            timer.start();
            V value = HBaseHelper.retrieve(key, regionName);
            timer.end();

            LOG.debug("load: pkey={}, regionName={}, value={}", key, regionName, value);
            return value;
        } catch (Exception x) {
            LOG.error(x.toString(), x);
            throw new CacheLoaderException(x.toString(), x);
        }
    }

    @Override
    public void close() {
    }

    @Override
    public void init(Properties props) {
    }
}
