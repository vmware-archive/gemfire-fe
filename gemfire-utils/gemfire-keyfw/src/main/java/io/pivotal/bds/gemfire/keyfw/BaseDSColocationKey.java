package io.pivotal.bds.gemfire.keyfw;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.gemstone.gemfire.DataSerializable;
import com.gemstone.gemfire.DataSerializer;

import io.pivotal.bds.gemfire.key.BaseColocationKey;

@SuppressWarnings("serial")
public class BaseDSColocationKey<T, C> extends BaseColocationKey<T, C>implements DataSerializable {

    public BaseDSColocationKey() {
    }

    public BaseDSColocationKey(T id, C colocationId) {
        super(id, colocationId);
    }

    @Override
    public void fromData(DataInput in) throws IOException, ClassNotFoundException {
        setId(DataSerializer.readObject(in));
        setColocationId(DataSerializer.readObject(in));
    }

    @Override
    public void toData(DataOutput out) throws IOException {
        DataSerializer.writeObject(getId(), out);
        DataSerializer.writeObject(getColocationId(), out);
    }

}
