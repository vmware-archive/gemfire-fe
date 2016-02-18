package io.pivotal.bds.gemfire.ml;

import java.util.Map;

public interface Model<X, Y, T, P> {

    MetaModel getMetadata();
    
    String getId();
    
    Map<String, Object> getAttributes();

    void train(X x, Y y);

    P predict(T t);
}
