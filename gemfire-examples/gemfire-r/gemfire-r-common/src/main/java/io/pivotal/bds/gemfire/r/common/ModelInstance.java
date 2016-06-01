package io.pivotal.bds.gemfire.r.common;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;

import com.gemstone.gemfire.DataSerializable;
import com.gemstone.gemfire.DataSerializer;

@SuppressWarnings("serial")
public class ModelInstance implements DataSerializable {

    private double[] x;
    private Number y;

    public ModelInstance() {
    }

    public ModelInstance(double[] x, Number y) {
        this.x = x;
        this.y = y;
    }

    public double[] getX() {
        return x;
    }

    public void setX(double[] x) {
        this.x = x;
    }

    public Number getY() {
        return y;
    }

    public void setY(Number y) {
        this.y = y;
    }

    @Override
    public void fromData(DataInput in) throws IOException, ClassNotFoundException {
        x = DataSerializer.readDoubleArray(in);
        y = DataSerializer.readObject(in);
    }

    @Override
    public void toData(DataOutput out) throws IOException {
        DataSerializer.writeDoubleArray(x, out);
        DataSerializer.writeObject(y, out);
    }

    @Override
    public String toString() {
        return "ModelPoint [x=" + Arrays.toString(x) + ", y=" + y + "]";
    }

}
