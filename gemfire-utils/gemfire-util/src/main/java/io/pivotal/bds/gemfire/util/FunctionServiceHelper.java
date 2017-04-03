package io.pivotal.bds.gemfire.util;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.RegionService;
import com.gemstone.gemfire.cache.client.Pool;
import com.gemstone.gemfire.cache.execute.Execution;
import com.gemstone.gemfire.cache.execute.Function;
import com.gemstone.gemfire.cache.execute.FunctionService;
import com.gemstone.gemfire.distributed.DistributedMember;
import com.gemstone.gemfire.distributed.DistributedSystem;

import java.util.Map;
import java.util.Set;

public interface FunctionServiceHelper {

    Execution onRegion(Region region);

    Execution onServer(Pool pool);

    Execution onServers(Pool pool);

    Execution onServer(RegionService regionService);

    Execution onServers(RegionService regionService);

    Execution onMember(DistributedSystem system, DistributedMember distributedMember);

    Execution onMembers(DistributedSystem system);

    Execution onMembers(DistributedSystem system, Set<DistributedMember> distributedMembers);

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
