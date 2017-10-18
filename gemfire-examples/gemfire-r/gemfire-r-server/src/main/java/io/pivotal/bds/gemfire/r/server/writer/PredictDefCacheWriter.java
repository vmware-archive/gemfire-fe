package io.pivotal.bds.gemfire.r.server.writer;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.CacheFactory;
import org.apache.geode.cache.CacheWriterException;
import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.EntryEvent;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.util.CacheWriterAdapter;

import io.pivotal.bds.gemfire.ml.Model;
import io.pivotal.bds.gemfire.ml.ModelType;
import io.pivotal.bds.gemfire.ml.classification.ClassificationModel;
import io.pivotal.bds.gemfire.ml.regression.RegressionModel;
import io.pivotal.bds.gemfire.r.common.PredictDef;
import io.pivotal.bds.gemfire.r.common.PredictDefKey;
import io.pivotal.bds.gemfire.r.common.ModelKey;
import io.pivotal.bds.gemfire.r.common.VariableType;
import io.pivotal.bds.gemfire.r.server.util.ClassificationPredictHandler;
import io.pivotal.bds.gemfire.r.server.util.Handler;
import io.pivotal.bds.gemfire.r.server.util.RegressionPredictHandler;
import io.pivotal.bds.gemfire.r.server.util.Utils;

public class PredictDefCacheWriter extends CacheWriterAdapter<PredictDefKey, PredictDef>implements Declarable {

    private Region<ModelKey, Model<?, ?, ?, ?>> modelRegion;

    private static final Logger LOG = LoggerFactory.getLogger(PredictDefCacheWriter.class);

    @Override
    public void beforeCreate(EntryEvent<PredictDefKey, PredictDef> event) throws CacheWriterException {
        LOG.debug("beforeCreate: event={}", event);
        Utils.addVariableType(event.getKey(), VariableType.Evaluate);

        PredictDef def = event.getNewValue();
        ModelKey modelKey = def.getModelKey();
        String regionName = def.getRegionName();

        Model<?, ?, ?, ?> model = getModelRegion().get(modelKey);
        LOG.debug("beforeCreate: model={}", model);

        if (model == null) {
            throw new IllegalArgumentException("Model " + modelKey + " does not exist");
        }

        ModelType mt = model.getMetadata().getType();

        switch (mt) {
            case classification: {
                new ClassificationPredictHandler(modelKey, regionName, (ClassificationModel) model, def.getFieldNames());
                break;
            }
            case regression: {
                new RegressionPredictHandler(modelKey, regionName, (RegressionModel) model, def.getFieldNames());
                break;
            }
            default: {
                LOG.warn("beforeCreate: mt={}", mt);
            }
        }
    }

    @Override
    public void beforeDestroy(EntryEvent<PredictDefKey, PredictDef> event) throws CacheWriterException {
        LOG.debug("beforeDestroy: event={}", event);
        Utils.removeVariableType(event.getKey());

        PredictDef def = event.getOldValue();
        ModelKey modelKey = def.getModelKey();
        String regionName = def.getRegionName();

        Handler.removeHandler(modelKey, regionName);
    }

    @Override
    public void init(Properties props) {
    }

    private Region<ModelKey, Model<?, ?, ?, ?>> getModelRegion() {
        if (modelRegion == null) {
            modelRegion = CacheFactory.getAnyInstance().getRegion("model");
        }

        return modelRegion;
    }

}
