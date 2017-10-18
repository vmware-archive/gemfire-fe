package io.pivotal.bds.gemfire.r.common;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.geode.DataSerializable;
import org.apache.geode.DataSerializer;

@SuppressWarnings("serial")
public class Matrix<V> implements DataSerializable {

    private List<Vector<V>> rows;

    public Matrix() {
    }

    public Matrix(List<Vector<V>> rows) {
        this.rows = rows;
    }

    public List<Vector<V>> getRows() {
        return rows;
    }

    public void setRows(List<Vector<V>> rows) {
        this.rows = rows;
    }

    @Override
    public void fromData(DataInput input) throws IOException, ClassNotFoundException {
        int c = input.readInt();
        rows = new ArrayList<>();
        for (int i = 0; i < c; ++i) {
            Vector<V> v = DataSerializer.readObject(input);
            rows.add(v);
        }
    }

    @Override
    public void toData(DataOutput output) throws IOException {
        int c = rows.size();
        output.writeInt(c);
        for (int i = 0; i < c; ++i) {
            DataSerializer.writeObject(rows.get(i), output);
        }
    }

    @Override
    public String toString() {
        return "Matrix [rows=" + rows + "]";
    }

}
