package io.pivotal.bds.gemfire.ml.classification;

import io.pivotal.bds.gemfire.ml.MetaModel;
import smile.classification.RandomForest;

public class RandomForestModel extends AbstractClassificationModel {

    private RandomForest forest;
    private int T;
    private int M;

    public RandomForestModel(String id, MetaModel def, int t, int m) {
        super(id, def);
        T = t;
        M = m;
    }

    @Override
    public void train(double[][] x, int[] y) {
        forest = new RandomForest(x, y, T, M);
    }

    @Override
    public Integer predict(double[] x) {
        return forest.predict(x);
    }

}
