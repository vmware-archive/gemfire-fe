package io.pivotal.bds.gemfire.r.common;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.gemstone.gemfire.DataSerializable;
import com.gemstone.gemfire.DataSerializer;

@SuppressWarnings("serial")
public class AdhocPredictionRequest implements DataSerializable {

    private ModelKey modelKey;
    private String queryId;
    private List<Object> queryArgs;

    public AdhocPredictionRequest() {
    }

    public AdhocPredictionRequest(ModelKey modelKey, String queryId, List<Object> queryArgs) {
        this.modelKey = modelKey;
        this.queryId = queryId;
        this.queryArgs = queryArgs;
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

    public List<Object> getQueryArgs() {
        return queryArgs;
    }

    public void setQueryArgs(List<Object> queryArgs) {
        this.queryArgs = queryArgs;
    }

    @Override
    public void fromData(DataInput input) throws IOException, ClassNotFoundException {
        modelKey = new ModelKey();
        modelKey.fromData(input);
        queryId = DataSerializer.readString(input);
        queryArgs = DataSerializer.readArrayList(input);
    }

    @Override
    public void toData(DataOutput output) throws IOException {
        modelKey.toData(output);
        DataSerializer.writeString(queryId, output);
        DataSerializer.writeArrayList((ArrayList<?>) queryArgs, output);
    }

    @Override
    public String toString() {
        return "AdhocPredictionRequest [modelKey=" + modelKey + ", queryId=" + queryId + ", queryArgs=" + queryArgs + "]";
    }

}
