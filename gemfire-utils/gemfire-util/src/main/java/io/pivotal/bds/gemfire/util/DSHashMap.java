package io.pivotal.bds.gemfire.util;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.geode.DataSerializable;
import org.apache.geode.DataSerializer;

public class DSHashMap<K, V> extends HashMap<K, V> implements DataSerializable {

    private static final long serialVersionUID = 1L;

    public DSHashMap() {
    }

    public DSHashMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    public DSHashMap(int initialCapacity) {
        super(initialCapacity);
    }

    public DSHashMap(Map<? extends K, ? extends V> m) {
        super(m);
    }

    @Override
    public void fromData(DataInput in) throws IOException, ClassNotFoundException {
        clear();
        int c = in.readInt();

        for (int i = 0; i < c; ++i) {
            K k = DataSerializer.readObject(in);
            V v = DataSerializer.readObject(in);
            put(k, v);
        }
    }

    @Override
    public void toData(DataOutput out) throws IOException {
        int c = size();
        out.writeInt(c);
        
        for (Map.Entry<K, V> e: entrySet()) {
            DataSerializer.writeObject(e.getKey(), out);
            DataSerializer.writeObject(e.getValue(), out);
        }
    }
}
