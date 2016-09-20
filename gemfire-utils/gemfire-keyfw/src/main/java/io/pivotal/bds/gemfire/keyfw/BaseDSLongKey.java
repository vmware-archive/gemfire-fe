package io.pivotal.bds.gemfire.keyfw;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.gemstone.gemfire.DataSerializable;

@SuppressWarnings("serial")
public abstract class BaseDSLongKey implements DataSerializable {

    private long id;

    public BaseDSLongKey() {
    }

    public BaseDSLongKey(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
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
        BaseDSLongKey other = (BaseDSLongKey) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public void fromData(DataInput in) throws IOException, ClassNotFoundException {
        id = in.readLong();
    }

    @Override
    public void toData(DataOutput out) throws IOException {
        out.writeLong(id);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [id=" + id + "]";
    }

}
