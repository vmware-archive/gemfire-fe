package io.pivotal.bds.gemfire.analytics.server.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertyConfig {

	@Value("${locators:localhost[10334]}")
	public String locators;

    @Value("${svm-soft-margin:1.0}")
    public double svmSoftMargin;

    @Value("${svm-sigma:1.0}")
    public double svmSigma;
}
