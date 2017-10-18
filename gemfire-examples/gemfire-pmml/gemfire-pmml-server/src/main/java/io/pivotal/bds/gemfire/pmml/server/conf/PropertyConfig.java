package io.pivotal.bds.gemfire.pmml.server.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public class PropertyConfig {

	public String locators = "localhost[10334]";
	public int port = 40404;
}
