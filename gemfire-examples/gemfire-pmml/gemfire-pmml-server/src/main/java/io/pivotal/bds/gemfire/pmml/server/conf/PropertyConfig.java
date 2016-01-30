package io.pivotal.bds.gemfire.pmml.server.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertyConfig {

	@Value("${locators:localhost[10334]}")
	public String locators;
	
    @Value("${port:40404}")
	public int port;
}
