package io.pivotal.bds.gemfire.ml.randomforest;

import io.pivotal.bds.gemfire.ml.AbstractModel;
import io.pivotal.bds.gemfire.ml.ModelType;
import smile.classification.RandomForest;

public class RandomForestModel extends AbstractModel {

	private RandomForest forest;
	private int T;
	private int M;

	public RandomForestModel(String name, String attributeName, int t, int m) {
		super(name, attributeName, ModelType.randomforest);
		T = t;
		M = m;
	}

	@Override
	public void train(double[][] x, int[] y) {
		forest = new RandomForest(x, y, T, M);
	}

	@Override
	public int predict(double[] x) {
		return forest.predict(x);
	}

}
