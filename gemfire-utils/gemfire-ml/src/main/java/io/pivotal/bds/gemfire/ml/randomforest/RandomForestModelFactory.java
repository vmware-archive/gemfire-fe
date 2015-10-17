package io.pivotal.bds.gemfire.ml.randomforest;

import java.util.Properties;

import io.pivotal.bds.gemfire.ml.Model;
import io.pivotal.bds.gemfire.ml.ModelFactory;
import io.pivotal.bds.gemfire.ml.util.PropertiesSupport;

public class RandomForestModelFactory implements ModelFactory {

	private static final int DEFAULT_T = 1;
	private static final int DEFAULT_M = 1;
	private static final String[] PROPERTY_NAMES = { "T", "M" };

	@Override
	public String[] getPropertyNames() {
		return PROPERTY_NAMES;
	}

	@Override
	public Model create(String name, String attributeName, Properties properties) {
		Integer t = PropertiesSupport.getIntegerProperty(properties, "randomforest.T", DEFAULT_T);
		Integer m = PropertiesSupport.getIntegerProperty(properties, "randomforest.M", DEFAULT_M);
		return new RandomForestModel(name, attributeName, t, m);
	}

}
