package io.pivotal.bds.gemfire.ml;

import java.util.Arrays;

public class PredictionParameters {

    private String modelName;
    private double[] x;

    public PredictionParameters() {
    }

    public PredictionParameters(String modelName, double[] x) {
        this.modelName = modelName;
        this.x = x;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public double[] getX() {
        return x;
    }

    public void setX(double[] x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "PredictionParameters [modelName=" + modelName + ", x=" + Arrays.toString(x) + "]";
    }

}
