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

    private ModelKey modelKey;
    private String matrixId;
    private String vectorId;
    private ModelType modelType;
    private ModelName modelName;
    private Map<String, Object> parameters;

    public ModelDef() {
    }

    public ModelDef(ModelKey modelKey, String matrixId, String vectorId, ModelType modelType, ModelName modelName,
            Map<String, Object> parameters) {
        this.modelKey = modelKey;
        this.matrixId = matrixId;
        this.vectorId = vectorId;
        this.modelType = modelType;
        this.modelName = modelName;
        this.parameters = parameters;
    }

    public ModelKey getModelKey() {
        return modelKey;
    }

    public void setModelKey(ModelKey modelKey) {
        this.modelKey = modelKey;
    }

    public String getMatrixId() {
        return matrixId;
    }

    public void setMatrixId(String matrixId) {
        this.matrixId = matrixId;
    }

    public String getVectorId() {
        return vectorId;
    }

    public void setVectorId(String vectorId) {
        this.vectorId = vectorId;
    }

    public ModelType getModelType() {
        return modelType;
    }

    public void setModelType(ModelType modelType) {
        this.modelType = modelType;
    }

    public ModelName getModelName() {
        return modelName;
    }

    public void setModelName(ModelName modelName) {
        this.modelName = modelName;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    @Override
    public void fromData(DataInput input) throws IOException, ClassNotFoundException {
        modelKey = new ModelKey();
        modelKey.fromData(input);
        matrixId = DataSerializer.readString(input);
        vectorId = DataSerializer.readString(input);
        modelType = ModelType.valueOf(DataSerializer.readString(input));
        modelName = ModelName.valueOf(DataSerializer.readString(input));
        parameters = DataSerializer.readHashMap(input);
    }

    @Override
    public void toData(DataOutput output) throws IOException {
        modelKey.toData(output);
        DataSerializer.writeString(matrixId, output);
        DataSerializer.writeString(vectorId, output);
        DataSerializer.writeString(modelType.name(), output);
        DataSerializer.writeString(modelName.name(), output);
        DataSerializer.writeHashMap((HashMap<?, ?>) parameters, output);
    }

    @Override
    public String toString() {
        return "ModelDef [modelKey=" + modelKey + ", matrixId=" + matrixId + ", vectorId=" + vectorId + ", modelType=" + modelType
                + ", modelName=" + modelName + ", parameters=" + parameters + "]";
    }

}
