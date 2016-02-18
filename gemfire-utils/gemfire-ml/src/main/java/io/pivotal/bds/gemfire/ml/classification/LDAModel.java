package io.pivotal.bds.gemfire.ml.classification;

import io.pivotal.bds.gemfire.ml.MetaModel;
import smile.classification.LDA;

public class LDAModel extends AbstractClassificationModel {

    private LDA lda;
    private double tol;

    public LDAModel(String id, MetaModel def, double tol) {
        super(id, def);
        this.tol = tol;
    }

    @Override
    public void train(double[][] x, int[] y) {
        lda = new LDA(x, y, tol);
        getAttributes().put("priori", lda.getPriori());
    }

    @Override
    public Integer predict(double[] x) {
        return lda.predict(x);
    }

}
