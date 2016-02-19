package io.pivotal.bds.gemfire.r.common;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.gemstone.gemfire.DataSerializable;
import com.gemstone.gemfire.DataSerializer;

@SuppressWarnings("serial")
public class AdhocPredictionRequest implements DataSerializable {

    private ModelKey modelKey;
    private Object argument;

    public AdhocPredictionRequest() {
    }

    public AdhocPredictionRequest(ModelKey modelKey, Object argument) {
        this.modelKey = modelKey;
        this.argument = argument;
    }

    public ModelKey getModelKey() {
        return modelKey;
    }

    public void setModelKey(ModelKey modelKey) {
        this.modelKey = modelKey;
    }

    public Object getArgument() {
        return argument;
    }

    public void setArgument(Object argument) {
        this.argument = argument;
    }

    @Override
    public void fromData(DataInput input) throws IOException, ClassNotFoundException {
        modelKey = new ModelKey();
        modelKey.fromData(input);
        argument = DataSerializer.readObject(input);
    }

    @Override
    public void toData(DataOutput output) throws IOException {
        modelKey.toData(output);
        DataSerializer.writeObject(argument, output);
    }

    @Override
    public String toString() {
        return "AdhocPredictionRequest [modelKey=" + modelKey + ", argument=" + argument + "]";
    }

}
