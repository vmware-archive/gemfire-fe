package io.pivotal.bds.gemfire.keyfw.resolver;

import com.gemstone.gemfire.cache.EntryOperation;
import com.gemstone.gemfire.cache.PartitionResolver;

import io.pivotal.bds.gemfire.key.ColocationID;

public class ColocationIDPartitionResolver<K extends ColocationID<?>, V> implements PartitionResolver<K, V> {

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

}
