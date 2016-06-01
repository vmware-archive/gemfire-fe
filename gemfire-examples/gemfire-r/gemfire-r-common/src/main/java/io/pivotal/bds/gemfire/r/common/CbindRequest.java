package io.pivotal.bds.gemfire.r.common;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.gemstone.gemfire.DataSerializable;

@SuppressWarnings("serial")
public class CbindRequest implements DataSerializable {

    private MatrixKey srcMatrixKey;
    private MatrixKey destMatrixKey;
    private VectorKey vectorKey;

    public CbindRequest() {
    }

    public CbindRequest(MatrixKey srcMatrixKey, MatrixKey destMatrixKey, VectorKey vectorKey) {
        this.srcMatrixKey = srcMatrixKey;
        this.destMatrixKey = destMatrixKey;
        this.vectorKey = vectorKey;
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

    public VectorKey getVectorKey() {
        return vectorKey;
    }

    public void setVectorKey(VectorKey vectorKey) {
        this.vectorKey = vectorKey;
    }

    @Override
    public void fromData(DataInput in) throws IOException, ClassNotFoundException {
        srcMatrixKey = new MatrixKey();
        srcMatrixKey.fromData(in);
        destMatrixKey = new MatrixKey();
        destMatrixKey.fromData(in);
        vectorKey = new VectorKey();
        vectorKey.fromData(in);
    }

    @Override
    public void toData(DataOutput out) throws IOException {
        srcMatrixKey.toData(out);
        destMatrixKey.toData(out);
        vectorKey.toData(out);
    }

    @Override
    public String toString() {
        return "CbindRequest [srcMatrixKey=" + srcMatrixKey + ", destMatrixKey=" + destMatrixKey + ", vectorKey=" + vectorKey + "]";
    }

}
