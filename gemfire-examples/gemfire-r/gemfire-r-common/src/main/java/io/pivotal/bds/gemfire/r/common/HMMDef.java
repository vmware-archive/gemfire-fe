package io.pivotal.bds.gemfire.r.common;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.geode.DataSerializable;

@SuppressWarnings("serial")
public class HMMDef implements DataSerializable {

    private VectorKey piKey;
    private MatrixKey aKey;
    private MatrixKey bKey;
    private VectorKey symbolsKey;

    public HMMDef() {
    }

    public HMMDef(VectorKey piKey, MatrixKey aKey, MatrixKey bKey, VectorKey symbolsKey) {
        this.piKey = piKey;
        this.aKey = aKey;
        this.bKey = bKey;
        this.symbolsKey = symbolsKey;
    }

    public VectorKey getPiKey() {
        return piKey;
    }

    public void setPiKey(VectorKey piKey) {
        this.piKey = piKey;
    }

    public MatrixKey getaKey() {
        return aKey;
    }

    public void setaKey(MatrixKey aKey) {
        this.aKey = aKey;
    }

    public MatrixKey getbKey() {
        return bKey;
    }

    public void setbKey(MatrixKey bKey) {
        this.bKey = bKey;
    }

    public VectorKey getSymbolsKey() {
        return symbolsKey;
    }

    public void setSymbolsKey(VectorKey symbolsKey) {
        this.symbolsKey = symbolsKey;
    }

    @Override
    public void fromData(DataInput in) throws IOException, ClassNotFoundException {
        piKey = new VectorKey();
        piKey.fromData(in);
        aKey = new MatrixKey();
        aKey.fromData(in);
        bKey = new MatrixKey();
        bKey.fromData(in);

        byte b = in.readByte();
        if (b == 0x0) {
            symbolsKey = null;
        } else {
            symbolsKey = new VectorKey();
            symbolsKey.fromData(in);
        }
    }

    @Override
    public void toData(DataOutput out) throws IOException {
        piKey.toData(out);
        aKey.toData(out);
        bKey.toData(out);

        if (symbolsKey == null) {
            out.writeByte(0x00);
        } else {
            out.writeByte(0x01);
            symbolsKey.toData(out);
        }
    }

    @Override
    public String toString() {
        return "HMMDef [piKey=" + piKey + ", aKey=" + aKey + ", bKey=" + bKey + ", symbolsKey=" + symbolsKey + "]";
    }

}
