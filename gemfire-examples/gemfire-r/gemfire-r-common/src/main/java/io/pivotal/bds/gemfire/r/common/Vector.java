package io.pivotal.bds.gemfire.r.common;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.List;

import org.apache.geode.DataSerializable;
import org.apache.geode.DataSerializer;

@SuppressWarnings("serial")
public class Vector<V> implements DataSerializable {

    private List<V> vector;

    public Vector() {
    }

    public Vector(List<V> vector) {
        this.vector = vector;
    }

    public List<V> getVector() {
        return vector;
    }

    public void setVector(List<V> vector) {
        this.vector = vector;
    }

    @Override
    public void fromData(DataInput input) throws IOException, ClassNotFoundException {
        vector = DataSerializer.readObject(input);
    }

    @Override
    public void toData(DataOutput output) throws IOException {
        DataSerializer.writeObject(vector, output);
    }

    @Override
    public String toString() {
        return "Vector [vector=" + vector + "]";
    }

}
