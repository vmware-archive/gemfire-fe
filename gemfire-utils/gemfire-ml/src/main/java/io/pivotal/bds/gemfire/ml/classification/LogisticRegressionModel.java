package io.pivotal.bds.gemfire.ml.classification;

import io.pivotal.bds.gemfire.ml.MetaModel;
import smile.classification.LogisticRegression;

public class LogisticRegressionModel extends AbstractClassificationModel {

    private LogisticRegression regression;
    private double lambda;
    private double tol;
    private int maxIter;

    public LogisticRegressionModel(String id, MetaModel def, double lambda, double tol, int maxIter) {
        super(id, def);
        this.lambda = lambda;
        this.tol = tol;
        this.maxIter = maxIter;
    }

    @Override
    public void train(double[][] x, int[] y) {
        regression = new LogisticRegression(x, y, lambda, tol, maxIter);
        getAttributes().put("loglikelihood", regression.loglikelihood());
    }

    @Override
    public Integer predict(double[] x) {
        return regression.predict(x);
    }

}
