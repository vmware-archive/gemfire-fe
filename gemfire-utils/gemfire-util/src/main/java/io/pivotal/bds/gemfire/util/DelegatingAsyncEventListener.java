package io.pivotal.bds.gemfire.util;

import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.springframework.util.Assert;

import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.asyncqueue.AsyncEvent;
import org.apache.geode.cache.asyncqueue.AsyncEventListener;

public class DelegatingAsyncEventListener implements AsyncEventListener, Declarable {

    private Set<AsyncEventListener> delegates = new HashSet<>();

    public void addDelegate(AsyncEventListener ael) {
        Assert.notNull(ael);
        delegates.add(ael);
    }

    public void removeDelegate(AsyncEventListener ael) {
        Assert.notNull(ael);
        delegates.remove(ael);
    }

    @Override
    public void close() {
    }

    @Override
    public void init(Properties props) {
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean processEvents(List<AsyncEvent> events) {
        for (AsyncEventListener ael : delegates) {
            boolean b = ael.processEvents(events);
            if (!b) {
                return false;
            }
        }
        return true;
    }

}
