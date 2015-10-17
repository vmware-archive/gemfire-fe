package io.pivotal.bds.gemfire.analytics.common;

import java.util.Arrays;

public class TrainingParameters {

    private TrainingParametersKey key;
    private double[][] x;
    private int[] y;

    public TrainingParameters() {
    }

    public TrainingParameters(TrainingParametersKey key, double[][] x, int[] y) {
        this.key = key;
        this.x = x;
        this.y = y;
    }

    public TrainingParametersKey getKey() {
        return key;
    }

    public void setKey(TrainingParametersKey key) {
        this.key = key;
    }

    public double[][] getX() {
        return x;
    }

    public void setX(double[][] x) {
        this.x = x;
    }

    public int[] getY() {
        return y;
    }

    public void setY(int[] y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "TrainingParameters [key=" + key + ", x=" + Arrays.toString(x) + ", y=" + Arrays.toString(y) + "]";
    }

}
