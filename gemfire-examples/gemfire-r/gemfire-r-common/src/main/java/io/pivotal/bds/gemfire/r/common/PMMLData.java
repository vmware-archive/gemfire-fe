package io.pivotal.bds.gemfire.r.common;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.gemstone.gemfire.DataSerializable;
import com.gemstone.gemfire.DataSerializer;

@SuppressWarnings("serial")
public class PMMLData implements DataSerializable {

    private String model;

    public PMMLData() {
    }

    public PMMLData(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public void fromData(DataInput in) throws IOException, ClassNotFoundException {
        model = DataSerializer.readString(in);
    }

    @Override
    public void toData(DataOutput out) throws IOException {
        DataSerializer.writeString(model, out);
    }

    @Override
    public String toString() {
        return "PMMLData [model=" + model + "]";
    }

}
