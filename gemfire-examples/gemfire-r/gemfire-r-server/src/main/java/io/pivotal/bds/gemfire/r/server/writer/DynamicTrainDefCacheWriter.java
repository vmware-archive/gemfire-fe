package io.pivotal.bds.gemfire.r.server.writer;

import java.util.Properties;

import com.gemstone.gemfire.cache.CacheWriterException;
import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.EntryEvent;
import com.gemstone.gemfire.cache.util.CacheWriterAdapter;

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
