package io.pivotal.bds.gemfire.ml.regression;

import io.pivotal.bds.gemfire.ml.MetaModel;
import smile.math.distance.Metric;
import smile.math.rbf.RadialBasisFunction;
import smile.regression.RBFNetwork;

public class RBFNetworkModel extends AbstractRegressionModel {

    private Metric<double[]> distance;
    private RadialBasisFunction rbfunc;
    private double[][] centers;
    private boolean normalized;

    private RBFNetwork<double[]> rbf;

    public RBFNetworkModel(String id, MetaModel def, Metric<double[]> distance, RadialBasisFunction rbfunc, double[][] centers,
            boolean normalized) {
        super(id, def);
        this.distance = distance;
        this.rbfunc = rbfunc;
        this.centers = centers;
        this.normalized = normalized;
    }

    @Override
    public void train(double[][] x, double[] y) {
        rbf = new RBFNetwork<>(x, y, distance, rbfunc, centers, normalized);
    }

    @Override
    public Double predict(double[] t) {
        return rbf.predict(t);
    }

}
