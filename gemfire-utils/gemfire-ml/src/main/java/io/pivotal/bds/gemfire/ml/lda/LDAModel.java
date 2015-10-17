package io.pivotal.bds.gemfire.ml.lda;

import io.pivotal.bds.gemfire.ml.AbstractModel;
import io.pivotal.bds.gemfire.ml.ModelType;
import smile.classification.LDA;

public class LDAModel extends AbstractModel {

	private LDA lda;
	private double tol;

	public LDAModel(String name, String attributeName, double tol) {
		super(name, attributeName, ModelType.lda);
		this.tol = tol;
	}

	@Override
	public void train(double[][] x, int[] y) {
		lda = new LDA(x, y, tol);
	}

	@Override
	public int predict(double[] x) {
		return lda.predict(x);
	}

}
