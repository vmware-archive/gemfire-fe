package io.pivotal.bds.gemfire.r.common;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.gemstone.gemfire.DataSerializable;
import com.gemstone.gemfire.DataSerializer;

import io.pivotal.bds.gemfire.ml.ModelName;
import io.pivotal.bds.gemfire.ml.ModelType;

@SuppressWarnings("serial")
public class ModelDef implements DataSerializable {

    private ModelDefKey key;
    private ModelType type;
    private ModelName name;
    private Map<String, Object> parameters;

    public ModelDef() {
    }

    public ModelDef(ModelDefKey key, ModelType type, ModelName name, Map<String, Object> parameters) {
        this.key = key;
        this.type = type;
        this.name = name;
        this.parameters = parameters;
    }

    public ModelDefKey getKey() {
        return key;
    }

    public void setKey(ModelDefKey key) {
        this.key = key;
    }

    public ModelType getType() {
        return type;
    }

    public void setType(ModelType type) {
        this.type = type;
    }

    public ModelName getName() {
        return name;
    }

    public void setName(ModelName name) {
        this.name = name;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    @Override
    public void fromData(DataInput input) throws IOException, ClassNotFoundException {
        key = new ModelDefKey();
        key.fromData(input);
        type = DataSerializer.readEnum(ModelType.class, input);
        name = DataSerializer.readEnum(ModelName.class, input);
        parameters = DataSerializer.readHashMap(input);
    }

    @Override
    public void toData(DataOutput output) throws IOException {
        key.toData(output);
        DataSerializer.writeEnum(type, output);
        DataSerializer.writeEnum(name, output);
        DataSerializer.writeHashMap((HashMap<?, ?>) parameters, output);
    }

    @Override
    public String toString() {
        return "ModelDef [key=" + key + ", type=" + type + ", name=" + name + ", parameters=" + parameters + "]";
    }

}
