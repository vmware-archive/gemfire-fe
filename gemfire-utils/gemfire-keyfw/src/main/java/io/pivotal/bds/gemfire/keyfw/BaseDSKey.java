package io.pivotal.bds.gemfire.keyfw;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.gemstone.gemfire.DataSerializable;
import com.gemstone.gemfire.DataSerializer;

import io.pivotal.bds.gemfire.key.BaseKey;

@SuppressWarnings("serial")
public class BaseDSKey<T> extends BaseKey<T>implements DataSerializable {

    public BaseDSKey() {
    }

    public BaseDSKey(T id) {
        super(id);
    }

    @Override
    public void fromData(DataInput in) throws IOException, ClassNotFoundException {
        setId(DataSerializer.readObject(in));
    }

    @Override
    public void toData(DataOutput out) throws IOException {
        DataSerializer.writeObject(getId(), out);
    }

}
