package io.pivotal.bds.gemfire.mongodb.data;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.geode.DataSerializable;
import org.apache.geode.DataSerializer;

@SuppressWarnings("serial")
public class AccountKey implements DataSerializable {

    private String id;

    public AccountKey() {
    }

    public AccountKey(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        AccountKey other = (AccountKey) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public void fromData(DataInput in) throws IOException, ClassNotFoundException {
        id = DataSerializer.readString(in);
    }

    @Override
    public void toData(DataOutput out) throws IOException {
        DataSerializer.writeString(id, out);
    }

    @Override
    public String toString() {
        return "AccountKey [id=" + id + "]";
    }

}
