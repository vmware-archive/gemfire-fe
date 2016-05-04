package io.pivotal.bds.gemfire.keyfw;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.gemstone.gemfire.DataSerializable;
import com.gemstone.gemfire.DataSerializer;

import io.pivotal.bds.gemfire.key.BaseKey;

public abstract class BaseStringDSKey extends BaseKey<String>implements DataSerializable {

    private static final long serialVersionUID = 1L;

    public BaseStringDSKey() {
    }

    public BaseStringDSKey(String id) {
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
