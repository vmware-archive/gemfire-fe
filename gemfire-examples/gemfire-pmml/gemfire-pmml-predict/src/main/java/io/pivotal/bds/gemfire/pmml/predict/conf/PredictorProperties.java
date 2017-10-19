package io.pivotal.bds.gemfire.pmml.predict.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public class PredictorProperties {

    public String csvFileName = "creditcard.csv";
    public boolean useFunction = false;
}
