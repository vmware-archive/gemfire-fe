package io.pivotal.bds.gemfire.ml.naivebayes;

import io.pivotal.bds.gemfire.ml.AbstractModel;
import io.pivotal.bds.gemfire.ml.ModelType;
import smile.classification.NaiveBayes;

public class NaiveBayesModel extends AbstractModel {

	private NaiveBayes bayes;

	public NaiveBayesModel(String name, String attributeName, NaiveBayes.Model nbm, int k, int p, double sigma) {
		super(name, attributeName, ModelType.naivebayes);
		bayes = new NaiveBayes(nbm, k, p, sigma);
	}

	@Override
	public void train(double[][] x, int[] y) {
		bayes.learn(x, y);
	}

	@Override
	public int predict(double[] x) {
		return bayes.predict(x);
	}

}
