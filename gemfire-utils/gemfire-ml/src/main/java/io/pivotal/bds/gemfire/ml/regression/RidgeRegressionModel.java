package io.pivotal.bds.gemfire.ml.regression;

import io.pivotal.bds.gemfire.ml.MetaModel;
import smile.regression.RidgeRegression;

public class RidgeRegressionModel extends AbstractRegressionModel {

    private double lamdba;
    private RidgeRegression rr;

    public RidgeRegressionModel(String id, MetaModel def, double lamdba) {
        super(id, def);
        this.lamdba = lamdba;
    }

    @Override
    public void train(double[][] x, double[] y) {
        rr = new RidgeRegression(x, y, lamdba);
    }

    @Override
    public Double predict(double[] t) {
        return rr.predict(t);
    }

}
