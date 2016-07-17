package io.pivotal.bds.gemfire.keyfw.generator;

import java.util.Properties;

import com.gemstone.gemfire.cache.CacheLoader;
import com.gemstone.gemfire.cache.CacheLoaderException;
import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.LoaderHelper;

public class ConfiguredIntegerIDCacheLoader implements CacheLoader<String, Integer>, Declarable {

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
    public Integer load(LoaderHelper<String, Integer> helper) throws CacheLoaderException {
        return initialId;
    }

}
