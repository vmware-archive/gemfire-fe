package io.pivotal.bds.gemfire.keyfw;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.geode.DataSerializable;

import io.pivotal.bds.gemfire.key.BaseKey;

public abstract class BaseLongDSKey extends BaseKey<Long>implements DataSerializable {

    private static final long serialVersionUID = 1L;

    public BaseLongDSKey() {
    }

    public BaseLongDSKey(Long id) {
        super(id);
    }

    @Override
    public void fromData(DataInput in) throws IOException, ClassNotFoundException {
        setId(in.readLong());
    }

    @Override
    public void toData(DataOutput out) throws IOException {
        out.writeLong(getId());
    }

}
