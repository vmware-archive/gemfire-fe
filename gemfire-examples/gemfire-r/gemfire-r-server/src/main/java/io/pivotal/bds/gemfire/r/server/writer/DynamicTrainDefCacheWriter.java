package io.pivotal.bds.gemfire.r.server.writer;

import java.util.Properties;

import org.apache.geode.cache.CacheWriterException;
import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.EntryEvent;
import org.apache.geode.cache.util.CacheWriterAdapter;

import io.pivotal.bds.gemfire.r.common.DynamicTrainDef;
import io.pivotal.bds.gemfire.r.common.DynamicTrainDefKey;
import io.pivotal.bds.gemfire.r.server.util.DynamicTrainHandler;

public class DynamicTrainDefCacheWriter extends CacheWriterAdapter<DynamicTrainDefKey, DynamicTrainDef>implements Declarable {

    @Override
    public void beforeCreate(EntryEvent<DynamicTrainDefKey, DynamicTrainDef> event) throws CacheWriterException {
        createTrainDef(event);
    }

    @Override
    public void beforeUpdate(EntryEvent<DynamicTrainDefKey, DynamicTrainDef> event) throws CacheWriterException {
        createTrainDef(event);
    }

    @Override
    public void beforeDestroy(EntryEvent<DynamicTrainDefKey, DynamicTrainDef> event) throws CacheWriterException {
    }

    @Override
    public void init(Properties props) {
    }

    private void createTrainDef(EntryEvent<DynamicTrainDefKey, DynamicTrainDef> event) throws CacheWriterException {
        DynamicTrainDefKey key = event.getKey();
        DynamicTrainDef def = event.getNewValue();
        new DynamicTrainHandler(key, def);
    }
}
