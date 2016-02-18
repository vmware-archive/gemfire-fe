package io.pivotal.bds.gemfire.ml.classification;

import io.pivotal.bds.gemfire.ml.MetaModel;
import smile.classification.RDA;

public class RDAModel extends AbstractClassificationModel {

    private RDA rda;
    private double alpha;

    public RDAModel(String id, MetaModel def, double alpha) {
        super(id, def);
        this.alpha = alpha;
    }

    @Override
    public void train(double[][] x, int[] y) {
        rda = new RDA(x, y, alpha);
    }

    @Override
    public Integer predict(double[] x) {
        return rda.predict(x);
    }

}
