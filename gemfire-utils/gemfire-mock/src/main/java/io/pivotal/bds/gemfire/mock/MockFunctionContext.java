package io.pivotal.bds.gemfire.mock;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.execute.RegionFunctionContext;
import com.gemstone.gemfire.cache.execute.ResultSender;

import java.util.Set;

public class MockFunctionContext implements RegionFunctionContext {

    private Set<?> filter;
    private Region<?, ?> region;
    private Object arguments;
    private String functionId;
    private ResultSender<?> sender;
    private MockFunctionServiceHelper helper;

    public MockFunctionContext(Set<?> filter, Region<?, ?> region, Object arguments, String functionId, ResultSender<?> sender, MockFunctionServiceHelper helper) {
        this.filter = filter;
        this.region = region;
        this.arguments = arguments;
        this.functionId = functionId;
        this.sender = sender;
        this.helper = helper;
    }

    public MockFunctionServiceHelper getHelper() {
        return helper;
    }

    public Region<?, ?> getRegion() {
        return region;
    }

    public ResultSender<?> getSender() {
        return sender;
    }

    @Override
    public Set<?> getFilter() {
        return this.filter;
    }

    @Override
    public <K, V> Region<K, V> getDataSet() {
        return (Region<K, V>) this.region;
    }

    @Override
    public Object getArguments() {
        return this.arguments;
    }

    @Override
    public String getFunctionId() {
        return this.functionId;
    }

    @Override
    public <T> ResultSender<T> getResultSender() {
        return (ResultSender<T>) this.sender;
    }

    @Override
    public boolean isPossibleDuplicate() {
        return false;
    }
}
