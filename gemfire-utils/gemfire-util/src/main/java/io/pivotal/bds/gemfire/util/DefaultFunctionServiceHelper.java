package io.pivotal.bds.gemfire.util;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.RegionService;
import org.apache.geode.cache.client.Pool;
import org.apache.geode.cache.execute.Execution;
import org.apache.geode.cache.execute.Function;
import org.apache.geode.cache.execute.FunctionService;
import org.apache.geode.distributed.DistributedMember;

import java.util.Map;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class DefaultFunctionServiceHelper implements FunctionServiceHelper {

    @Override
    public Execution onRegion(Region region) {
        return FunctionService.onRegion(region);
    }

    @Override
    public Execution onServer(Pool pool) {
        return FunctionService.onServer(pool);
    }

    @Override
    public Execution onServers(Pool pool) {
        return FunctionService.onServers(pool);
    }

    @Override
    public Execution onServer(RegionService regionService) {
        return FunctionService.onServer(regionService);
    }

    @Override
    public Execution onServers(RegionService regionService) {
        return FunctionService.onServers(regionService);
    }

    @Override
    public Execution onMember(DistributedMember distributedMember) {
        return FunctionService.onMember(distributedMember);
    }

    @Override
    public Execution onMembers(String... groups) {
        return FunctionService.onMembers(groups);
    }

    @Override
    public Execution onMembers(Set<DistributedMember> distributedMembers) {
        return FunctionService.onMembers(distributedMembers);
    }

    @Override
    public Execution onMember(String... groups) {
        return FunctionService.onMember(groups);
    }

    @Override
    public Function getFunction(String functionId) {
        return FunctionService.getFunction(functionId);
    }

    @Override
    public void registerFunction(Function function) {
        FunctionService.registerFunction(function);
    }

    @Override
    public void unregisterFunction(String functionId) {
        FunctionService.unregisterFunction(functionId);
    }

    @Override
    public boolean isRegistered(String functionId) {
        return FunctionService.isRegistered(functionId);
    }

    @Override
    public Map<String, Function> getRegisteredFunctions() {
        return FunctionService.getRegisteredFunctions();
    }
}
