package io.pivotal.bds.gemfire.r.server.listener;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.CacheFactory;
import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.EntryEvent;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.util.CacheListenerAdapter;

import io.pivotal.bds.gemfire.ml.Model;
import io.pivotal.bds.gemfire.ml.ModelType;
import io.pivotal.bds.gemfire.ml.classification.ClassificationModel;
import io.pivotal.bds.gemfire.ml.regression.RegressionModel;
import io.pivotal.bds.gemfire.r.common.EvaluateDef;
import io.pivotal.bds.gemfire.r.common.EvaluateKey;
import io.pivotal.bds.gemfire.r.common.ModelKey;
import io.pivotal.bds.gemfire.r.server.util.ClassificationPredictHandler;
import io.pivotal.bds.gemfire.r.server.util.PredictHandler;
import io.pivotal.bds.gemfire.r.server.util.RegressionPredictHandler;

public class EvaluateCacheListener extends CacheListenerAdapter<EvaluateKey, EvaluateDef>implements Declarable {

    private Region<ModelKey, Model<?, ?, ?, ?>> modelRegion;

    private static final Logger LOG = LoggerFactory.getLogger(EvaluateCacheListener.class);

    @Override
    public void afterCreate(EntryEvent<EvaluateKey, EvaluateDef> event) {
        LOG.debug("afterCreate: event={}", event);

        EvaluateDef def = event.getNewValue();
        ModelKey modelKey = def.getModelKey();
        String modelId = modelKey.getModelId();
        String regionName = def.getRegionName();

        Model<?, ?, ?, ?> model = getModelRegion().get(modelKey);
        LOG.debug("afterCreate: model={}", model);

        if (model == null) {
            throw new IllegalArgumentException("Model " + modelId + " does not exist");
        }

        ModelType mt = model.getMetadata().getType();

        switch (mt) {
            case classification: {
                new ClassificationPredictHandler(modelId, regionName, (ClassificationModel) model, def.getFieldNames());
                break;
            }
            case regression: {
                new RegressionPredictHandler(modelId, regionName, (RegressionModel) model, def.getFieldNames());
                break;
            }
            default: {
                LOG.warn("afterCreate: mt={}", mt);
            }
        }
    }

    @Override
    public void afterDestroy(EntryEvent<EvaluateKey, EvaluateDef> event) {
        LOG.debug("afterDestroy: event={}", event);

        EvaluateDef def = event.getOldValue();
        ModelKey modelKey = def.getModelKey();
        String modelId = modelKey.getModelId();
        String regionName = def.getRegionName();

        PredictHandler.removeHandler(modelId, regionName);
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
