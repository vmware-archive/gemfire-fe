package io.pivotal.bds.gemfire.mock;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.RegionService;
import org.apache.geode.cache.client.Pool;
import org.apache.geode.cache.execute.Execution;
import org.apache.geode.cache.execute.Function;
import org.apache.geode.distributed.DistributedMember;
import org.apache.geode.distributed.DistributedSystem;
import io.pivotal.bds.gemfire.util.FunctionServiceHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MockFunctionServiceHelper implements FunctionServiceHelper {

    private Map<String,Function> functions = new HashMap<>();

    public MockFunctionServiceHelper() {
    }

    public MockFunctionServiceHelper(Function function) {
        registerFunction(function);
    }

    @Override
    public Execution onRegion(Region region) {
        MockExecution mockExecution = new MockExecution(this);
        mockExecution.setRegion(region);
        return mockExecution;
    }

    @Override
    public Execution onServer(Pool pool) {
        MockExecution mockExecution = new MockExecution(this);
        return mockExecution;
    }

    @Override
    public Execution onServers(Pool pool) {
        MockExecution mockExecution = new MockExecution(this);
        return mockExecution;
    }

    @Override
    public Execution onServer(RegionService regionService) {
        MockExecution mockExecution = new MockExecution(this);
        return mockExecution;
    }

    @Override
    public Execution onServers(RegionService regionService) {
        MockExecution mockExecution = new MockExecution(this);
        return mockExecution;
    }

    @Override
    public Execution onMember(DistributedMember distributedMember) {
        MockExecution mockExecution = new MockExecution(this);
        return mockExecution;
    }

    @Override
    public Execution onMembers(String... groups) {
        MockExecution mockExecution = new MockExecution(this);
        return mockExecution;
    }

    @Override
    public Execution onMembers(Set<DistributedMember> distributedMembers) {
        MockExecution mockExecution = new MockExecution(this);
        return mockExecution;
    }

    @Override
    public Execution onMember(String... groups) {
        MockExecution mockExecution = new MockExecution(this);
        return mockExecution;
    }

    @Override
    public Function getFunction(String functionId) {
        Function f = functions.get(functionId);

        if (f == null) {
            throw new IllegalArgumentException("Function "+functionId+" does not exist");
        }

        return f;
    }

    @Override
    public void registerFunction(Function function) {
        String id = function.getId();
        if (functions.putIfAbsent(id,function) != null) {
            throw new IllegalArgumentException("Function "+id+" is already registered");
        }
    }

    @Override
    public void unregisterFunction(String functionId) {
        if (functions.remove(functionId) == null) {
            throw new IllegalArgumentException("Function "+functionId+" is not registered");
        }
    }

    @Override
    public boolean isRegistered(String functionId) {
        return functions.containsKey(functionId);
    }

    @Override
    public Map<String, Function> getRegisteredFunctions() {
        return functions;
    }
}
