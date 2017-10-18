package io.pivotal.bds.gemfire.r.common;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.geode.DataSerializable;

@SuppressWarnings("serial")
public class TransposeRequest implements DataSerializable {

    private MatrixKey srcMatrixKey;
    private MatrixKey destMatrixKey;

    public TransposeRequest() {
    }

    public TransposeRequest(MatrixKey srcMatrixKey, MatrixKey destMatrixKey) {
        this.srcMatrixKey = srcMatrixKey;
        this.destMatrixKey = destMatrixKey;
    }

    public MatrixKey getSrcMatrixKey() {
        return srcMatrixKey;
    }

    public void setSrcMatrixKey(MatrixKey srcMatrixKey) {
        this.srcMatrixKey = srcMatrixKey;
    }

    public MatrixKey getDestMatrixKey() {
        return destMatrixKey;
    }

    public void setDestMatrixKey(MatrixKey destMatrixKey) {
        this.destMatrixKey = destMatrixKey;
    }

    @Override
    public void fromData(DataInput in) throws IOException, ClassNotFoundException {
        srcMatrixKey = new MatrixKey();
        srcMatrixKey.fromData(in);
        destMatrixKey = new MatrixKey();
        destMatrixKey.fromData(in);
    }

    @Override
    public void toData(DataOutput out) throws IOException {
        srcMatrixKey.toData(out);
        destMatrixKey.toData(out);
    }

    @Override
    public String toString() {
        return "TransposeRequest [srcMatrixKey=" + srcMatrixKey + ", destMatrixKey=" + destMatrixKey + "]";
    }

}
