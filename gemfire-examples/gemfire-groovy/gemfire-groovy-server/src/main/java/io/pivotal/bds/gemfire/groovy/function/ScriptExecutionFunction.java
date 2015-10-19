package io.pivotal.bds.gemfire.groovy.function;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.execute.Function;
import com.gemstone.gemfire.cache.execute.FunctionContext;
import com.gemstone.gemfire.cache.execute.FunctionException;
import com.gemstone.gemfire.cache.execute.RegionFunctionContext;
import com.gemstone.gemfire.cache.execute.ResultSender;

import groovy.lang.Binding;
import groovy.util.GroovyScriptEngine;
import io.pivotal.bds.gemfire.groovy.common.ScriptExecutionContext;
import io.pivotal.bds.gemfire.groovy.common.ScriptExecutionResult;
import io.pivotal.bds.metrics.timer.Timer;

public class ScriptExecutionFunction implements Function {

    private GroovyScriptEngine engine;
    private Timer timer = new Timer("ScriptExecutionFunction");

    private static final Logger LOG = LoggerFactory.getLogger(ScriptExecutionFunction.class);

    private static final long serialVersionUID = 1L;

    public ScriptExecutionFunction(GroovyScriptEngine engine) {
        this.engine = engine;
    }

    @Override
    public void execute(FunctionContext context) {
        try {
            ResultSender<ScriptExecutionResult> sender = context.getResultSender();
            ScriptExecutionContext sec = (ScriptExecutionContext) context.getArguments();

            String scriptName = sec.getScriptName();
            Object args = sec.getArguments();
            Set<?> filter = null;

            Binding binding = new Binding();

            if (args != null) {
                binding.setVariable("arguments", args);
            }

            if (context instanceof RegionFunctionContext) {
                RegionFunctionContext rctx = (RegionFunctionContext) context;
                filter = rctx.getFilter();
                binding.setVariable("filter", filter);
            }

            LOG.debug("execute: args={}, scriptName={}, filter={}", args, scriptName, filter);
            
            timer.start();
            Object ret = engine.run(scriptName, binding);
            timer.end();

            LOG.debug("execute: ret={}, args={}, scriptName={}, filter={}", ret, args, scriptName, filter);
            ScriptExecutionResult res = new ScriptExecutionResult(ret);
            sender.lastResult(res);
        } catch (Exception x) {
            LOG.error(x.toString(), x);
            throw new FunctionException(x.toString(), x);
        }
    }

    @Override
    public String getId() {
        return ScriptExecutionFunction.class.getSimpleName();
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
