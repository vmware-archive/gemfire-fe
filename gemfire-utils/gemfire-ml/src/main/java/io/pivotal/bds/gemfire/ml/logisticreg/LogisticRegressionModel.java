package io.pivotal.bds.gemfire.ml.logisticreg;

import io.pivotal.bds.gemfire.ml.AbstractModel;
import io.pivotal.bds.gemfire.ml.ModelType;
import smile.classification.LogisticRegression;

public class LogisticRegressionModel extends AbstractModel {

	private LogisticRegression regression;
	private double lambda;
	private double tol;
	private int maxIter;

	public LogisticRegressionModel(String name, String attributeName, double lambda, double tol, int maxIter) {
		super(name, attributeName, ModelType.logisticreg);
		this.lambda = lambda;
		this.tol = tol;
		this.maxIter = maxIter;
	}

	@Override
	public void train(double[][] x, int[] y) {
		regression = new LogisticRegression(x, y, lambda, tol, maxIter);
	}

	@Override
	public int predict(double[] x) {
		return regression.predict(x);
	}

}
