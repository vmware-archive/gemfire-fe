package io.pivotal.bds.gemfire.ml.regression;

import io.pivotal.bds.gemfire.ml.MetaModel;
import smile.regression.GradientTreeBoost;
import smile.regression.GradientTreeBoost.Loss;

public class GradientTreeBoostModel extends AbstractRegressionModel {

    private GradientTreeBoost gtb;
    private GradientTreeBoost.Loss loss;
    private int ntrees;
    private int maxNodes;
    private double shrinkage;
    private double f;

    public GradientTreeBoostModel(String id, MetaModel def, Loss loss, int ntrees, int maxNodes, double shrinkage, double f) {
        super(id, def);
        this.loss = loss;
        this.ntrees = ntrees;
        this.maxNodes = maxNodes;
        this.shrinkage = shrinkage;
        this.f = f;
    }

    @Override
    public void train(double[][] x, double[] y) {
        gtb = new GradientTreeBoost(x, y, loss, ntrees, maxNodes, shrinkage, f);
    }

    @Override
    public Double predict(double[] t) {
        return gtb.predict(t);
    }

}
