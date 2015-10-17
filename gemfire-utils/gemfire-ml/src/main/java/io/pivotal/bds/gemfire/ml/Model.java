package io.pivotal.bds.gemfire.ml;

public interface Model {

    String getName();
    
    String getAttributeName();

    ModelType getType();

    void train(double[][] x, int[] y);

    int predict(double[] x);
}
