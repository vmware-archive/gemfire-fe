package io.pivotal.bds.gemfire.ml.classification;

import io.pivotal.bds.gemfire.ml.MetaModel;
import smile.classification.KNN;

public class KNNModel extends AbstractClassificationModel {

    private KNN<double[]> knn;
    private int k;

    public KNNModel(String id, MetaModel def, int k) {
        super(id, def);
        this.k = k;
    }

    @Override
    public void train(double[][] x, int[] y) {
        knn = KNN.learn(x, y, k);
    }

    @Override
    public Integer predict(double[] x) {
        return knn.predict(x);
    }

}
