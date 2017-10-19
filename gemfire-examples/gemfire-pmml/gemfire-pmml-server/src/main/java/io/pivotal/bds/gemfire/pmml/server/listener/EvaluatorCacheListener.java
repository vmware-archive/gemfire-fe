package io.pivotal.bds.gemfire.pmml.server.listener;

import org.apache.geode.cache.EntryEvent;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.util.CacheListenerAdapter;
import org.dmg.pmml.PMML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.pivotal.bds.gemfire.pmml.common.data.EvaluatorParams;
import io.pivotal.bds.gemfire.pmml.common.data.EvaluatorResults;
import io.pivotal.bds.gemfire.pmml.common.keys.EvalKey;
import io.pivotal.bds.gemfire.pmml.common.keys.ModelKey;
import io.pivotal.bds.gemfire.pmml.server.service.EvaluatorService;

@Component
public class EvaluatorCacheListener extends CacheListenerAdapter<EvalKey, EvaluatorParams> {

    private EvaluatorService evaluatorService;
    private Region<EvalKey, EvaluatorResults> resultsRegion;
    private Region<ModelKey, PMML> pmmlRegion;

    private static final Logger LOG = LoggerFactory.getLogger(EvaluatorCacheListener.class);

    public EvaluatorCacheListener(EvaluatorService evaluatorService, Region<EvalKey, EvaluatorResults> resultsRegion,
            Region<ModelKey, PMML> pmmlRegion) {
        this.evaluatorService = evaluatorService;
        this.resultsRegion = resultsRegion;
        this.pmmlRegion = pmmlRegion;
    }

    @Override
    public void afterCreate(EntryEvent<EvalKey, EvaluatorParams> event) {
        LOG.debug("afterCreate: event={}", event);
        evaluate(event);
    }

    @Override
    public void afterUpdate(EntryEvent<EvalKey, EvaluatorParams> event) {
        LOG.debug("afterUpdate: event={}", event);
        evaluate(event);
    }

    private void evaluate(EntryEvent<EvalKey, EvaluatorParams> event) {
        evaluate(event.getKey(), event.getNewValue());
    }

    private void evaluate(EvalKey key, EvaluatorParams params) {
        ModelKey modelKey = new ModelKey(params.getModelName());
        PMML pmml = pmmlRegion.get(modelKey);

        if (pmml == null) {
            LOG.error("evaluate: pmml not found for key={}", key);
        } else {
            EvaluatorResults results = evaluatorService.evaluate(params, pmml);
            LOG.debug("evaluate: results={}", results);
            resultsRegion.put(key, results);
        }
    }
}
