package io.pivotal.bds.gemfire.pmml.train.loader;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public class LoaderProperties {

    public String pmmlModelName = "test";
    public String pmmlModelFile = "pmml.xml";
}
