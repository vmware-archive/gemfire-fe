package io.pivotal.bds.gemfire.r.common;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;

import org.apache.geode.DataSerializable;
import org.apache.geode.DataSerializer;

@SuppressWarnings("serial")
public class HMMData<O> implements DataSerializable {

    private double[] pi;
    private double[][] a;
    private double[][] b;
    private O[] symbols;

    public HMMData() {
    }

    public HMMData(double[] pi, double[][] a, double[][] b, O[] symbols) {
        this.pi = pi;
        this.a = a;
        this.b = b;
        this.symbols = symbols;
    }

    public double[] getPi() {
        return pi;
    }

    public void setPi(double[] pi) {
        this.pi = pi;
    }

    public double[][] getA() {
        return a;
    }

    public void setA(double[][] a) {
        this.a = a;
    }

    public double[][] getB() {
        return b;
    }

    public void setB(double[][] b) {
        this.b = b;
    }

    public O[] getSymbols() {
        return symbols;
    }

    public void setSymbols(O[] symbols) {
        this.symbols = symbols;
    }

    @Override
    public void fromData(DataInput in) throws IOException, ClassNotFoundException {
        pi = DataSerializer.readDoubleArray(in);
        a = DataSerializer.readObject(in);
        b = DataSerializer.readObject(in);

        byte t = in.readByte();
        if (t == 0x00) {
            symbols = null;
        } else {
            symbols = DataSerializer.readObject(in);
        }
    }

    @Override
    public void toData(DataOutput out) throws IOException {
        DataSerializer.writeDoubleArray(pi, out);
        DataSerializer.writeObject(a, out);
        DataSerializer.writeObject(b, out);
        
        if (symbols == null) {
            out.writeByte(0x00);
        } else {
            out.writeByte(0x01);
            DataSerializer.writeObject(symbols, out);
        }
    }

    @Override
    public String toString() {
        return "HMMData [pi=" + Arrays.toString(pi) + ", a=" + Arrays.toString(a) + ", b=" + Arrays.toString(b) + ", symbols="
                + Arrays.toString(symbols) + "]";
    }

}
