package io.pivotal.bds.gemfire.util;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

import com.gemstone.gemfire.DataSerializable;
import com.gemstone.gemfire.DataSerializer;

public class DSHashSet<E> extends HashSet<E> implements DataSerializable {

    private static final long serialVersionUID = 1L;

    public DSHashSet() {
    }

    public DSHashSet(Collection<? extends E> c) {
        super(c);
    }

    public DSHashSet(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    public DSHashSet(int initialCapacity) {
        super(initialCapacity);
    }

    @Override
    public void fromData(DataInput in) throws IOException, ClassNotFoundException {
        clear();
        int c = in.readInt();
        for (int i = 0; i < c; ++i) {
            E e = DataSerializer.readObject(in);
            add(e);
        }
    }

    @Override
    public void toData(DataOutput out) throws IOException {
        int c = size();
        out.writeInt(c);
        for (E e : this) {
            DataSerializer.writeObject(e, out);
        }
    }

}
