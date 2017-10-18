package io.pivotal.bds.gemfire.r.common;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.geode.DataSerializable;

@SuppressWarnings("serial")
public class TrainDef implements DataSerializable {

    private ModelDefKey modelDefKey;
    private ModelKey modelKey;
    private MatrixKey matrixKey;
    private VectorKey vectorKey;

    public TrainDef() {
    }

    public TrainDef(ModelDefKey modelDefKey, ModelKey modelKey, MatrixKey matrixKey, VectorKey vectorKey) {
        this.modelDefKey = modelDefKey;
        this.modelKey = modelKey;
        this.matrixKey = matrixKey;
        this.vectorKey = vectorKey;
    }

    public ModelDefKey getModelDefKey() {
        return modelDefKey;
    }

    public void setModelDefKey(ModelDefKey modelDefKey) {
        this.modelDefKey = modelDefKey;
    }

    public ModelKey getModelKey() {
        return modelKey;
    }

    public void setModelKey(ModelKey modelKey) {
        this.modelKey = modelKey;
    }

    public MatrixKey getMatrixKey() {
        return matrixKey;
    }

    public void setMatrixKey(MatrixKey matrixKey) {
        this.matrixKey = matrixKey;
    }

    public VectorKey getVectorKey() {
        return vectorKey;
    }

    public void setVectorKey(VectorKey vectorKey) {
        this.vectorKey = vectorKey;
    }

    @Override
    public void fromData(DataInput in) throws IOException, ClassNotFoundException {
        modelDefKey = new ModelDefKey();
        modelDefKey.fromData(in);
        modelKey = new ModelKey();
        modelKey.fromData(in);
        matrixKey = new MatrixKey();
        matrixKey.fromData(in);
        vectorKey = new VectorKey();
        vectorKey.fromData(in);
    }

    @Override
    public void toData(DataOutput out) throws IOException {
        modelDefKey.toData(out);
        modelKey.toData(out);
        matrixKey.toData(out);
        vectorKey.toData(out);
    }

    @Override
    public String toString() {
        return "TrainDef [modelDefKey=" + modelDefKey + ", modelKey=" + modelKey + ", matrixKey=" + matrixKey + ", vectorKey="
                + vectorKey + "]";
    }
}
