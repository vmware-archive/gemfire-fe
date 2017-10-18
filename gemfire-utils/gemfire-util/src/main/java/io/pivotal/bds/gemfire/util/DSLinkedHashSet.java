package io.pivotal.bds.gemfire.util;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedHashSet;

import org.apache.geode.DataSerializable;
import org.apache.geode.DataSerializer;

public class DSLinkedHashSet<E> extends LinkedHashSet<E> implements DataSerializable {

    private static final long serialVersionUID = 1L;

    public DSLinkedHashSet() {
    }

    public DSLinkedHashSet(Collection<? extends E> c) {
        super(c);
    }

    public DSLinkedHashSet(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    public DSLinkedHashSet(int initialCapacity) {
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
