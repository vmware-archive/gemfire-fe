package io.pivotal.bds.gemfire.keyfw.generator;

import io.pivotal.bds.gemfire.key.BaseColocationKey;

public class DefaultColocationKeyGenerator<T, C> implements ColocationKeyGenerator<T, C> {

	private IDGenerator<T> generator;

	public DefaultColocationKeyGenerator(IDGenerator<T> generator) {
		this.generator = generator;
	}

	@Override
	public <K extends BaseColocationKey<T, C>> K generate(Class<K> kc, C colocationId) {
		try {
			T id = generator.generate(kc.getName());

			K k = kc.newInstance();

			k.setId(id);
			k.setColocationId(colocationId);

			return k;
		} catch (Exception x) {
			throw new IllegalArgumentException(x.toString(), x);
		}
	}

}
