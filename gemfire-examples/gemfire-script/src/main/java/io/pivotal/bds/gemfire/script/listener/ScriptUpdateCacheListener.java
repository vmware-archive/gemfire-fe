package io.pivotal.bds.gemfire.script.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.EntryEvent;
import com.gemstone.gemfire.cache.util.CacheListenerAdapter;

public class ScriptUpdateCacheListener extends CacheListenerAdapter<String, String> {
    
    private static final Logger LOG = LoggerFactory.getLogger(ScriptUpdateCacheListener.class);

    @Override
    public void afterCreate(EntryEvent<String, String> event) {
    }

    @Override
    public void afterDestroy(EntryEvent<String, String> event) {
    }

    @Override
    public void afterUpdate(EntryEvent<String, String> event) {
    }

}
