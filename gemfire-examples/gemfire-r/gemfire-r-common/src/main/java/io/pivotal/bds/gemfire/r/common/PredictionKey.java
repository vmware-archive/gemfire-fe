package io.pivotal.bds.gemfire.r.common;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.gemstone.gemfire.DataSerializable;
import com.gemstone.gemfire.DataSerializer;

import io.pivotal.bds.gemfire.key.ColocationID;

@SuppressWarnings("serial")
public class PredictionKey implements DataSerializable, ColocationID<String> {

    private String predictionId;
    private String modelId;

    public PredictionKey() {
    }

    public PredictionKey(String predictionId, String modelId) {
        this.predictionId = predictionId;
        this.modelId = modelId;
    }

    public String getPredictionId() {
        return predictionId;
    }

    public void setPredictionId(String predictionId) {
        this.predictionId = predictionId;
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
        result = prime * result + ((predictionId == null) ? 0 : predictionId.hashCode());
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
        PredictionKey other = (PredictionKey) obj;
        if (predictionId == null) {
            if (other.predictionId != null)
                return false;
        } else if (!predictionId.equals(other.predictionId))
            return false;
        return true;
    }

    @Override
    public void fromData(DataInput input) throws IOException, ClassNotFoundException {
        predictionId = DataSerializer.readString(input);
        modelId = DataSerializer.readString(input);
    }

    @Override
    public void toData(DataOutput output) throws IOException {
        DataSerializer.writeString(predictionId, output);
        DataSerializer.writeString(modelId, output);
    }

    @Override
    public String toString() {
        return "PredictionKey [modelId=" + modelId + ", predictionId=" + predictionId + "]";
    }

}
