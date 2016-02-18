package io.pivotal.bds.gemfire.r.server.writer;

import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.CacheFactory;
import com.gemstone.gemfire.cache.CacheWriterException;
import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.EntryEvent;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.util.CacheWriterAdapter;

import io.pivotal.bds.gemfire.ml.Model;
import io.pivotal.bds.gemfire.ml.ModelFactory;
import io.pivotal.bds.gemfire.ml.ModelFactoryManager;
import io.pivotal.bds.gemfire.ml.ModelName;
import io.pivotal.bds.gemfire.ml.ModelType;
import io.pivotal.bds.gemfire.r.common.ModelData;
import io.pivotal.bds.gemfire.r.common.ModelKey;
import io.pivotal.bds.gemfire.util.RegionHelper;

public class ModelDataCacheWriter extends CacheWriterAdapter<ModelKey, ModelData>implements Declarable {

    private Cache cache;
    @SuppressWarnings("rawtypes")
    private Region<ModelKey, Model> modelRegion;

    private static final Logger LOG = LoggerFactory.getLogger(ModelDataCacheWriter.class);

    @Override
    public void beforeCreate(EntryEvent<ModelKey, ModelData> event) throws CacheWriterException {
        LOG.debug("beforeCreate: event={}", event);

        ModelKey modelKey = event.getKey();
        ModelData data = event.getNewValue();

        Model<?, ?, ?, ?> model = createModel(data);
        LOG.debug("beforeCreate: data={}, model={}", data, model);

        getModelRegion().put(modelKey, model);
    }

    @Override
    public void beforeUpdate(EntryEvent<ModelKey, ModelData> event) throws CacheWriterException {
        LOG.debug("beforeUpdate: event={}", event);

        ModelKey modelKey = event.getKey();
        ModelData data = event.getNewValue();

        Model<?, ?, ?, ?> model = createModel(data);
        LOG.debug("beforeUpdate: data={}, model={}", data, model);

        getModelRegion().put(modelKey, model);
    }

    @Override
    public void beforeDestroy(EntryEvent<ModelKey, ModelData> event) throws CacheWriterException {
        LOG.debug("beforeDestroy: event={}", event);
        ModelKey modelKey = event.getKey();
        RegionHelper.getRegion("model").remove(modelKey);
    }

    @Override
    public void init(Properties props) {
    }

    @SuppressWarnings("rawtypes")
    private Model createModel(ModelData data) {
        ModelKey modelKey = data.getModelKey();
        String modelId = modelKey.getModelId();
        ModelName modelName = data.getModelName();
        ModelType modelType = data.getType();
        Map<String, Object> properties = data.getProperties();

        switch (modelType) {
            case classification: {
                ModelFactory<double[][], int[], double[], Integer> factory = ModelFactoryManager.getFactory(modelType, modelName);

                double[][] x = data.getX();
                int[] y = convertToIntArray(data.getY());

                Model<double[][], int[], double[], Integer> model = factory.create(modelId, properties);
                model.train(x, y);

                return model;
            }
            case regression: {
                ModelFactory<double[][], double[], double[], Integer> factory = ModelFactoryManager.getFactory(modelType,
                        modelName);

                double[][] x = data.getX();
                double[] y = convertToDoubleArray(data.getY());

                Model<double[][], double[], double[], Integer> model = factory.create(modelId, properties);
                model.train(x, y);

                return model;
            }
            default: {
                throw new IllegalArgumentException("Unknown model type: " + modelType.name());
            }
        }
    }

    private int[] convertToIntArray(Number[] n) {
        int[] t = new int[n.length];
        for (int i = 0; i < t.length; ++i) {
            t[i] = n[i].intValue();
        }
        return t;
    }

    private double[] convertToDoubleArray(Number[] n) {
        double[] t = new double[n.length];
        for (int i = 0; i < t.length; ++i) {
            t[i] = n[i].doubleValue();
        }
        return t;
    }

    private Cache getCache() {
        if (cache == null) {
            cache = CacheFactory.getAnyInstance();
        }

        return cache;
    }

    @SuppressWarnings("rawtypes")
    private Region<ModelKey, Model> getModelRegion() {
        if (modelRegion == null) {
            modelRegion = getCache().getRegion("model");
        }

        return modelRegion;
    }
}
