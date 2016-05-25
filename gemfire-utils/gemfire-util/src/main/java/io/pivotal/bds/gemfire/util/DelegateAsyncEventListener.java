package io.pivotal.bds.gemfire.util;

import com.gemstone.gemfire.cache.asyncqueue.AsyncEventListener;

public abstract class DelegateAsyncEventListener implements AsyncEventListener {

    public DelegateAsyncEventListener(DelegatingAsyncEventListener ael) {
        ael.addDelegate(this);
    }

}
