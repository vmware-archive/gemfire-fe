package io.pivotal.bds.gemfire.keyfw.resolver;

import java.util.Properties;

import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.EntryOperation;
import org.apache.geode.cache.PartitionResolver;

import io.pivotal.bds.gemfire.key.ColocationID;

public class ColocationIDPartitionResolver<K extends ColocationID<?>, V> implements PartitionResolver<K, V>, Declarable {

	public ColocationIDPartitionResolver() {
	}

	@Override
	public void close() {
	}

	@Override
	public String getName() {
		return getClass().getName();
	}

	@Override
	public Object getRoutingObject(EntryOperation<K, V> opDetails) {
		return opDetails.getKey().getColocationId();
	}

    @Override
    public void init(Properties props) {
    }

}
