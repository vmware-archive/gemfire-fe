package io.pivotal.bds.gemfire.ml;

public interface ModelManager {

    Model getModel(String modelName);

    void createModel(Model model);

    void updateModel(Model model);

    Model deleteModel(String modelName);
}
