package io.pivotal.bds.gemfire.r.server.writer;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.CacheWriterException;
import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.EntryEvent;
import com.gemstone.gemfire.cache.util.CacheWriterAdapter;

import io.pivotal.bds.gemfire.r.common.PMMLPredictDef;
import io.pivotal.bds.gemfire.r.common.PMMLPredictDefKey;
import io.pivotal.bds.gemfire.r.server.util.Handler;
import io.pivotal.bds.gemfire.r.server.util.PMMLHandler;

public class PMMLPredictDefCacheWriter extends CacheWriterAdapter<PMMLPredictDefKey, PMMLPredictDef>implements Declarable {

    private static final Logger LOG = LoggerFactory.getLogger(PMMLPredictDefCacheWriter.class);

    @Override
    public void beforeCreate(EntryEvent<PMMLPredictDefKey, PMMLPredictDef> event) throws CacheWriterException {
        LOG.debug("beforeCreate: event={}", event);
        PMMLPredictDefKey key = event.getKey();
        PMMLPredictDef def = event.getNewValue();
        new PMMLHandler(key, def);
    }

    @Override
    public void beforeUpdate(EntryEvent<PMMLPredictDefKey, PMMLPredictDef> event) throws CacheWriterException {
        LOG.debug("beforeUpdate: event={}", event);
        PMMLPredictDefKey key = event.getKey();
        PMMLPredictDef oldDef = event.getOldValue();
        PMMLPredictDef newDef = event.getNewValue();
        Handler.removeHandler(key, oldDef.getRegionName());
        new PMMLHandler(key, newDef);
    }

    @Override
    public void beforeDestroy(EntryEvent<PMMLPredictDefKey, PMMLPredictDef> event) throws CacheWriterException {
        LOG.debug("beforeDestroy: event={}", event);
        PMMLPredictDefKey key = event.getKey();
        PMMLPredictDef def = event.getOldValue();
        Handler.removeHandler(key, def.getRegionName());
    }

    @Override
    public void init(Properties props) {
    }

}
