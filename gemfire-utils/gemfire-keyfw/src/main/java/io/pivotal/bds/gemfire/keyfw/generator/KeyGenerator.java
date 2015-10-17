package io.pivotal.bds.gemfire.keyfw.generator;

import io.pivotal.bds.gemfire.key.BaseKey;

public interface KeyGenerator<T> {

	<K extends BaseKey<T>> K generate(Class<K> kc);
}
