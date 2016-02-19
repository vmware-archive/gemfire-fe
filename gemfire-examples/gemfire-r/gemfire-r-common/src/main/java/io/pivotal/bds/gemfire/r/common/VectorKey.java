package io.pivotal.bds.gemfire.r.common;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.gemstone.gemfire.DataSerializable;
import com.gemstone.gemfire.DataSerializer;

@SuppressWarnings("serial")
public class VectorKey implements DataSerializable {

    private String vectorId;

    public VectorKey() {
    }

    public VectorKey(String vectorId) {
        this.vectorId = vectorId;
    }

    public String getVectorId() {
        return vectorId;
    }

    public void setVectorId(String vectorId) {
        this.vectorId = vectorId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((vectorId == null) ? 0 : vectorId.hashCode());
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
        VectorKey other = (VectorKey) obj;
        if (vectorId == null) {
            if (other.vectorId != null)
                return false;
        } else if (!vectorId.equals(other.vectorId))
            return false;
        return true;
    }

    @Override
    public void fromData(DataInput input) throws IOException, ClassNotFoundException {
        vectorId = DataSerializer.readString(input);
    }

    @Override
    public void toData(DataOutput output) throws IOException {
        DataSerializer.writeString(vectorId, output);
    }

    @Override
    public String toString() {
        return "VectorKey [vectorId=" + vectorId + "]";
    }

}
