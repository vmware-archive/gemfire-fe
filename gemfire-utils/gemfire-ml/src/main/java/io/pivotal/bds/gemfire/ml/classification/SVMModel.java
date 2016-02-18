package io.pivotal.bds.gemfire.ml.classification;

import io.pivotal.bds.gemfire.ml.MetaModel;
import smile.classification.SVM;

public class SVMModel extends AbstractClassificationModel {

    private SVM<double[]> svm;

    public SVMModel(String id, MetaModel def, SVM<double[]> svm) {
        super(id, def);
        this.svm = svm;
    }

    @Override
    public void train(double[][] x, int[] y) {
        svm.learn(x, y);
    }

    @Override
    public Integer predict(double[] x) {
        return svm.predict(x);
    }

}
