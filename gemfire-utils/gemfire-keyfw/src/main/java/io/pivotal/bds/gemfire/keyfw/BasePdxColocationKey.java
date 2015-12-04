package io.pivotal.bds.gemfire.keyfw;

import com.gemstone.gemfire.pdx.PdxReader;
import com.gemstone.gemfire.pdx.PdxSerializable;
import com.gemstone.gemfire.pdx.PdxWriter;

import io.pivotal.bds.gemfire.key.BaseColocationKey;

public class BasePdxColocationKey<T, C> extends BaseColocationKey<T, C>implements PdxSerializable {

    public BasePdxColocationKey() {
    }

    public BasePdxColocationKey(T id, C colocationId) {
        super(id, colocationId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void fromData(PdxReader reader) {
        setId((T) reader.readObject("id"));
        setColocationId((C) reader.readObject("colocationId"));
    }

    @Override
    public void toData(PdxWriter writer) {
        writer.writeObject("id", getId());
        writer.writeObject("colocationId", getColocationId());
        writer.markIdentityField("id");
    }
}
