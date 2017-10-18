package io.pivotal.bds.gemfire.pmml.train.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public class GemfireProperties {

    public String locators = "localhost[10334]";
}
