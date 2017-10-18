package io.pivotal.bds.gemfire.r.server.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.Operation;
import org.apache.geode.cache.Region;
import org.apache.geode.pdx.PdxInstance;

import io.pivotal.bds.gemfire.r.common.DynamicTrainDef;
import io.pivotal.bds.gemfire.r.common.DynamicTrainDefKey;
import io.pivotal.bds.gemfire.r.common.ModelData;
import io.pivotal.bds.gemfire.r.common.ModelDefKey;
import io.pivotal.bds.gemfire.r.common.ModelInstance;
import io.pivotal.bds.gemfire.r.common.ModelKey;
import io.pivotal.bds.gemfire.r.common.Window;
import io.pivotal.bds.gemfire.r.common.WindowKey;
import io.pivotal.bds.gemfire.util.Assert;
import io.pivotal.bds.gemfire.util.RegionHelper;

public class DynamicTrainHandler extends Handler {

    private DynamicTrainDefKey trainDefKey;
    private DynamicTrainDef trainDef;

    private static final Logger LOG = LoggerFactory.getLogger(DynamicTrainHandler.class);

    public DynamicTrainHandler(DynamicTrainDefKey key, DynamicTrainDef def) {
        super(key, def.getRegionName());
        this.trainDefKey = key;
        this.trainDef = def;
    }

    @Override
    public void doHandle(String regionName, Operation op, Object key, Object value) {
        LOG.debug("doHandle: regionName={}, op={}, key={}, value={}", regionName, op, key, value);
        LOG.debug("doHandle: regionName={}, key={}, trainDefKey={}, trainDef={}", key, trainDefKey, trainDef);

        if (!op.isCreate() && !op.isUpdate()) {
            return;
        }

        PdxInstance inst = (PdxInstance) value;

        String yfld = trainDef.getyFieldName();

        Object yObj = inst.getField(yfld);
        Assert.notNull(yObj, "Missing y value for field %s in DynamicTrainHandler", yfld);
        Number y = Utils.convert(yObj);

        String[] xFieldNames = trainDef.getxFieldNames();
        double[] x = new double[xFieldNames.length];

        for (int i = 0; i < xFieldNames.length; ++i) {
            String xfld = xFieldNames[i];
            Object xObj = inst.getField(xfld);
            Assert.notNull(xObj, "Missing x value for field %s in DynamicTrainHandler", xfld);
            x[i] = Utils.convert(xObj).doubleValue();
        }

        Region<WindowKey<ModelKey>, Window<ModelInstance>> windowRegion = RegionHelper.getRegion("window");

        ModelKey modelKey = trainDef.getModelKey();
        WindowKey<ModelKey> windowKey = new WindowKey<>(modelKey);
        ModelInstance minst = new ModelInstance(x, y);

        Window<ModelInstance> window = windowRegion.get(windowKey, trainDef.getSize());
        window.add(minst);
        windowRegion.put(windowKey, window);

        ModelDefKey modelDefKey = trainDef.getModelDefKey();

        ModelData modelData = createModelData(window, modelKey, modelDefKey);

        Region<ModelKey, ModelData> modelDataRegion = RegionHelper.getRegion("modelData");
        modelDataRegion.put(modelKey, modelData);
    }

    private static ModelData createModelData(Window<ModelInstance> window, ModelKey key, ModelDefKey modelDefKey) {
        double[][] x = extractXMatrix(window);
        Number[] y = extractYVector(window);
        ModelData data = new ModelData(key, modelDefKey, x, y);
        return data;
    }

    private static double[][] extractXMatrix(Window<ModelInstance> window) {
        int nrows = window.size();

        ModelInstance mi = window.peek();
        int ncols = mi.getX().length;

        double[][] d = new double[nrows][ncols];

        for (int i = 0; i < nrows; ++i) {
            mi = window.get(i);
            d[i] = mi.getX();
        }

        return d;
    }

    private static Number[] extractYVector(Window<ModelInstance> window) {
        int nrows = window.size();
        Number[] n = new Number[nrows];

        for (int i = 0; i < nrows; ++i) {
            n[i] = window.get(i).getY();
        }

        return n;
    }
}
