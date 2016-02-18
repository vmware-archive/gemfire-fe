package io.pivotal.bds.gemfire.r.common;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.gemstone.gemfire.DataSerializable;
import com.gemstone.gemfire.DataSerializer;

@SuppressWarnings("serial")
public class ModelKey implements DataSerializable {

    private String modelId;

    public ModelKey() {
    }

    public ModelKey(String modelId) {
        this.modelId = modelId;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((modelId == null) ? 0 : modelId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ModelKey other = (ModelKey) obj;
        if (modelId == null) {
            if (other.modelId != null)
                return false;
        } else if (!modelId.equals(other.modelId))
            return false;
        return true;
    }

    @Override
    public void fromData(DataInput input) throws IOException, ClassNotFoundException {
        modelId = DataSerializer.readString(input);
    }

    @Override
    public void toData(DataOutput output) throws IOException {
        DataSerializer.writeString(modelId, output);
    }

    @Override
    public String toString() {
        return "ModelKey [modelId=" + modelId + "]";
    }

}
