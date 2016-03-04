package io.pivotal.bds.gemfire.r.server.util;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.dmg.pmml.FieldName;
import org.dmg.pmml.PMML;
import org.jpmml.evaluator.FieldValue;
import org.jpmml.evaluator.ModelEvaluator;
import org.jpmml.evaluator.ModelEvaluatorFactory;

import com.gemstone.gemfire.cache.Operation;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.pdx.PdxInstance;

import io.pivotal.bds.gemfire.r.common.PMMLKey;
import io.pivotal.bds.gemfire.r.common.PMMLPredictDef;
import io.pivotal.bds.gemfire.r.common.PMMLPredictDefKey;
import io.pivotal.bds.gemfire.r.common.PMMLPrediction;
import io.pivotal.bds.gemfire.r.common.PMMLPredictionKey;
import io.pivotal.bds.gemfire.util.Assert;
import io.pivotal.bds.gemfire.util.RegionHelper;

public class PMMLHandler extends Handler {

    private PMMLPredictDef def;

    public PMMLHandler(PMMLPredictDefKey key, PMMLPredictDef def) {
        super(key, def.getRegionName());
        this.def = def;
    }

    @Override
    public void doHandle(String regionName, Operation op, Object key, Object value) {
        if (!op.isCreate() && !op.isUpdate()) {
            return;
        }

        Region<PMMLKey, PMML> pmmlRegion = RegionHelper.getRegion("pmml");
        PMMLKey pmmlKey = def.getPmmlKey();
        PMML pmml = pmmlRegion.get(pmmlKey);
        Assert.notNull(pmml, "PMML model %s not found", pmmlKey.getId());

        ModelEvaluatorFactory modelEvaluatorFactory = ModelEvaluatorFactory.newInstance();
        ModelEvaluator<?> modelEvaluator = modelEvaluatorFactory.newModelManager(pmml);

        List<FieldName> activeFields = modelEvaluator.getActiveFields();
        LOG.debug("doHandle: activeFields={}", activeFields);

        PdxInstance inst = (PdxInstance) value;
        LOG.debug("doHandle: inst={}", inst);

        Map<FieldName, FieldValue> arguments = new LinkedHashMap<>();

        for (FieldName activeField : activeFields) {
            String fn = activeField.getValue();
            Object rawValue = inst.getField(fn);
            FieldValue activeValue = modelEvaluator.prepare(activeField, rawValue);
            arguments.put(activeField, activeValue);
        }

        LOG.debug("doHandle: arguments={}", arguments);

        Map<FieldName, ?> results = modelEvaluator.evaluate(arguments);
        LOG.debug("doHandle: results={}", results);

        Map<String, Object> values = new HashMap<>();

        for (Map.Entry<FieldName, ?> entry : results.entrySet()) {
            FieldName fieldName = entry.getKey();
            String fn = fieldName.getValue();
            Object fieldValue = entry.getValue();
            values.put(fn, fieldValue);
        }

        LOG.debug("doHandle: values={}", values);

        PMMLPredictionKey pk = new PMMLPredictionKey(UUID.randomUUID().toString(), pmmlKey.getId());
        PMMLPrediction pred = new PMMLPrediction(values);
        LOG.debug("doHandle: pk={}, pred={}", pk, pred);

        Region<PMMLPredictionKey, PMMLPrediction> r = RegionHelper.getRegion("pmmlPrediction");
        r.put(pk, pred);
    }

}
