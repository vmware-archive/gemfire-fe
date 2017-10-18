package io.pivotal.bds.gemfire.pmml.server.function;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.execute.Function;
import org.apache.geode.cache.execute.FunctionContext;
import org.apache.geode.cache.execute.FunctionException;
import org.apache.geode.cache.execute.ResultSender;
import org.dmg.pmml.PMML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.pivotal.bds.gemfire.pmml.common.data.EvaluatorParams;
import io.pivotal.bds.gemfire.pmml.common.data.EvaluatorResults;
import io.pivotal.bds.gemfire.pmml.common.keys.ModelKey;
import io.pivotal.bds.gemfire.pmml.server.service.EvaluatorService;

@Component
@SuppressWarnings("serial")
public class EvaluatorFunction implements Function<EvaluatorParams> {

    private Region<ModelKey, PMML> pmmlRegion;
    private EvaluatorService evaluatorService;

    private static final Logger LOG = LoggerFactory.getLogger(EvaluatorFunction.class);

    public EvaluatorFunction(Region<ModelKey, PMML> pmmlRegion, EvaluatorService evaluatorService) {
        this.pmmlRegion = pmmlRegion;
        this.evaluatorService = evaluatorService;
    }

    @Override
    public void execute(FunctionContext<EvaluatorParams> context) {
        try {
            EvaluatorParams params = context.getArguments();
            LOG.info("execute: params={}", params);
            
            String name = params.getName();

            ModelKey key = new ModelKey(name);
            PMML pmml = pmmlRegion.get(key);

            if (pmml == null) {
                throw new NullPointerException("Model " + name + " not found");
            }

            EvaluatorResults evaluatorResults = evaluatorService.evaluate(params, pmml);
            LOG.info("execute: evaluatorResults={}", evaluatorResults);

            ResultSender<EvaluatorResults> sender = context.getResultSender();
            sender.lastResult(evaluatorResults);
        } catch (Exception x) {
            LOG.error("execute: x={}", x.toString(), x);
            throw new FunctionException(x.toString(), x);
        }
    }

    @Override
    public String getId() {
        return getClass().getSimpleName();
    }

    @Override
    public boolean hasResult() {
        return true;
    }

    @Override
    public boolean isHA() {
        return true;
    }

    @Override
    public boolean optimizeForWrite() {
        return false;
    }

}
