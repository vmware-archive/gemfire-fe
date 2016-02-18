package io.pivotal.bds.gemfire.r.common;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gemstone.gemfire.DataSerializable;
import com.gemstone.gemfire.DataSerializer;

import io.pivotal.bds.gemfire.ml.ModelName;
import io.pivotal.bds.gemfire.ml.ModelType;

@SuppressWarnings("serial")
public class ModelDef implements DataSerializable {

    private ModelKey modelKey;
    private String queryId;
    private ModelType modelType;
    private ModelName modelName;
    private List<Object> queryArgs;
    private Map<String, Object> parameters;

    public ModelDef() {
    }

    public ModelDef(ModelKey modelKey, String queryId, ModelType modelType, ModelName modelName, List<Object> queryArgs,
            Map<String, Object> parameters) {
        this.modelKey = modelKey;
        this.queryId = queryId;
        this.modelType = modelType;
        this.modelName = modelName;
        this.queryArgs = queryArgs;
        this.parameters = parameters;
    }

    public ModelKey getModelKey() {
        return modelKey;
    }

    public void setModelKey(ModelKey modelKey) {
        this.modelKey = modelKey;
    }

    public String getQueryId() {
        return queryId;
    }

    public void setQueryId(String queryId) {
        this.queryId = queryId;
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

    public List<Object> getQueryArgs() {
        return queryArgs;
    }

    public void setQueryArgs(List<Object> queryArgs) {
        this.queryArgs = queryArgs;
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
        queryId = DataSerializer.readString(input);
        modelType = ModelType.valueOf(DataSerializer.readString(input));
        modelName = ModelName.valueOf(DataSerializer.readString(input));
        queryArgs = DataSerializer.readArrayList(input);
        parameters = DataSerializer.readHashMap(input);
    }

    @Override
    public void toData(DataOutput output) throws IOException {
        modelKey.toData(output);
        DataSerializer.writeString(queryId, output);
        DataSerializer.writeString(modelType.name(), output);
        DataSerializer.writeString(modelName.name(), output);
        DataSerializer.writeArrayList((ArrayList<?>) queryArgs, output);
        DataSerializer.writeHashMap((HashMap<?, ?>) parameters, output);
    }

    @Override
    public String toString() {
        return "ModelDef [modelKey=" + modelKey + ", queryId=" + queryId + ", modelType=" + modelType + ", modelName=" + modelName
                + ", parameters=" + parameters + "]";
    }

}
