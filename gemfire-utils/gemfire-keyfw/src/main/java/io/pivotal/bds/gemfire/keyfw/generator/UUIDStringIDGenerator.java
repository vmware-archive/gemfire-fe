package io.pivotal.bds.gemfire.keyfw.generator;

import java.util.UUID;

public class UUIDStringIDGenerator implements IDGenerator<String> {

	@Override
	public String generate(String domain) {
		return UUID.randomUUID().toString();
	}

}
