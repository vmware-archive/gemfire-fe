package io.pivotal.bds.gemfire.pmml.server.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.dmg.pmml.Entity;
import org.dmg.pmml.FieldName;
import org.dmg.pmml.PMML;
import org.jpmml.evaluator.Computable;
import org.jpmml.evaluator.FieldValue;
import org.jpmml.evaluator.HasEntityId;
import org.jpmml.evaluator.HasEntityRegistry;
import org.jpmml.evaluator.HasProbability;
import org.jpmml.evaluator.InputField;
import org.jpmml.evaluator.ModelEvaluator;
import org.jpmml.evaluator.ModelEvaluatorFactory;
import org.jpmml.evaluator.OutputField;
import org.jpmml.evaluator.TargetField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import com.codahale.metrics.Timer.Context;
import com.google.common.collect.BiMap;

import io.pivotal.bds.gemfire.pmml.common.data.EvaluatorParams;
import io.pivotal.bds.gemfire.pmml.common.data.EvaluatorResults;

@Component
public class EvaluatorService {

    private Timer timer;

    private static final ModelEvaluatorFactory modelEvaluatorFactory = ModelEvaluatorFactory.newInstance();
    private static final Logger LOG = LoggerFactory.getLogger(EvaluatorService.class);

    public EvaluatorService(MetricRegistry metricRegistry) {
        this.timer = metricRegistry.timer("EvaluatorService");
    }

    public EvaluatorResults evaluate(EvaluatorParams params, PMML pmml) {
        LOG.debug("execute: params={}", params);
        
        Context ctx = timer.time();

        Map<String, Object> parameters = params.getParameters();

        ModelEvaluator<?> evaluator = modelEvaluatorFactory.newModelEvaluator(pmml);

        Map<FieldName, FieldValue> arguments = new LinkedHashMap<>();
        List<InputField> inputFields = evaluator.getInputFields();

        for (InputField inputField : inputFields) {
            FieldName fieldName = inputField.getName();
            String fn = fieldName.getValue();

            Object fv = parameters.get(fn);

            if (fv == null) {
                LOG.warn("execute: field {} is null", fn);
            } else {
                FieldValue fieldValue = inputField.prepare(fv);
                arguments.put(fieldName, fieldValue);
            }
        }

        Map<FieldName, ?> results = evaluator.evaluate(arguments);

        Map<String, Object> resultValues = new HashMap<>();
        List<TargetField> targetFields = evaluator.getTargetFields();

        for (TargetField targetField : targetFields) {
            FieldName fieldName = targetField.getName();
            Object targetFieldValue = results.get(fieldName);
            LOG.debug("execute: targetFieldValue={}", targetFieldValue);

            if (targetFieldValue != null) {
                Class<?> targetFieldValueClass = targetFieldValue.getClass();
                LOG.debug("execute: targetFieldValue.getClass()={}", targetFieldValueClass);
                
                Object fieldValue = null;

                if (targetFieldValue instanceof Computable) {
                    fieldValue = ((Computable) targetFieldValue).getResult();
                } else if (targetFieldValue instanceof HasEntityId && targetFieldValue instanceof HasProbability) {
                    HasEntityId hasEntityId = (HasEntityId) targetFieldValue;
                    HasEntityRegistry<?> hasEntityRegistry = (HasEntityRegistry<?>) evaluator;

                    BiMap<String, ? extends Entity> entities = hasEntityRegistry.getEntityRegistry();
                    Entity winner = entities.get(hasEntityId.getEntityId());

                    HasProbability hasProbability = (HasProbability) targetFieldValue;
                    fieldValue = hasProbability.getProbability(winner.getId());
                } else {
                    fieldValue = targetFieldValue;
                }

                resultValues.put(fieldName.getValue(), fieldValue);
            } else {
                LOG.warn("execute: target value for field {} is null", fieldName.getValue());
            }
        }

        Map<String, Object> outputValues = new HashMap<>();
        List<OutputField> outputFields = evaluator.getOutputFields();

        for (OutputField outputField : outputFields) {
            FieldName outputFieldName = outputField.getName();
            Object outputFieldValue = results.get(outputFieldName);
            outputValues.put(outputFieldName.getValue(), outputFieldValue);
        }

        EvaluatorResults evaluatorResults = new EvaluatorResults(params, resultValues, outputValues);

        ctx.stop();

        LOG.debug("execute: evaluatorResults={}", evaluatorResults);
        return evaluatorResults;
    }
}
