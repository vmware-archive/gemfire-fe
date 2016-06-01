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

import io.pivotal.bds.gemfire.ml.KernelType;
import io.pivotal.bds.gemfire.ml.MercerKernelFactory;
import io.pivotal.bds.gemfire.ml.MercerKernelFactoryManager;
import io.pivotal.bds.gemfire.ml.Model;
import io.pivotal.bds.gemfire.ml.ModelFactory;
import io.pivotal.bds.gemfire.ml.ModelFactoryManager;
import io.pivotal.bds.gemfire.ml.ModelName;
import io.pivotal.bds.gemfire.ml.ModelType;
import io.pivotal.bds.gemfire.r.common.KernelDef;
import io.pivotal.bds.gemfire.r.common.KernelKey;
import io.pivotal.bds.gemfire.r.common.ModelData;
import io.pivotal.bds.gemfire.r.common.ModelDef;
import io.pivotal.bds.gemfire.r.common.ModelDefKey;
import io.pivotal.bds.gemfire.r.common.ModelKey;
import io.pivotal.bds.gemfire.util.Assert;
import io.pivotal.bds.gemfire.util.RegionHelper;
import smile.math.kernel.MercerKernel;

public class ModelDataCacheWriter extends CacheWriterAdapter<ModelKey, ModelData>implements Declarable {

    private Cache cache;
    @SuppressWarnings("rawtypes")
    private Region<ModelKey, Model> modelRegion;

    private static final Logger LOG = LoggerFactory.getLogger(ModelDataCacheWriter.class);

    @Override
    public void beforeCreate(EntryEvent<ModelKey, ModelData> event) throws CacheWriterException {
        LOG.debug("beforeCreate: event={}", event);
        createModel(event);
    }

    @Override
    public void beforeUpdate(EntryEvent<ModelKey, ModelData> event) throws CacheWriterException {
        LOG.debug("beforeUpdate: event={}", event);
        createModel(event);
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

    private void createModel(EntryEvent<ModelKey, ModelData> event) {
        ModelKey modelKey = event.getKey();
        ModelData modelData = event.getNewValue();
        ModelDefKey modelDefKey = modelData.getModelDefKey();

        Region<ModelDefKey, ModelDef> modelDefRegion = RegionHelper.getRegion("modelDef");
        ModelDef def = modelDefRegion.get(modelDefKey);

        String modelId = modelKey.getId();
        ModelName modelName = def.getName();
        ModelType modelType = def.getType();
        Map<String, Object> properties = def.getParameters();

        KernelKey kernelKey = (KernelKey) properties.get("kernelKey");

        if (kernelKey != null) {
            Region<KernelKey, KernelDef> kernelDefRegion = RegionHelper.getRegion("kernelDef");
            KernelDef kernelDef = kernelDefRegion.get(kernelKey);
            Assert.notNull(kernelDef, "Kernel def %s not found", kernelKey.getId());
            
            KernelType kernelType = kernelDef.getType();
            Map<String, Number> kernelProps = kernelDef.getProperties();
            MercerKernelFactory<?> mkf = MercerKernelFactoryManager.getFactory(kernelType);
            MercerKernel<?> kern = mkf.createKernel(kernelProps);
            
            properties.put("kernel", kern);
        }

        switch (modelType) {
            case classification: {
                ModelFactory<double[][], int[], double[], Integer> factory = ModelFactoryManager.getFactory(modelType, modelName);

                double[][] x = modelData.getX();
                int[] y = convertToIntArray(modelData.getY());

                Model<double[][], int[], double[], Integer> model = factory.create(modelId, properties);
                model.train(x, y);

                getModelRegion().put(modelKey, model);
                break;
            }
            case regression: {
                ModelFactory<double[][], double[], double[], Integer> factory = ModelFactoryManager.getFactory(modelType,
                        modelName);

                double[][] x = modelData.getX();
                double[] y = convertToDoubleArray(modelData.getY());

                Model<double[][], double[], double[], Integer> model = factory.create(modelId, properties);
                model.train(x, y);

                getModelRegion().put(modelKey, model);
                break;
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
