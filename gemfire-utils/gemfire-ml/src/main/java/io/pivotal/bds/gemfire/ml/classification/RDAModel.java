package io.pivotal.bds.gemfire.ml.classification;

import io.pivotal.bds.gemfire.ml.MetaModel;
import smile.classification.RDA;

public class RDAModel extends AbstractClassificationModel {

    private RDA rda;
    private double[] priori;
    private double alpha;
    private double tol;

    public RDAModel(String id, MetaModel def, double[] priori, double alpha, double tol) {
        super(id, def);
        this.priori = priori;
        this.alpha = alpha;
        this.tol = tol;
    }

    @Override
    public void train(double[][] x, int[] y) {
        rda = new RDA(x, y, priori, alpha, tol);
    }

    @Override
    public Integer predict(double[] x) {
        return rda.predict(x);
    }

}
