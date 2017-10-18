package io.pivotal.bds.gemfire.keyfw.generator;

import java.util.Properties;

import org.apache.geode.cache.CacheLoader;
import org.apache.geode.cache.CacheLoaderException;
import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.LoaderHelper;

public class ConfiguredIntegerIDCacheLoader<K> implements CacheLoader<K, Integer>, Declarable {

    private int initialId;

    @Override
    public void close() {
    }

    @Override
    public void init(Properties props) {
        String s = props.getProperty("initialId", "0");
        initialId = Integer.parseInt(s);
    }

    @Override
    public Integer load(LoaderHelper<K, Integer> helper) throws CacheLoaderException {
        return initialId;
    }

}
