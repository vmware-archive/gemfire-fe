package io.pivotal.bds.gemfire.ml.knn;

import io.pivotal.bds.gemfire.ml.AbstractModel;
import io.pivotal.bds.gemfire.ml.ModelType;
import smile.classification.KNN;


public class KNNModel extends AbstractModel {

    private KNN<double[]> knn;
    private int k;

    public KNNModel(String name, String attributeName, int k) {
        super(name, attributeName, ModelType.knn);
        this.k = k;
    }

    @Override
    public void train(double[][] x, int[] y) {
        knn = KNN.learn(x, y, k);
    }

    @Override
    public int predict(double[] x) {
        return knn.predict(x);
    }

}
