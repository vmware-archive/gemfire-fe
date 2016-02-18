package io.pivotal.bds.gemfire.ml.regression;

import io.pivotal.bds.gemfire.ml.MetaModel;
import smile.regression.LASSO;

public class LASSOModel extends AbstractRegressionModel {

    private double lambda;
    private double tol;
    private int maxIter;

    private LASSO lasso;

    public LASSOModel(String id, MetaModel def, double lambda, double tol, int maxIter) {
        super(id, def);
        this.lambda = lambda;
        this.tol = tol;
        this.maxIter = maxIter;
    }

    @Override
    public void train(double[][] x, double[] y) {
        lasso = new LASSO(x, y, lambda, tol, maxIter);
    }

    @Override
    public Double predict(double[] t) {
        return lasso.predict(t);
    }

}
