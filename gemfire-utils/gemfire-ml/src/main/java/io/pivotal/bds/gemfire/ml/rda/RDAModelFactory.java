package io.pivotal.bds.gemfire.ml.rda;

import java.util.Properties;

import io.pivotal.bds.gemfire.ml.Model;
import io.pivotal.bds.gemfire.ml.ModelFactory;
import io.pivotal.bds.gemfire.ml.util.PropertiesSupport;

public class RDAModelFactory implements ModelFactory {

	private static final double DEFAULT_ALPHA = 1.0;
	private static final String[] PROPERTY_NAMES = { "alpha" };

	@Override
	public String[] getPropertyNames() {
		return PROPERTY_NAMES;
	}

	@Override
	public Model create(String name, String attributeName, Properties properties) {
		Double alpha = PropertiesSupport.getDoubleProperty(properties, "rda.alpha", DEFAULT_ALPHA);
		return new RDAModel(name, attributeName, alpha);
	}

}
