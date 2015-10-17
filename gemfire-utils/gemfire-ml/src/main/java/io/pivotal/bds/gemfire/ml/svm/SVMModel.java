package io.pivotal.bds.gemfire.ml.svm;

import io.pivotal.bds.gemfire.ml.AbstractModel;
import io.pivotal.bds.gemfire.ml.ModelType;
import smile.classification.SVM;

public class SVMModel extends AbstractModel {

	private SVM<double[]> svm;

	public SVMModel(String name, String attributeName, SVM<double[]> svm) {
		super(name, attributeName, ModelType.svm);
		this.svm = svm;
	}

	@Override
	public void train(double[][] x, int[] y) {
		svm.learn(x, y);
	}

	@Override
	public int predict(double[] x) {
		return svm.predict(x);
	}

}
