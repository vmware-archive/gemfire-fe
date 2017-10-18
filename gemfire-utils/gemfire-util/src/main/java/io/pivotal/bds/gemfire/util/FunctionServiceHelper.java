package io.pivotal.bds.gemfire.util;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.RegionService;
import org.apache.geode.cache.client.Pool;
import org.apache.geode.cache.execute.Execution;
import org.apache.geode.cache.execute.Function;
import org.apache.geode.distributed.DistributedMember;

import java.util.Map;
import java.util.Set;

@SuppressWarnings("rawtypes")
public interface FunctionServiceHelper {

    Execution onRegion(Region region);

    Execution onServer(Pool pool);

    Execution onServers(Pool pool);

    Execution onServer(RegionService regionService);

    Execution onServers(RegionService regionService);

    Execution onMember(DistributedMember distributedMember);

    Execution onMembers(String... groups);

    Execution onMembers(Set<DistributedMember> distributedMembers);

    Execution onMember(String... groups);

    Function getFunction(String functionId);

    void registerFunction(Function function);

    void unregisterFunction(String functionId);

    boolean isRegistered(String functionId);

    Map<String, Function> getRegisteredFunctions();
}
