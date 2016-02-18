package io.pivotal.bds.gemfire.r.server.util;

import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.Operation;
import com.gemstone.gemfire.pdx.PdxInstance;

import io.pivotal.bds.gemfire.ml.regression.RegressionModel;
import io.pivotal.bds.gemfire.r.common.Prediction;
import io.pivotal.bds.gemfire.r.common.PredictionKey;

public class RegressionPredictHandler extends PredictHandler {

    private RegressionModel model;
    private String[] fieldNames;

    private static final Logger LOG = LoggerFactory.getLogger(RegressionPredictHandler.class);

    public RegressionPredictHandler(String modelId, String regionName, RegressionModel model, String[] fieldNames) {
        super(modelId);
        this.model = model;
        this.fieldNames = fieldNames;
        addHandler(this, regionName);
    }

    @Override
    public void doHandle(String regionName, Operation op, Object key, Object value) {
        LOG.debug("doHandle: regionName={}, op={}, key={}, value={}", regionName, op, key, value);

        if (!PdxInstance.class.isInstance(value)) {
            throw new IllegalArgumentException("Value is not a PdxInstance: " + value.getClass().getName());
        }

        if (op.isCreate() || op.isUpdate()) {
            PdxInstance inst = PdxInstance.class.cast(value);
            double[] x = new double[fieldNames.length];

            for (int i = 0; i < fieldNames.length; ++i) {
                String fieldName = fieldNames[i];
                Object fieldObj = inst.getField(fieldName);

                if (fieldObj == null) {
                    throw new IllegalArgumentException("Value for field " + fieldName + " is null for key " + key);
                }

                if (!Number.class.isInstance(fieldObj)) {
                    throw new IllegalArgumentException("Value for field " + fieldName + " is not a number for key " + key + ": "
                            + fieldObj.getClass().getName());
                }

                Number n = Number.class.cast(fieldObj);
                double d = n.doubleValue();
                x[i] = d;
            }

            double y = model.predict(x);
            LOG.debug("doHandle: regionName={}, op={}, key={}, value={}, x={}, y={}", regionName, op, key, value,
                    Arrays.toString(x), y);

            PredictionKey predictKey = new PredictionKey(UUID.randomUUID().toString(), getModelId());
            Prediction predict = new Prediction(predictKey, new Date(), y);

            send(predictKey, predict);
        } else {
            // TODO
        }
    }

    @Override
    public String toString() {
        return "RegressionPredictHandler [modelId=" + getModelId() + ", model=" + model + ", fieldNames="
                + Arrays.toString(fieldNames) + "]";
    }
}
