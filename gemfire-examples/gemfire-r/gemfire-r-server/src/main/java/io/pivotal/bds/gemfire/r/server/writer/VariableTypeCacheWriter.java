package io.pivotal.bds.gemfire.r.server.writer;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import org.apache.geode.cache.CacheWriterException;
import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.EntryEvent;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.util.CacheWriterAdapter;

import io.pivotal.bds.gemfire.r.common.VariableType;
import io.pivotal.bds.gemfire.util.RegionHelper;

public class VariableTypeCacheWriter<K, V> extends CacheWriterAdapter<K, V>implements Declarable {

    private VariableType type;

    private static final Logger LOG = LoggerFactory.getLogger(VariableTypeCacheWriter.class);

    @Override
    public void beforeCreate(EntryEvent<K, V> event) throws CacheWriterException {
        K key = event.getKey();
        LOG.debug("afterCreate: key={}, type={}", key, type);
        Region<K, VariableType> r = RegionHelper.getRegion("variableType");
        if (r.putIfAbsent(key, type) != null) {
            throw new IllegalArgumentException("Variable " + key + " already exists");
        }
    }

    @Override
    public void beforeUpdate(EntryEvent<K, V> event) throws CacheWriterException {
        K key = event.getKey();
        LOG.debug("afterDestroy: key={}, type={}", key, type);
        Region<K, VariableType> r = RegionHelper.getRegion("variableType");
        r.remove(key);
    }

    @Override
    public void init(Properties props) {
        String s = props.getProperty("variableType");
        LOG.info("init: s={}", s);
        Assert.hasText(s, "Missing property 'variableType'");
        type = VariableType.valueOf(s);
    }

}
