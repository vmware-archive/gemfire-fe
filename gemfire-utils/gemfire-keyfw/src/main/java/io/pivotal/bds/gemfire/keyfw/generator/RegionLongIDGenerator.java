package io.pivotal.bds.gemfire.keyfw.generator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.Region;

public class RegionLongIDGenerator implements IDGenerator<Long> {

	private Region<String, Long> region;

	private static final Logger LOG = LoggerFactory.getLogger(RegionLongIDGenerator.class);

	public RegionLongIDGenerator(Region<String, Long> region) {
		this.region = region;
	}

	@Override
	public synchronized Long generate(String domain) {
		LOG.debug("generating id for domain={}", domain);

		Long l = region.get(domain);
		l = l.longValue() + 1L;
		LOG.debug("generating id for domain={}, id={}", domain, l);

		region.put(domain, l);

		return l;
	}
}
