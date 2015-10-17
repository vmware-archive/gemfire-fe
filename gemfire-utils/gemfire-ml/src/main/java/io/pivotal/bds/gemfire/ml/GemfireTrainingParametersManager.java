package io.pivotal.bds.gemfire.ml;

import com.gemstone.gemfire.cache.Region;

public class GemfireTrainingParametersManager implements TrainingParametersManager {

    private Region<String, TrainingParameters> region;

    public GemfireTrainingParametersManager(Region<String, TrainingParameters> region) {
        this.region = region;
    }

    @Override
    public TrainingParameters getParameters(String modelName) {
        TrainingParameters params = region.get(modelName);
        return params;
    }

    @Override
    public void createParameters(TrainingParameters params) {
        TrainingParameters op = region.putIfAbsent(params.getModelName(), params);
    }

    @Override
    public void updateParameters(TrainingParameters params) {
        TrainingParameters op = region.put(params.getModelName(), params);
    }

    @Override
    public TrainingParameters deleteParameters(String modelName) {
        TrainingParameters op = region.get(modelName);
        return op;
    }

}
