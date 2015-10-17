package io.pivotal.bds.gemfire.ml.logisticreg;

import java.util.Properties;

import io.pivotal.bds.gemfire.ml.Model;
import io.pivotal.bds.gemfire.ml.ModelFactory;
import io.pivotal.bds.gemfire.ml.util.PropertiesSupport;

public class LogisticRegressionModelFactory implements ModelFactory {

	private static final double DEFAULT_LAMBDA = 1.0;
	private static final double DEFAULT_TOL = 1.0;
	private static final int DEFAULT_MAXITER = 10;
	private static final String[] PROPERTY_NAMES = { "lambda", "tol", "maxIter" };

	@Override
	public String[] getPropertyNames() {
		return PROPERTY_NAMES;
	}

	@Override
	public Model create(String name, String attributeName, Properties properties) {
		Double lambda = PropertiesSupport.getDoubleProperty(properties, "logisticregression.lambda", DEFAULT_LAMBDA);
		Double tol = PropertiesSupport.getDoubleProperty(properties, "logisticregression.tol", DEFAULT_TOL);
		Integer maxIter = PropertiesSupport.getIntegerProperty(properties, "logisticregression.maxIter",
				DEFAULT_MAXITER);
		return new LogisticRegressionModel(name, attributeName, lambda, tol, maxIter);
	}

}
