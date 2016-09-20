package io.pivotal.bds.gemfire.keyfw;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.gemstone.gemfire.DataSerializable;

@SuppressWarnings("serial")
public abstract class BaseDSIntegerKey implements DataSerializable {

    private int id;

    public BaseDSIntegerKey() {
    }

    public BaseDSIntegerKey(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BaseDSIntegerKey other = (BaseDSIntegerKey) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public void fromData(DataInput in) throws IOException, ClassNotFoundException {
        id = in.readInt();
    }

    @Override
    public void toData(DataOutput out) throws IOException {
        out.writeInt(id);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [id=" + id + "]";
    }

}
