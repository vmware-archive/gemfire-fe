package io.pivotal.bds.gemfire.r.common;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.geode.DataSerializable;

@SuppressWarnings("serial")
public class CstatsRequest implements DataSerializable {

    private MatrixKey matrixKey;
    private int col;

    public CstatsRequest() {
    }

    public CstatsRequest(MatrixKey matrixKey, int col) {
        this.matrixKey = matrixKey;
        this.col = col;
    }

    public MatrixKey getMatrixKey() {
        return matrixKey;
    }

    public void setMatrixKey(MatrixKey matrixKey) {
        this.matrixKey = matrixKey;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    @Override
    public void fromData(DataInput in) throws IOException, ClassNotFoundException {
        matrixKey = new MatrixKey();
        matrixKey.fromData(in);
        col = in.readInt();
    }

    @Override
    public void toData(DataOutput out) throws IOException {
        matrixKey.toData(out);
        out.writeInt(col);
    }

    @Override
    public String toString() {
        return "CstatsRequest [matrixKey=" + matrixKey + ", col=" + col + "]";
    }

}
