package io.pivotal.bds.gemfire.script.conf;

import javax.annotation.PostConstruct;
import javax.script.ScriptEngine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.gemstone.gemfire.cache.execute.FunctionService;

import io.pivotal.bds.gemfire.script.function.ScriptExecutionFunction;

@Configuration
public class FunctionConfig {
    
    @Autowired
    private ScriptEngine engine;

    private static final Logger LOG = LoggerFactory.getLogger(FunctionConfig.class);

    @PostConstruct
    public void createFunction() {
        LOG.info("creating and registering ScriptExecutionFunction");
        ScriptExecutionFunction f = new ScriptExecutionFunction(engine);
        FunctionService.registerFunction(f);
    }
}
