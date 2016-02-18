package io.pivotal.bds.gemfire.ml.regression;

import io.pivotal.bds.gemfire.ml.MetaModel;
import smile.math.kernel.MercerKernel;
import smile.regression.SVR;

public class SVRModel extends AbstractRegressionModel {

    private MercerKernel<double[]> kernel;
    private double eps;
    private double C;
    private double tol;

    private SVR<double[]> svr;

    public SVRModel(String id, MetaModel def, MercerKernel<double[]> kernel, double eps, double c, double tol) {
        super(id, def);
        this.kernel = kernel;
        this.eps = eps;
        C = c;
        this.tol = tol;
    }

    @Override
    public void train(double[][] x, double[] y) {
        svr = new SVR<>(x, y, kernel, eps, C, tol);
    }

    @Override
    public Double predict(double[] t) {
        return svr.predict(t);
    }

}
