package io.pivotal.bds.gemfire.ml.svm;

import java.util.Properties;

import io.pivotal.bds.gemfire.ml.Model;
import io.pivotal.bds.gemfire.ml.ModelFactory;
import io.pivotal.bds.gemfire.ml.util.PropertiesSupport;
import smile.classification.SVM;
import smile.math.kernel.GaussianKernel;

public class SVMModelFactory implements ModelFactory {

	private static final double DEFAULT_SIGMA = 1.0;
	private static final double DEFAULT_CP = 1.0;
	private static final double DEFAULT_CN = 1.0;

	private static final String[] PROPERTY_NAMES = { "sigma", "cp", "cn" };

	@Override
	public Model create(String name, String attributeName, Properties properties) {
		Double sigma = PropertiesSupport.getDoubleProperty(properties, "svm.sigma", DEFAULT_SIGMA);
		Double cp = PropertiesSupport.getDoubleProperty(properties, "svm.cp", DEFAULT_CP);
		Double cn = PropertiesSupport.getDoubleProperty(properties, "svm.cn", DEFAULT_CN);

		SVM<double[]> svm = new SVM<double[]>(new GaussianKernel(sigma), cp, cn);
		return new SVMModel(name, attributeName, svm);
	}

	@Override
	public String[] getPropertyNames() {
		return PROPERTY_NAMES;
	}
}
