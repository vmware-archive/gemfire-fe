package io.pivotal.bds.gemfire.ml.regression;

import io.pivotal.bds.gemfire.ml.MetaModel;
import smile.regression.RegressionTree;

public class RegressionTreeModel extends AbstractRegressionModel {

    private int J;

    private RegressionTree rt;

    public RegressionTreeModel(String id, MetaModel def, int j) {
        super(id, def);
        J = j;
    }

    @Override
    public void train(double[][] x, double[] y) {
        rt = new RegressionTree(x, y, J);
    }

    @Override
    public Double predict(double[] t) {
        return rt.predict(t);
    }

}
