package io.pivotal.bds.gemfire.r.common;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.gemstone.gemfire.DataSerializable;
import com.gemstone.gemfire.DataSerializer;

import io.pivotal.bds.gemfire.key.ColocationID;

@SuppressWarnings("serial")
public class EvaluateKey implements DataSerializable, ColocationID<String> {

    private String evaluateId;
    private String modelId;

    public EvaluateKey() {
    }

    public EvaluateKey(String evaluateId, String modelId) {
        this.evaluateId = evaluateId;
        this.modelId = modelId;
    }

    public String getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(String evaluateId) {
        this.evaluateId = evaluateId;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    @Override
    public String getColocationId() {
        return modelId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((evaluateId == null) ? 0 : evaluateId.hashCode());
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
        EvaluateKey other = (EvaluateKey) obj;
        if (evaluateId == null) {
            if (other.evaluateId != null)
                return false;
        } else if (!evaluateId.equals(other.evaluateId))
            return false;
        return true;
    }

    @Override
    public void fromData(DataInput input) throws IOException, ClassNotFoundException {
        evaluateId = DataSerializer.readString(input);
        modelId = DataSerializer.readString(input);
    }

    @Override
    public void toData(DataOutput output) throws IOException {
        DataSerializer.writeString(evaluateId, output);
        DataSerializer.writeString(modelId, output);
    }

    @Override
    public String toString() {
        return "EvaluateKey [evaluateId=" + evaluateId + ", modelId=" + modelId + "]";
    }

}
