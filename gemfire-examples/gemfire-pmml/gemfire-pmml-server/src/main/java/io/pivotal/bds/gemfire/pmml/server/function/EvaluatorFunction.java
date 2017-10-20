package io.pivotal.bds.gemfire.pmml.server.function;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.execute.Function;
import org.apache.geode.cache.execute.FunctionContext;
import org.apache.geode.cache.execute.FunctionException;
import org.apache.geode.cache.execute.RegionFunctionContext;
import org.apache.geode.cache.execute.ResultSender;
import org.dmg.pmml.PMML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import com.codahale.metrics.Timer.Context;

import io.pivotal.bds.gemfire.pmml.common.data.EvaluatorParams;
import io.pivotal.bds.gemfire.pmml.common.data.EvaluatorResults;
import io.pivotal.bds.gemfire.pmml.common.keys.ModelKey;
import io.pivotal.bds.gemfire.pmml.server.service.EvaluatorService;

@Component
@SuppressWarnings("serial")
public class EvaluatorFunction implements Function<EvaluatorParams> {

    private Region<ModelKey, PMML> pmmlRegion;
    private EvaluatorService evaluatorService;
    private Timer timer;

    private static final Logger LOG = LoggerFactory.getLogger(EvaluatorFunction.class);

    public EvaluatorFunction(Region<ModelKey, PMML> pmmlRegion, EvaluatorService evaluatorService, MetricRegistry metricRegistry) {
        this.pmmlRegion = pmmlRegion;
        this.evaluatorService = evaluatorService;
        this.timer = metricRegistry.timer("EvaluatorFunction");
    }

    @SuppressWarnings("unchecked")
    @Override
    public void execute(FunctionContext<EvaluatorParams> context) {
        try {
            Context tctx = timer.time();
            
            List<EvaluatorResults> results = new ArrayList<>();
            
            if (context instanceof RegionFunctionContext) {
                RegionFunctionContext rctx = (RegionFunctionContext)context;
                Set<EvaluatorParams> filter = (Set<EvaluatorParams>) rctx.getFilter();
                
                for (EvaluatorParams params: filter) {
                    process(params, results);
                }
            }
            
            EvaluatorParams params = context.getArguments();
            
            if (params != null) {
                process(params, results);
            }
            
            ResultSender<EvaluatorResults> sender = context.getResultSender();
            Iterator<EvaluatorResults> iter = results.iterator();
            
            while (iter.hasNext()) {
                EvaluatorResults result = iter.next();
                
                if (iter.hasNext()) {                    
                    sender.sendResult(result);
                } else {                    
                    sender.lastResult(result);
                }
            }
            
            tctx.stop();
        } catch (Exception x) {
            LOG.error("execute: x={}", x.toString(), x);
            throw new FunctionException(x.toString(), x);
        }
    }
    
    private void process(EvaluatorParams params, List<EvaluatorResults> results) {
        LOG.debug("process: params={}", params);
        
        String name = params.getModelName();

        ModelKey key = new ModelKey(name);
        PMML pmml = pmmlRegion.get(key);

        if (pmml == null) {
            throw new NullPointerException("Model " + name + " not found");
        }

        EvaluatorResults evaluatorResults = evaluatorService.evaluate(params, pmml);
        LOG.debug("process: evaluatorResults={}", evaluatorResults);
        
        results.add(evaluatorResults);
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
        return true;
    }

}
