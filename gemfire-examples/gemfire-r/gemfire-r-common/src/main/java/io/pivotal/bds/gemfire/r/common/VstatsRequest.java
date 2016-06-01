package io.pivotal.bds.gemfire.r.common;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.gemstone.gemfire.DataSerializable;

@SuppressWarnings("serial")
public class VstatsRequest implements DataSerializable {

    private VectorKey vectorKey;

    public VstatsRequest() {
    }

    public VstatsRequest(VectorKey vectorKey) {
        this.vectorKey = vectorKey;
    }

    public VectorKey getVectorKey() {
        return vectorKey;
    }

    public void setVectorKey(VectorKey vectorKey) {
        this.vectorKey = vectorKey;
    }

    @Override
    public void fromData(DataInput in) throws IOException, ClassNotFoundException {
        vectorKey = new VectorKey();
        vectorKey.fromData(in);
    }

    @Override
    public void toData(DataOutput out) throws IOException {
        vectorKey.toData(out);
    }

    @Override
    public String toString() {
        return "VstatsRequest [vectorKey=" + vectorKey + "]";
    }

}
