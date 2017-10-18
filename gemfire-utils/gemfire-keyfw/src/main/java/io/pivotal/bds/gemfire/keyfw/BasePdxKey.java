package io.pivotal.bds.gemfire.keyfw;

import org.apache.geode.pdx.PdxReader;
import org.apache.geode.pdx.PdxSerializable;
import org.apache.geode.pdx.PdxWriter;

import io.pivotal.bds.gemfire.key.BaseKey;

public class BasePdxKey<T> extends BaseKey<T> implements PdxSerializable {

    public BasePdxKey() {
    }

    public BasePdxKey(T id) {
        super(id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void fromData(PdxReader reader) {
        setId((T) reader.readObject("id"));
    }

    @Override
    public void toData(PdxWriter writer) {
        writer.writeObject("id", getId());
        writer.markIdentityField("id");
    }
}
