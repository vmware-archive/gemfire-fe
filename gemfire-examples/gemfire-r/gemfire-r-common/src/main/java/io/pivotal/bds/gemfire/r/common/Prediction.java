package io.pivotal.bds.gemfire.r.common;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Date;

import com.gemstone.gemfire.DataSerializable;
import com.gemstone.gemfire.DataSerializer;

@SuppressWarnings("serial")
public class Prediction implements DataSerializable {

    private PredictionKey key;
    private Date timestamp;
    private Number prediction;

    public Prediction() {
    }

    public Prediction(PredictionKey key, Date timestamp, Number prediction) {
        this.key = key;
        this.timestamp = timestamp;
        this.prediction = prediction;
    }

    public PredictionKey getKey() {
        return key;
    }

    public void setKey(PredictionKey key) {
        this.key = key;
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
        timestamp = DataSerializer.readDate(input);
        prediction = DataSerializer.readObject(input);
    }

    @Override
    public void toData(DataOutput output) throws IOException {
        key.toData(output);
        DataSerializer.writeDate(timestamp, output);
        DataSerializer.writeObject(prediction, output);
    }

    @Override
    public String toString() {
        return "Prediction [key=" + key + ", timestamp=" + timestamp + ", prediction=" + prediction + "]";
    }

}
