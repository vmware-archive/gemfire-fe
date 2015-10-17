package io.pivotal.bds.gemfire.ml.lda;

import java.util.Properties;

import io.pivotal.bds.gemfire.ml.Model;
import io.pivotal.bds.gemfire.ml.ModelFactory;
import io.pivotal.bds.gemfire.ml.util.PropertiesSupport;

public class LDAModelFactory implements ModelFactory {

	private static final double DEFAULT_TOL = 1.0;

	private static final String[] PROPERTY_NAMES = { "tol" };

	@Override
	public String[] getPropertyNames() {
		return PROPERTY_NAMES;
	}

	@Override
	public Model create(String name, String attributeName, Properties properties) {
		Double tol = PropertiesSupport.getDoubleProperty(properties, "lda.tol", DEFAULT_TOL);
		return new LDAModel(name, attributeName, tol);
	}

}
