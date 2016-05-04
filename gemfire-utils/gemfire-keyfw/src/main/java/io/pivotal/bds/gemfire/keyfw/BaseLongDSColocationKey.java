package io.pivotal.bds.gemfire.keyfw;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.gemstone.gemfire.DataSerializable;

import io.pivotal.bds.gemfire.key.BaseColocationKey;

public abstract class BaseLongDSColocationKey extends BaseColocationKey<Long, Long>implements DataSerializable {

    private static final long serialVersionUID = 1L;

    public BaseLongDSColocationKey() {
    }

    public BaseLongDSColocationKey(Long id, Long colocationId) {
        super(id, colocationId);
    }

    @Override
    public void fromData(DataInput in) throws IOException, ClassNotFoundException {
        setId(in.readLong());
        setColocationId(in.readLong());
    }

    @Override
    public void toData(DataOutput out) throws IOException {
        out.writeLong(getId());
        out.writeLong(getColocationId());
    }

}
