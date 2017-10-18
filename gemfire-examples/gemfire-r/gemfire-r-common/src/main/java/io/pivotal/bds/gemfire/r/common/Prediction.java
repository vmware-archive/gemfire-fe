package io.pivotal.bds.gemfire.r.common;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Date;

import org.apache.geode.DataSerializable;
import org.apache.geode.DataSerializer;

@SuppressWarnings("serial")
public class Prediction implements DataSerializable {

    private PredictionKey key;
    private ModelKey modelKey;
    private Date timestamp;
    private Number prediction;

    public Prediction() {
    }

    public Prediction(PredictionKey key, ModelKey modelKey, Date timestamp, Number prediction) {
        this.key = key;
        this.modelKey = modelKey;
        this.timestamp = timestamp;
        this.prediction = prediction;
    }

    public PredictionKey getKey() {
        return key;
    }

    public void setKey(PredictionKey key) {
        this.key = key;
    }

    public ModelKey getModelKey() {
        return modelKey;
    }

    public void setModelKey(ModelKey modelKey) {
        this.modelKey = modelKey;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Number getPrediction() {
        return prediction;
    }

    public void setPrediction(Number prediction) {
        this.prediction = prediction;
    }

    @Override
    public void fromData(DataInput input) throws IOException, ClassNotFoundException {
        key = new PredictionKey();
        key.fromData(input);
        modelKey = new ModelKey();
        modelKey.fromData(input);
        timestamp = DataSerializer.readDate(input);
        prediction = DataSerializer.readObject(input);
    }

    @Override
    public void toData(DataOutput output) throws IOException {
        key.toData(output);
        modelKey.toData(output);
        DataSerializer.writeDate(timestamp, output);
        DataSerializer.writeObject(prediction, output);
    }

    @Override
    public String toString() {
        return "Prediction [key=" + key + ", modelKey=" + modelKey + ", timestamp=" + timestamp + ", prediction=" + prediction
                + "]";
    }

}
