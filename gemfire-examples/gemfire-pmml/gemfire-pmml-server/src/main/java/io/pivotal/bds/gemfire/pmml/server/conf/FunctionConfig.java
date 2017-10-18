package io.pivotal.bds.gemfire.pmml.server.conf;

import javax.annotation.PostConstruct;

import org.apache.geode.cache.execute.FunctionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import io.pivotal.bds.gemfire.pmml.server.function.EvaluatorFunction;

@Configuration
public class FunctionConfig {

    private EvaluatorFunction evaluatorFunction;
    
    private static final Logger LOG = LoggerFactory.getLogger(FunctionConfig.class);

    public FunctionConfig(EvaluatorFunction evaluatorFunction) {
        this.evaluatorFunction = evaluatorFunction;
    }
    
    @PostConstruct
    public void post() {
        LOG.info("registering evaluatorFunction");
        FunctionService.registerFunction(evaluatorFunction);
    }
}
