package io.pivotal.bds.gemfire.ml.classification;

import io.pivotal.bds.gemfire.ml.MetaModel;
import smile.classification.NaiveBayes;

public class NaiveBayesModel extends AbstractClassificationModel {

    private NaiveBayes bayes;

    public NaiveBayesModel(String id, MetaModel def, NaiveBayes.Model nbm, int k, int p, double sigma) {
        super(id, def);
        bayes = new NaiveBayes(nbm, k, p, sigma);
    }

    @Override
    public void train(double[][] x, int[] y) {
        bayes.learn(x, y);
    }

    @Override
    public Integer predict(double[] x) {
        return bayes.predict(x);
    }

}
