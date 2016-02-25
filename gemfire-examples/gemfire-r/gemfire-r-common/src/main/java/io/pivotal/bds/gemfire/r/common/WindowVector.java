package io.pivotal.bds.gemfire.r.common;

@SuppressWarnings("serial")
public class WindowVector<V> extends Window<Vector<V>> {

    public WindowVector(int size) {
        super(size);
    }

}
