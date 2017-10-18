package io.pivotal.bds.gemfire.r.common;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.geode.DataSerializable;
import org.apache.geode.DataSerializer;

import io.pivotal.bds.gemfire.key.BaseColocationKey;

@SuppressWarnings("serial")
public class BaseColocationStringKey extends BaseColocationKey<String, String>implements DataSerializable {

    public BaseColocationStringKey() {
    }

    public BaseColocationStringKey(String id, String colocationId) {
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
