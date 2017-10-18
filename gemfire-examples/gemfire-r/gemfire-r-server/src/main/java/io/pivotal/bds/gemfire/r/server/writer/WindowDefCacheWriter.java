package io.pivotal.bds.gemfire.r.server.writer;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.CacheWriterException;
import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.EntryEvent;
import org.apache.geode.cache.util.CacheWriterAdapter;

import io.pivotal.bds.gemfire.r.common.WindowDef;
import io.pivotal.bds.gemfire.r.common.WindowKey;
import io.pivotal.bds.gemfire.r.server.util.Handler;
import io.pivotal.bds.gemfire.r.server.util.WindowHandler;

public class WindowDefCacheWriter extends CacheWriterAdapter<WindowKey, WindowDef>implements Declarable {

    private static final Logger LOG = LoggerFactory.getLogger(WindowDefCacheWriter.class);

    @Override
    public void beforeCreate(EntryEvent<WindowKey, WindowDef> event) throws CacheWriterException {
        LOG.debug("beforeCreate: event={}", event);
        createWindow(event);
    }

    @Override
    public void beforeUpdate(EntryEvent<WindowKey, WindowDef> event) throws CacheWriterException {
        LOG.debug("beforeUpdate: event={}", event);
        createWindow(event);
    }

    @Override
    public void beforeDestroy(EntryEvent<WindowKey, WindowDef> event) throws CacheWriterException {
        LOG.debug("beforeDestroy: event={}", event);
        WindowKey key = event.getKey();
        WindowDef def = event.getOldValue();
        Handler.removeHandler(key, def.getRegionName());
    }

    @Override
    public void init(Properties props) {
    }

    private void createWindow(EntryEvent<WindowKey, WindowDef> event) throws CacheWriterException {
        WindowKey key = event.getKey();
        WindowDef def = event.getNewValue();

        WindowHandler handler = new WindowHandler(key, def);
        LOG.debug("createWindow: handler={}", handler);
    }
}
