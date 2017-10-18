package io.pivotal.bds.gemfire.keyfw.resolver;

import java.util.Properties;

import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.EntryOperation;
import org.apache.geode.cache.PartitionResolver;
import org.apache.geode.pdx.PdxInstance;

public class PdxInstancePartitionResolver<V> implements PartitionResolver<PdxInstance, V>, Declarable {

    @Override
    public void init(Properties props) {
    }

    @Override
    public void close() {
    }

    @Override
    public String getName() {
        return PdxInstancePartitionResolver.class.getName();
    }

    @Override
    public Object getRoutingObject(EntryOperation<PdxInstance, V> op) {
        PdxInstance key = op.getKey();
        return key.getField("colocationId");
    }

}
