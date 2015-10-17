package io.pivotal.bds.gemfire.ml.fld;

import io.pivotal.bds.gemfire.ml.AbstractModel;
import io.pivotal.bds.gemfire.ml.ModelType;
import smile.classification.FLD;

public class FLDModel extends AbstractModel {

    private FLD fld;
    private int L;
    private double tol;

    public FLDModel(String name, String attributeName, int l, double tol) {
        super(name, attributeName, ModelType.fld);
        L = l;
        this.tol = tol;
    }

    @Override
    public void train(double[][] x, int[] y) {
        fld = new FLD(x, y, L, tol);
    }

    @Override
    public int predict(double[] x) {
        return fld.predict(x);
    }

}
