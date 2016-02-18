package io.pivotal.bds.gemfire.r.server.listener;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.EntryEvent;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.util.CacheListenerAdapter;

import io.pivotal.bds.gemfire.r.common.VariableType;
import io.pivotal.bds.gemfire.util.RegionHelper;

public class VariableTypeCacheListener<K, V> extends CacheListenerAdapter<K, V>implements Declarable {

    private VariableType type;

    private static final Logger LOG = LoggerFactory.getLogger(VariableTypeCacheListener.class);

    @Override
    public void afterCreate(EntryEvent<K, V> event) {
        K key = event.getKey();
        LOG.debug("afterCreate: key={}, type={}", key, type);
        Region<K, VariableType> r = RegionHelper.getRegion("variableType");
        if (r.putIfAbsent(key, type) != null) {
            throw new IllegalArgumentException("Variable " + key + " already exists");
        }
    }

    @Override
    public void afterDestroy(EntryEvent<K, V> event) {
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
