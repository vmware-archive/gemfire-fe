package io.pivotal.bds.gemfire.ml;

import java.util.Arrays;
import java.util.Properties;

public class TrainingParameters {

    private String modelName;
    private ModelType type;
    private String attributeName;
    private double[][] x;
    private int[] y;
    private Properties properties;

    public TrainingParameters() {
    }

    public TrainingParameters(String modelName, ModelType type, String attributeName, double[][] x, int[] y,
            Properties properties) {
        this.modelName = modelName;
        this.type = type;
        this.attributeName = attributeName;
        this.x = x;
        this.y = y;
        this.properties = properties;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public ModelType getType() {
        return type;
    }

    public void setType(ModelType type) {
        this.type = type;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
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

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();

        buf.append("TrainingParameters [modelName=").append(modelName);
        buf.append(", type=").append(type);
        buf.append(", attributeName=").append(attributeName);
        buf.append(", properties=").append(properties);
        buf.append(", x=[");

        for (int i = 0; i < x.length; ++i) {
            if (i > 0) {
                buf.append(',');
            }

            buf.append(Arrays.toString(x[i]));
        }

        buf.append("], y=").append(Arrays.toString(y));

        return buf.toString();
    }

}
