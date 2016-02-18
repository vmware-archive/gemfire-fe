package io.pivotal.bds.gemfire.ml.regression;

import io.pivotal.bds.gemfire.ml.MetaModel;
import smile.regression.OLS;

public class OLSModel extends AbstractRegressionModel {

    private OLS ols;

    public OLSModel(String id, MetaModel def) {
        super(id, def);
    }

    @Override
    public void train(double[][] x, double[] y) {
        ols = new OLS(x, y);
    }

    @Override
    public Double predict(double[] t) {
        return ols.predict(t);
    }

}
