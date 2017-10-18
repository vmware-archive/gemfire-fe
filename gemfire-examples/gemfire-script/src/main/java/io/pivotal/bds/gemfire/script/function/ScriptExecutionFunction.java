package io.pivotal.bds.gemfire.script.function;

import javax.script.Bindings;
import javax.script.ScriptEngine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.StringUtils;

import org.apache.geode.cache.execute.Function;
import org.apache.geode.cache.execute.FunctionContext;
import org.apache.geode.cache.execute.FunctionException;
import org.apache.geode.cache.execute.ResultSender;

public class ScriptExecutionFunction implements Function, ApplicationContextAware {

    private ScriptEngine engine;
    private ApplicationContext applicationContext;

    private static final Logger LOG = LoggerFactory.getLogger(ScriptExecutionFunction.class);

    private static final long serialVersionUID = 1L;

    public ScriptExecutionFunction(ScriptEngine engine) {
        this.engine = engine;
    }

    @Override
    public void execute(FunctionContext context) {
        LOG.info("execute");

        try {
            ResultSender<Object> sender = context.getResultSender();

            String script = (String) context.getArguments();

            LOG.info("execute: script={}", script);

            if (!StringUtils.hasText(script)) {
                throw new FunctionException("Script is empty or null");
            }

            Bindings bindings = engine.createBindings();
            bindings.put("context", applicationContext);

            Object ret = engine.eval(script, bindings);

            sender.lastResult(ret);
        } catch (FunctionException x) {
            LOG.error("execute: x={}", x.toString(), x);
            throw x;
        } catch (Exception x) {
            LOG.error("execute: x={}", x.toString(), x);
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

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        LOG.info("setApplicationContext");
        this.applicationContext = applicationContext;
    }
}
