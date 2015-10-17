package io.pivotal.bds.gemfire.keyfw.generator;

import io.pivotal.bds.gemfire.key.BaseColocationKey;

public interface ColocationKeyGenerator<T, C> {

	<K extends BaseColocationKey<T, C>> K generate(Class<K> kc, C colocationId);
}
