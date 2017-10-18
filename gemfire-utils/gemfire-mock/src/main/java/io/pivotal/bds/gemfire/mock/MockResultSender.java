package io.pivotal.bds.gemfire.mock;

import org.apache.geode.cache.execute.ResultSender;

import java.util.Collection;

/**
 * Created by tdalsing on 3/23/17.
 */
public class MockResultSender<T> implements ResultSender<T> {

    private Collection<Object> results;

    public MockResultSender(Collection<Object> results) {
        this.results = results;
    }

    @Override
    public void sendResult(T t) {
        results.add(t);
    }

    @Override
    public void lastResult(T t) {
        results.add(t);
    }

    @Override
    public void sendException(Throwable throwable) {
        results.add(throwable);
    }
}
