package io.pivotal.bds.gemfire.r.common;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.gemstone.gemfire.DataSerializable;
import com.gemstone.gemfire.DataSerializer;

import io.pivotal.bds.gemfire.ml.ModelName;
import io.pivotal.bds.gemfire.ml.ModelType;

@SuppressWarnings("serial")
public class ModelData implements DataSerializable {

    private ModelKey modelKey;
    private ModelType type;
    private ModelName modelName;
    private Map<String, Object> properties;
    private double[][] x;
    private Number[] y;

    public ModelData() {
    }

    public ModelData(ModelKey modelKey, ModelType type, ModelName modelName, Map<String, Object> properties, double[][] x,
            Number[] y) {
        this.modelKey = modelKey;
        this.type = type;
        this.modelName = modelName;
        this.properties = properties;
        this.x = x;
        this.y = y;
    }

    public ModelKey getModelKey() {
        return modelKey;
    }

    public void setModelKey(ModelKey modelKey) {
        this.modelKey = modelKey;
    }

    public ModelType getType() {
        return type;
    }

    public void setType(ModelType type) {
        this.type = type;
    }

    public ModelName getModelName() {
        return modelName;
    }

    public void setModelName(ModelName modelName) {
        this.modelName = modelName;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
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
        modelKey = new ModelKey();
        modelKey.fromData(input);
        type = ModelType.valueOf(DataSerializer.readString(input));
        modelName = ModelName.valueOf(DataSerializer.readString(input));
        properties = DataSerializer.readHashMap(input);
        x = DataSerializer.readObject(input);
        y = DataSerializer.readObject(input);
    }

    @Override
    public void toData(DataOutput output) throws IOException {
        modelKey.toData(output);
        DataSerializer.writeString(type.name(), output);
        DataSerializer.writeString(modelName.name(), output);
        DataSerializer.writeHashMap((HashMap<?, ?>) properties, output);
        DataSerializer.writeObject(x, output);
        DataSerializer.writeObject(y, output);
    }

    @Override
    public String toString() {
        return "ModelData [modelKey=" + modelKey + ", type=" + type + ", modelName=" + modelName + ", properties=" + properties
                + ", x=" + Arrays.toString(x) + ", y=" + Arrays.toString(y) + "]";
    }
}
