package io.pivotal.bds.gemfire.ml.rda;

import io.pivotal.bds.gemfire.ml.AbstractModel;
import io.pivotal.bds.gemfire.ml.ModelType;
import smile.classification.RDA;

public class RDAModel extends AbstractModel {

	private RDA rda;
	private double alpha;

	public RDAModel(String name, String attributeName, double alpha) {
		super(name, attributeName, ModelType.rda);
		this.alpha = alpha;
	}

	@Override
	public void train(double[][] x, int[] y) {
		rda = new RDA(x, y, alpha);
	}

	@Override
	public int predict(double[] x) {
		return rda.predict(x);
	}

}
