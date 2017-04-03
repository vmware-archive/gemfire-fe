package io.pivotal.bds.gemfire.mock;

import com.gemstone.gemfire.cache.execute.Function;
import com.gemstone.gemfire.cache.execute.FunctionContext;
import com.gemstone.gemfire.cache.execute.RegionFunctionContext;
import com.gemstone.gemfire.cache.execute.ResultSender;

public class TestFunction implements Function {

    @Override
    public boolean hasResult() {
        return true;
    }

    @Override
    public void execute(FunctionContext functionContext) {
        RegionFunctionContext regionFunctionContext = (RegionFunctionContext)functionContext;

        ResultSender<Object> sender = regionFunctionContext.getResultSender();

        sender.sendResult(regionFunctionContext.getArguments());
        sender.sendResult(regionFunctionContext.getFunctionId());
        sender.sendResult(regionFunctionContext.getDataSet());
        sender.lastResult(regionFunctionContext.getFilter());
        sender.sendException(new Exception());
    }

    @Override
    public String getId() {
        return getClass().getSimpleName();
    }

    @Override
    public boolean optimizeForWrite() {
        return false;
    }

    @Override
    public boolean isHA() {
        return false;
    }
}
