package io.pivotal.bds.gemfire.r.common;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;

import com.gemstone.gemfire.DataSerializable;
import com.gemstone.gemfire.DataSerializer;

@SuppressWarnings("serial")
public class AdhocPrediction implements DataSerializable {

    private double[] x;
    private Number p;

    public AdhocPrediction() {
    }

    public AdhocPrediction(double[] x, Number p) {
        this.x = x;
        this.p = p;
    }

    public double[] getX() {
        return x;
    }

    public void setX(double[] x) {
        this.x = x;
    }

    public Number getP() {
        return p;
    }

    public void setP(Number p) {
        this.p = p;
    }

    @Override
    public void fromData(DataInput input) throws IOException, ClassNotFoundException {
        x = DataSerializer.readDoubleArray(input);
        p = DataSerializer.readObject(input);
    }

    @Override
    public void toData(DataOutput output) throws IOException {
        DataSerializer.writeDoubleArray(x, output);
        DataSerializer.writeObject(p, output);
    }

    @Override
    public String toString() {
        return "AdhocPrediction [x=" + Arrays.toString(x) + ", p=" + p + "]";
    }

}
