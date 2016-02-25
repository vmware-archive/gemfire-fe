package io.pivotal.bds.gemfire.r.common;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.gemstone.gemfire.DataSerializable;
import com.gemstone.gemfire.DataSerializer;

import io.pivotal.bds.gemfire.key.BaseKey;

@SuppressWarnings("serial")
public abstract class BaseStringKey extends BaseKey<String>implements DataSerializable {

    public BaseStringKey() {
    }

    public BaseStringKey(String id) {
        super(id);
    }

    @Override
    public void fromData(DataInput in) throws IOException, ClassNotFoundException {
        setId(DataSerializer.readString(in));
    }

    @Override
    public void toData(DataOutput out) throws IOException {
        DataSerializer.writeString(getId(), out);
    }

}
