package io.pivotal.bds.gemfire.ml.regression;

import io.pivotal.bds.gemfire.ml.MetaModel;
import smile.math.kernel.MercerKernel;
import smile.regression.GaussianProcessRegression;

public class GaussianProcessRegressionModel extends AbstractRegressionModel {

    private GaussianProcessRegression<double[]> gpr;
    private MercerKernel<double[]> kernel;
    private double lambda;

    public GaussianProcessRegressionModel(String id, MetaModel def, MercerKernel<double[]> kernel, double lambda) {
        super(id, def);
    }

    @Override
    public void train(double[][] x, double[] y) {
        gpr = new GaussianProcessRegression<>(x, y, kernel, lambda);
    }

    @Override
    public Double predict(double[] t) {
        return gpr.predict(t);
    }

}
