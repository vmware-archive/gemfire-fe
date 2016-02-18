package io.pivotal.bds.gemfire.ml.classification;

import io.pivotal.bds.gemfire.ml.MetaModel;
import smile.classification.FLD;

public class FLDModel extends AbstractClassificationModel {

    private FLD fld;
    private int L;
    private double tol;

    public FLDModel(String id, MetaModel def, int l, double tol) {
        super(id, def);
        L = l;
        this.tol = tol;
    }

    @Override
    public void train(double[][] x, int[] y) {
        fld = new FLD(x, y, L, tol);
        getAttributes().put("projection", fld.getProjection());
    }

    @Override
    public Integer predict(double[] x) {
        return fld.predict(x);
    }

}
