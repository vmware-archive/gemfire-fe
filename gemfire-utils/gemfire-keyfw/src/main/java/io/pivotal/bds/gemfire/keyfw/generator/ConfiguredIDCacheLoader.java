package io.pivotal.bds.gemfire.keyfw.generator;

import java.util.Properties;

import org.apache.geode.cache.CacheLoader;
import org.apache.geode.cache.CacheLoaderException;
import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.LoaderHelper;

public class ConfiguredIDCacheLoader implements CacheLoader<String, Long>, Declarable {

    private long initialId;

    @Override
    public void close() {
    }

    @Override
    public void init(Properties props) {
        String s = props.getProperty("initialId", "0");
        initialId = Long.parseLong(s);
    }

    @Override
    public Long load(LoaderHelper<String, Long> helper) throws CacheLoaderException {
        return initialId;
    }

}
