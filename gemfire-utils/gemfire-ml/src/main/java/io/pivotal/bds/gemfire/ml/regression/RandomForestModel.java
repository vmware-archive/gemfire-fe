package io.pivotal.bds.gemfire.ml.regression;

import io.pivotal.bds.gemfire.ml.MetaModel;
import smile.regression.RandomForest;

public class RandomForestModel extends AbstractRegressionModel {

    private int T;
    private int M;
    private int S;

    private RandomForest rf;

    public RandomForestModel(String id, MetaModel def, int T, int M, int S) {
        super(id, def);
        this.T = T;
        this.M = M;
        this.S = S;
    }

    @Override
    public void train(double[][] x, double[] y) {
        rf = new RandomForest(x, y, T, M, S);
    }

    @Override
    public Double predict(double[] t) {
        return rf.predict(t);
    }

}
