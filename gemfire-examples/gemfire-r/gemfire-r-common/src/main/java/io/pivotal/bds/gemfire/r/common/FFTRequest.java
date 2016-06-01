package io.pivotal.bds.gemfire.r.common;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.gemstone.gemfire.DataSerializable;
import com.gemstone.gemfire.DataSerializer;

@SuppressWarnings("serial")
public class FFTRequest implements DataSerializable {

    private Object input;
    private String normalization;
    private String type;
    private MatrixKey matrixKey;
    private Object route;

    public FFTRequest() {
    }

    public FFTRequest(Object input, String normalization, String type, MatrixKey matrixKey, Object route) {
        this.input = input;
        this.normalization = normalization;
        this.type = type;
        this.matrixKey = matrixKey;
        this.route = route;
    }

    public Object getInput() {
        return input;
    }

    public void setInput(Object input) {
        this.input = input;
    }

    public String getNormalization() {
        return normalization;
    }

    public void setNormalization(String normalization) {
        this.normalization = normalization;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MatrixKey getMatrixKey() {
        return matrixKey;
    }

    public void setMatrixKey(MatrixKey matrixKey) {
        this.matrixKey = matrixKey;
    }

    public Object getRoute() {
        return route;
    }

    public void setRoute(Object route) {
        this.route = route;
    }

    @Override
    public void fromData(DataInput in) throws IOException, ClassNotFoundException {
        input = DataSerializer.readObject(in);
        normalization = DataSerializer.readString(in);
        type = DataSerializer.readString(in);
        route = DataSerializer.readObject(in);
        matrixKey = new MatrixKey();
        matrixKey.fromData(in);
    }

    @Override
    public void toData(DataOutput out) throws IOException {
        DataSerializer.writeObject(input, out);
        DataSerializer.writeString(normalization, out);
        DataSerializer.writeString(type, out);
        DataSerializer.writeObject(route, out);
        matrixKey.toData(out);
    }

    @Override
    public String toString() {
        return "FFTRequest [input=" + input + ", normalization=" + normalization + ", type=" + type + ", matrixKey=" + matrixKey
                + ", route=" + route + "]";
    }

}
