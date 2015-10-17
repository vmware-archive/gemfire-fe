package io.pivotal.bds.gemfire.ml.naivebayes;

import java.util.Properties;

import org.springframework.util.StringUtils;

import io.pivotal.bds.gemfire.ml.Model;
import io.pivotal.bds.gemfire.ml.ModelFactory;
import io.pivotal.bds.gemfire.ml.util.PropertiesSupport;
import smile.classification.NaiveBayes;

public class NaiveBayesModelFactory implements ModelFactory {

	private static final NaiveBayes.Model DEFAULT_NAIVE_BAYES_MODEL = NaiveBayes.Model.GENERAL;
	private static final int DEFAULT_K = 1;
	private static final int DEFAULT_P = 1;
	private static final double DEFAULT_SIGMA = 1.0;

	private static final String[] PROPERTY_NAMES = { "naiveBayesModel", "k", "p", "sigma" };

	@Override
	public String[] getPropertyNames() {
		return PROPERTY_NAMES;
	}

	@Override
	public Model create(String name, String attributeName, Properties properties) {
		String snbm = (String) properties.get("bayes.model");
		Integer k = PropertiesSupport.getIntegerProperty(properties, "bayes.k", DEFAULT_K);
		Integer p = PropertiesSupport.getIntegerProperty(properties, "bayes.p", DEFAULT_P);
		Double sigma = PropertiesSupport.getDoubleProperty(properties, "bayes.sigma", DEFAULT_SIGMA);

		NaiveBayes.Model nbm = StringUtils.hasText(snbm) ? NaiveBayes.Model.valueOf(snbm) : DEFAULT_NAIVE_BAYES_MODEL;

		return new NaiveBayesModel(name, attributeName, nbm, k, p, sigma);
	}
}
