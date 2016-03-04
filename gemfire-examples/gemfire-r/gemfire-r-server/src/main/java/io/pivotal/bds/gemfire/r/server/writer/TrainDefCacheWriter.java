package io.pivotal.bds.gemfire.r.server.writer;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.gemstone.gemfire.cache.CacheWriterException;
import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.EntryEvent;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.util.CacheWriterAdapter;

import io.pivotal.bds.gemfire.r.common.Matrix;
import io.pivotal.bds.gemfire.r.common.MatrixKey;
import io.pivotal.bds.gemfire.r.common.ModelData;
import io.pivotal.bds.gemfire.r.common.ModelDefKey;
import io.pivotal.bds.gemfire.r.common.ModelKey;
import io.pivotal.bds.gemfire.r.common.TrainDef;
import io.pivotal.bds.gemfire.r.common.TrainDefKey;
import io.pivotal.bds.gemfire.r.common.Vector;
import io.pivotal.bds.gemfire.r.common.VectorKey;
import io.pivotal.bds.gemfire.r.server.util.Utils;
import io.pivotal.bds.gemfire.util.RegionHelper;

public class TrainDefCacheWriter extends CacheWriterAdapter<TrainDefKey, TrainDef>implements Declarable {

    private static final Logger LOG = LoggerFactory.getLogger(TrainDefCacheWriter.class);

    @Override
    public void beforeCreate(EntryEvent<TrainDefKey, TrainDef> event) throws CacheWriterException {
        LOG.debug("beforeCreate: event={}", event);
        train(event);
    }

    @Override
    public void beforeUpdate(EntryEvent<TrainDefKey, TrainDef> event) throws CacheWriterException {
        LOG.debug("beforeUpdate: event={}", event);
        train(event);
    }

    @Override
    public void init(Properties props) {
    }

    private void train(EntryEvent<TrainDefKey, TrainDef> event) throws CacheWriterException {
        TrainDef trainDef = event.getNewValue();

        ModelKey modelKey = trainDef.getModelKey();
        ModelDefKey modelDefKey = trainDef.getModelDefKey();
        MatrixKey matrixKey = trainDef.getMatrixKey();
        VectorKey vectorKey = trainDef.getVectorKey();

        Region<MatrixKey, Matrix<Object>> matrixRegion = RegionHelper.getRegion("matrix");
        Matrix<Object> matrix = matrixRegion.get(matrixKey);
        LOG.debug("generateModel: matrixKey={}, matrix={}", matrixKey, matrix);
        Assert.notNull(matrix, "Matrix " + matrixKey + " does not exist");

        Region<VectorKey, Vector<Object>> vectorRegion = RegionHelper.getRegion("vector");
        Vector<Object> vector = vectorRegion.get(vectorKey);
        LOG.debug("generateModel: vectorKey={}, vector={}", vectorKey, vector);
        Assert.notNull(vector, "Vector " + vectorKey + " does not exist");

        Region<ModelKey, ModelData> modelDataRegion = RegionHelper.getRegion("modelData");

        double[][] x = Utils.convertObjectMatrixToDoubleArray(matrix);
        Number[] y = Utils.convertToNumberArray(vector);

        ModelData data = new ModelData(modelKey, modelDefKey, x, y);
        modelDataRegion.put(modelKey, data);
    }
}
