package io.pivotal.bds.gemfire.mock;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.execute.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by tdalsing on 3/23/17.
 */
public class MockExecution implements Execution {

    private Set<?> filter;
    private Object args;
    private ResultCollector<?, ?> collector;
    private ResultSender<?> sender;
    private MockFunctionServiceHelper helper;
    private Region<?, ?> region;

    public MockExecution(MockFunctionServiceHelper helper) {
        this.helper = helper;
    }

    public Region<?, ?> getRegion() {
        return region;
    }

    public void setRegion(Region<?, ?> region) {
        this.region = region;
    }

    @Override
    public Execution withFilter(Set<?> set) {
        if (region == null) {
            throw new IllegalArgumentException("Filter can only be used with onRegion");
        }
        this.filter = set;
        return this;
    }

    @Override
    public Execution withArgs(Object o) {
        this.args = o;
        return this;
    }

    @Override
    public Execution withCollector(ResultCollector<?, ?> resultCollector) {
        this.collector = resultCollector;
        return this;
    }

    private MockFunctionContext createContext(String functionId) {
        List<Object> results = new ArrayList<>();
        sender = new MockResultSender<>(results);

        if (collector == null) {
            collector = new MockResultCollector<>();
        }

        ((MockResultCollector)collector).setResults(results);

        return new MockFunctionContext(filter,region,args,functionId,sender,helper);
    }

    @Override
    public ResultCollector<?, ?> execute(String s) throws FunctionException {
        Function f = helper.getFunction(s);
        MockFunctionContext mockFunctionContext = createContext(s);
        f.execute(mockFunctionContext);
        return collector;
    }

    @Override
    public ResultCollector<?, ?> execute(Function function) throws FunctionException {
        MockFunctionContext mockFunctionContext = createContext(function.getId());
        function.execute(mockFunctionContext);
        return collector;
    }

    @Override
    public ResultCollector<?, ?> execute(String s, boolean b) throws FunctionException {
        Function f = helper.getFunction(s);
        MockFunctionContext mockFunctionContext = createContext(s);
        f.execute(mockFunctionContext);
        return collector;
    }

    @Override
    public ResultCollector<?, ?> execute(String s, boolean b, boolean b1) throws FunctionException {
        Function f = helper.getFunction(s);
        MockFunctionContext mockFunctionContext = createContext(s);
        f.execute(mockFunctionContext);
        return collector;
    }

    @Override
    public ResultCollector<?, ?> execute(String s, boolean b, boolean b1, boolean b2) throws FunctionException {
        Function f = helper.getFunction(s);
        MockFunctionContext mockFunctionContext = createContext(s);
        f.execute(mockFunctionContext);
        return collector;
    }
}
