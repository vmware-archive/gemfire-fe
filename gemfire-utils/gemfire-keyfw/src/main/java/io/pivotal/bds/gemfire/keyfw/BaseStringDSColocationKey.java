package io.pivotal.bds.gemfire.keyfw;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.geode.DataSerializable;
import org.apache.geode.DataSerializer;

import io.pivotal.bds.gemfire.key.BaseColocationKey;

public abstract class BaseStringDSColocationKey extends BaseColocationKey<String, String>implements DataSerializable {

    private static final long serialVersionUID = 1L;

    public BaseStringDSColocationKey() {
    }

    public BaseStringDSColocationKey(String id, String colocationId) {
        super(id, colocationId);
    }

    @Override
    public void fromData(DataInput in) throws IOException, ClassNotFoundException {
        setId(DataSerializer.readString(in));
        setColocationId(DataSerializer.readString(in));
    }

    @Override
    public void toData(DataOutput out) throws IOException {
        DataSerializer.writeString(getId(), out);
        DataSerializer.writeString(getColocationId(), out);
    }

}
