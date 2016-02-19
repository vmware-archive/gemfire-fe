package io.pivotal.bds.gemfire.r.common;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.gemstone.gemfire.DataSerializable;
import com.gemstone.gemfire.DataSerializer;

@SuppressWarnings("serial")
public class MatrixKey implements DataSerializable {

    private String matrixId;

    public MatrixKey() {
    }

    public MatrixKey(String matrixId) {
        this.matrixId = matrixId;
    }

    public String getMatrixId() {
        return matrixId;
    }

    public void setMatrixId(String matrixId) {
        this.matrixId = matrixId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((matrixId == null) ? 0 : matrixId.hashCode());
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
        MatrixKey other = (MatrixKey) obj;
        if (matrixId == null) {
            if (other.matrixId != null)
                return false;
        } else if (!matrixId.equals(other.matrixId))
            return false;
        return true;
    }

    @Override
    public void fromData(DataInput input) throws IOException, ClassNotFoundException {
        matrixId = DataSerializer.readString(input);
    }

    @Override
    public void toData(DataOutput output) throws IOException {
        DataSerializer.writeString(matrixId, output);
    }

    @Override
    public String toString() {
        return "MatrixKey [matrixId=" + matrixId + "]";
    }

}
