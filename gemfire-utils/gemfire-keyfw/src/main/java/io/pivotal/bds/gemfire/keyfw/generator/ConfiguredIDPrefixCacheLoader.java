package io.pivotal.bds.gemfire.keyfw.generator;

import java.util.Properties;

import com.gemstone.gemfire.cache.CacheLoader;
import com.gemstone.gemfire.cache.CacheLoaderException;
import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.LoaderHelper;

public class ConfiguredIDPrefixCacheLoader implements CacheLoader<String, Long>, Declarable {

    private long prefix = 0L;

    public ConfiguredIDPrefixCacheLoader() {
    }

    public ConfiguredIDPrefixCacheLoader(long prefix) {
        this.prefix = prefix << 48;
    }

    public long getPrefix() {
        return prefix >> 48;
    }

    public void setPrefix(long prefix) {
        this.prefix = prefix << 48;
    }

    @Override
    public void init(Properties props) {
        String s = System.getProperty("prefix", Long.toString(prefix));
        s = props.getProperty("keyfw.idgen.prefix", s);
        prefix = Long.parseLong(s) << 48;
    }

    @Override
    public void close() {
    }

    @Override
    public Long load(LoaderHelper<String, Long> helper) throws CacheLoaderException {
        return prefix;
    }

}
