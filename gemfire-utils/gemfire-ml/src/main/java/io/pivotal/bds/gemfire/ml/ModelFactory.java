package io.pivotal.bds.gemfire.ml;

import java.util.Map;

public interface ModelFactory<X, Y, T, P> {

    MetaModel getMetadata();

    Model<X, Y, T, P> create(String id, Map<String, Object> properties);
}
