package io.pivotal.bds.gemfire.ml;

public interface ModelFactoryManager {

    ModelFactory getFactory(ModelType type);
}
