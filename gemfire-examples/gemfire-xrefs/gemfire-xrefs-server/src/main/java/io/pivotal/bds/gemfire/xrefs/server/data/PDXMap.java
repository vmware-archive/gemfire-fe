package io.pivotal.bds.gemfire.xrefs.server.data;

import java.util.HashMap;
import java.util.Map;

import com.gemstone.gemfire.pdx.PdxReader;
import com.gemstone.gemfire.pdx.PdxSerializable;
import com.gemstone.gemfire.pdx.PdxWriter;

public class PDXMap<K, V> extends HashMap<K, V>implements PdxSerializable {

    private static final long serialVersionUID = 1L;

    public PDXMap() {
    }

    public PDXMap(int initialCapacity) {
        super(initialCapacity);
    }

    public PDXMap(Map<? extends K, ? extends V> m) {
        super(m);
    }

    public PDXMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    @Override
    public void fromData(PdxReader reader) {
    }

    @Override
    public void toData(PdxWriter writer) {
    }

}
