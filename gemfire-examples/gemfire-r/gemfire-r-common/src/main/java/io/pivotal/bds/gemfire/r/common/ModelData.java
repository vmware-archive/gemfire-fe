package io.pivotal.bds.gemfire.r.common;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;

import org.apache.geode.DataSerializable;
import org.apache.geode.DataSerializer;

@SuppressWarnings("serial")
public class ModelData implements DataSerializable {

    private ModelKey key;
    private ModelDefKey modelDefKey;
    private double[][] x;
    private Number[] y;

    public ModelData() {
    }

    public ModelData(ModelKey key, ModelDefKey modelDefKey, double[][] x, Number[] y) {
        this.key = key;
        this.modelDefKey = modelDefKey;
        this.x = x;
        this.y = y;
    }

    public ModelKey getKey() {
        return key;
    }

    public void setKey(ModelKey key) {
        this.key = key;
    }

    public ModelDefKey getModelDefKey() {
        return modelDefKey;
    }

    public void setModelDefKey(ModelDefKey modelDefKey) {
        this.modelDefKey = modelDefKey;
    }

    public double[][] getX() {
        return x;
    }

    public void setX(double[][] x) {
        this.x = x;
    }

    public Number[] getY() {
        return y;
    }

    public void setY(Number[] y) {
        this.y = y;
    }

    @Override
    public void fromData(DataInput input) throws IOException, ClassNotFoundException {
        key = new ModelKey();
        key.fromData(input);
        modelDefKey = new ModelDefKey();
        modelDefKey.fromData(input);
        x = DataSerializer.readObject(input);
        y = DataSerializer.readObject(input);
    }

    @Override
    public void toData(DataOutput output) throws IOException {
        key.toData(output);
        modelDefKey.toData(output);
        DataSerializer.writeObject(x, output);
        DataSerializer.writeObject(y, output);
    }

    @Override
    public String toString() {
        return "ModelData [key=" + key + ", modelDefKey=" + modelDefKey + ", x=" + Arrays.toString(x) + ", y=" + Arrays.toString(y)
                + "]";
    }

}
