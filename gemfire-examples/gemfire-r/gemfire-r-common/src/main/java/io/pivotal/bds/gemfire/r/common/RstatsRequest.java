package io.pivotal.bds.gemfire.r.common;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.gemstone.gemfire.DataSerializable;

@SuppressWarnings("serial")
public class RstatsRequest implements DataSerializable {

    private MatrixKey matrixKey;
    private int row;

    public RstatsRequest() {
    }

    public RstatsRequest(MatrixKey matrixKey, int row) {
        this.matrixKey = matrixKey;
        this.row = row;
    }

    public MatrixKey getMatrixKey() {
        return matrixKey;
    }

    public void setMatrixKey(MatrixKey matrixKey) {
        this.matrixKey = matrixKey;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public void fromData(DataInput in) throws IOException, ClassNotFoundException {
        matrixKey = new MatrixKey();
        matrixKey.fromData(in);
        row = in.readInt();
    }

    @Override
    public void toData(DataOutput out) throws IOException {
        matrixKey.toData(out);
        out.writeInt(row);
    }

    @Override
    public String toString() {
        return "RstatsRequest [matrixKey=" + matrixKey + ", row=" + row + "]";
    }

}
