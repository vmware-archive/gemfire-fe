package io.pivotal.bds.gemfire.pmml.train.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public class LoaderProperties {

    public String pmmlModelName = "test";
    public String pmmlModelFile = "gbm.xml";
}
