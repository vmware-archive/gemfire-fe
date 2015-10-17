package io.pivotal.bds.gemfire.ml.knn;

import java.util.Properties;

import io.pivotal.bds.gemfire.ml.Model;
import io.pivotal.bds.gemfire.ml.ModelFactory;
import io.pivotal.bds.gemfire.ml.util.PropertiesSupport;

public class KNNModelFactory implements ModelFactory {

	private static final int DEFAULT_K = 10;
	private static final String[] PROPERTY_NAMES = { "k" };

	@Override
	public String[] getPropertyNames() {
		return PROPERTY_NAMES;
	}

	@Override
	public Model create(String name, String attributeName, Properties properties) {
		Integer k = PropertiesSupport.getIntegerProperty(properties, "knn.k", DEFAULT_K);
		return new KNNModel(name, attributeName, k);
	}

}
