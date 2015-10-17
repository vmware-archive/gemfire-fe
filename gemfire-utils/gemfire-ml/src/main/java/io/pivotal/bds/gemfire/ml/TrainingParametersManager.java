package io.pivotal.bds.gemfire.ml;

public interface TrainingParametersManager {

    TrainingParameters getParameters(String modelName);

    void createParameters(TrainingParameters params);

    void updateParameters(TrainingParameters params);

    TrainingParameters deleteParameters(String modelName);
}
