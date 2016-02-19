package io.pivotal.bds.gemfire.r.server.writer;

import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.gemstone.gemfire.cache.CacheWriterException;
import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.EntryEvent;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.util.CacheWriterAdapter;

import io.pivotal.bds.gemfire.ml.ModelName;
import io.pivotal.bds.gemfire.ml.ModelType;
import io.pivotal.bds.gemfire.r.common.Matrix;
import io.pivotal.bds.gemfire.r.common.MatrixKey;
import io.pivotal.bds.gemfire.r.common.ModelData;
import io.pivotal.bds.gemfire.r.common.ModelDef;
import io.pivotal.bds.gemfire.r.common.ModelKey;
import io.pivotal.bds.gemfire.r.common.VariableType;
import io.pivotal.bds.gemfire.r.common.Vector;
import io.pivotal.bds.gemfire.r.common.VectorKey;
import io.pivotal.bds.gemfire.r.server.util.Utils;
import io.pivotal.bds.gemfire.util.RegionHelper;

public class ModelDefCacheWriter extends CacheWriterAdapter<ModelKey, ModelDef>implements Declarable {

    private static final Logger LOG = LoggerFactory.getLogger(ModelDefCacheWriter.class);

    @Override
    public void beforeCreate(EntryEvent<ModelKey, ModelDef> event) throws CacheWriterException {
        LOG.debug("beforeCreate: event={}", event);
        Utils.addVariableType(event.getKey(), VariableType.Model);
        generateModel(event);
    }

    @Override
    public void beforeUpdate(EntryEvent<ModelKey, ModelDef> event) throws CacheWriterException {
        LOG.debug("beforeUpdate: event={}", event);
        generateModel(event);
    }

    @Override
    public void beforeDestroy(EntryEvent<ModelKey, ModelDef> event) throws CacheWriterException {
        ModelKey modelKey = event.getKey();
        LOG.debug("beforeDestroy: modelId={}", modelKey);
        Utils.removeVariableType(event.getKey());
        RegionHelper.getRegion("modelData").remove(modelKey);
    }

    @Override
    public void init(Properties props) {
    }

    private void generateModel(EntryEvent<ModelKey, ModelDef> event) {
        try {
            ModelKey modelKey = event.getKey();
            ModelDef modelDef = event.getNewValue();
            LOG.debug("generateModel: modelKey={}, modelDef={}", modelKey, modelDef);

            String matrixId = modelDef.getMatrixId();
            MatrixKey matrixKey = new MatrixKey(matrixId);
            Region<MatrixKey, Matrix<Object>> matrixRegion = RegionHelper.getRegion("matrix");
            Matrix<Object> matrix = matrixRegion.get(matrixKey);
            LOG.debug("generateModel: matrixKey={}, matrix={}", matrixKey, matrix);
            Assert.notNull(matrix, "Matrix " + matrixId + " does not exist");

            String vectorId = modelDef.getVectorId();
            VectorKey vectorKey = new VectorKey(vectorId);
            Region<VectorKey, Vector<Object>> vectorRegion = RegionHelper.getRegion("vector");
            Vector<Object> vector = vectorRegion.get(vectorKey);
            LOG.debug("generateModel: vectorKey={}, vector={}", vectorKey, vector);
            Assert.notNull(vector, "Vector " + vectorId + " does not exist");

            ModelType modelType = modelDef.getModelType();
            ModelName modelName = modelDef.getModelName();
            Map<String, Object> properties = modelDef.getParameters();

            Region<ModelKey, ModelData> modelDataRegion = RegionHelper.getRegion("modelData");

            double[][] x = Utils.convertToDoubleArray(matrix);
            Number[] y = Utils.convertToNumberArray(vector);

            ModelData data = new ModelData(modelKey, modelType, modelName, properties, x, y);
            modelDataRegion.put(modelKey, data);
        } catch (Exception x) {
            LOG.error("generateModel: x={}", x.toString(), x);
            throw new IllegalArgumentException(x.toString(), x);
        }
    }

}
