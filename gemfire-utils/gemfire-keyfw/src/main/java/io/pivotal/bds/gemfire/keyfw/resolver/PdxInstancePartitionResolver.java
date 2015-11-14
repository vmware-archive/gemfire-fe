package io.pivotal.bds.gemfire.keyfw.resolver;

import java.util.Properties;

import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.EntryOperation;
import com.gemstone.gemfire.cache.PartitionResolver;
import com.gemstone.gemfire.pdx.PdxInstance;

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
