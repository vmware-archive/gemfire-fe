package io.pivotal.bds.gemfire.keyfw.generator;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.Cache;
import org.apache.geode.cache.CacheFactory;
import org.apache.geode.cache.CacheLoader;
import org.apache.geode.cache.CacheLoaderException;
import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.LoaderHelper;
import org.apache.geode.cache.Region;
import org.apache.geode.distributed.DistributedSystem;

public class DistIDPrefixCacheLoader<K> implements CacheLoader<K, Long>, Declarable {

    private IDGenerator<Integer> idGenerator;
    private static final Logger LOG = LoggerFactory.getLogger(DistIDPrefixCacheLoader.class);

    @Override
    public void close() {
    }

    @Override
    public void init(Properties props) {
    }

    @Override
    public Long load(LoaderHelper<K, Long> helper) throws CacheLoaderException {
        long id = getIDGenerator().generate("prefix");
        long prefix = id << 56;
        LOG.trace("load: id={}, prefix={}", id, prefix);
        return prefix;
    }

    private synchronized IDGenerator<Integer> getIDGenerator() {
        if (idGenerator == null) {
            LOG.info("getIDGenerator");
            Cache cache = CacheFactory.getAnyInstance();
            Region<String, Integer> r = cache.getRegion("prefix");
            DistributedSystem ds = cache.getDistributedSystem();
            idGenerator = new ReplicateLockingIntegerIDGenerator(r, ds);
        }

        return idGenerator;
    }
}
