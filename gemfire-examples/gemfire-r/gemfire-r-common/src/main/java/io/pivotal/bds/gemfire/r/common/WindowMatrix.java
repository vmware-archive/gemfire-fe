package io.pivotal.bds.gemfire.r.common;

@SuppressWarnings("serial")
public class WindowMatrix<V> extends Window<Matrix<V>> {

    public WindowMatrix(int size) {
        super(size);
    }

}
