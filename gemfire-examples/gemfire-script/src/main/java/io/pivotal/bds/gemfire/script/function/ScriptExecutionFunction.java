package io.pivotal.bds.gemfire.script.function;

import java.util.Set;

import javax.script.Bindings;
import javax.script.ScriptEngine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.execute.Function;
import com.gemstone.gemfire.cache.execute.FunctionContext;
import com.gemstone.gemfire.cache.execute.FunctionException;
import com.gemstone.gemfire.cache.execute.RegionFunctionContext;
import com.gemstone.gemfire.cache.execute.ResultSender;

import io.pivotal.bds.gemfire.script.data.ExecutionData;
import io.pivotal.bds.metrics.timer.Timer;

public class ScriptExecutionFunction implements Function {

    private Region<String, String> scriptRegion;
    private ScriptEngine engine;

    private final Timer timer = new Timer("ScriptExecutionFunction");

    private static final Logger LOG = LoggerFactory.getLogger(ScriptExecutionFunction.class);

    private static final long serialVersionUID = 1L;

    public ScriptExecutionFunction(Region<String, String> scriptRegion, ScriptEngine engine) {
        this.scriptRegion = scriptRegion;
        this.engine = engine;
    }

    @Override
    public void execute(FunctionContext context) {
        LOG.info("execute");

        try {
            RegionFunctionContext rctx = (RegionFunctionContext) context;
            ResultSender<Object> sender = rctx.getResultSender();

            ExecutionData data = (ExecutionData) context.getArguments();

            String scriptName = data.getScriptName();
            Object args = data.getArguments();
            Set<?> filter = rctx.getFilter();

            LOG.info("execute: scriptName={}, args={}, filter={}", scriptName, args, filter);

            String script = scriptRegion.get(scriptName);

            if (!StringUtils.hasText(script)) {
                throw new FunctionException("Script " + scriptName + " not found");
            }

            Bindings bindings = engine.createBindings();

            bindings.put("args", args);
            bindings.put("filter", filter);

            timer.start();
            Object ret = engine.eval(script, bindings);
            timer.end();

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

}
