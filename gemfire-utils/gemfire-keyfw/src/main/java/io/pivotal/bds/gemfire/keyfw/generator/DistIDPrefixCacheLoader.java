package io.pivotal.bds.gemfire.keyfw.generator;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.CacheFactory;
import com.gemstone.gemfire.cache.CacheLoader;
import com.gemstone.gemfire.cache.CacheLoaderException;
import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.LoaderHelper;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.distributed.DistributedSystem;

public class DistIDPrefixCacheLoader implements CacheLoader<Integer, Long>, Declarable {

    private IDGenerator<Integer> idGenerator;
    private static final Logger LOG = LoggerFactory.getLogger(DistIDPrefixCacheLoader.class);

    @Override
    public void close() {
    }

    @Override
    public void init(Properties props) {
    }

    @Override
    public Long load(LoaderHelper<Integer, Long> helper) throws CacheLoaderException {
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
