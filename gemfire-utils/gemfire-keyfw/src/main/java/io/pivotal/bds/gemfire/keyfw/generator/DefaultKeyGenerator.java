package io.pivotal.bds.gemfire.keyfw.generator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.pivotal.bds.gemfire.key.BaseKey;

public class DefaultKeyGenerator<T> implements KeyGenerator<T> {

	private IDGenerator<T> generator;

	private static final Logger LOG = LoggerFactory.getLogger(DefaultKeyGenerator.class);

	public DefaultKeyGenerator(IDGenerator<T> generator) {
		this.generator = generator;
	}

	@Override
	public <K extends BaseKey<T>> K generate(Class<K> kc) {
		LOG.debug("creating key: kc={}", kc);

		try {
			T id = generator.generate(kc.getName());
			LOG.debug("creating key: kc={}, generated id={}", kc, id);

			K k = kc.newInstance();
			k.setId(id);
			LOG.debug("creating key: kc={}, generated key={}", kc, k);

			return k;
		} catch (Exception x) {
			throw new IllegalArgumentException(x.toString(), x);
		}
	}

}
