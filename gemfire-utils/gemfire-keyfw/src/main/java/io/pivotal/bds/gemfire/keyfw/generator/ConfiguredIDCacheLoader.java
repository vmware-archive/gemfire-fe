package io.pivotal.bds.gemfire.keyfw.generator;

import java.util.Properties;

import com.gemstone.gemfire.cache.CacheLoader;
import com.gemstone.gemfire.cache.CacheLoaderException;
import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.LoaderHelper;

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
