package io.pivotal.bds.gemfire.ml;

import com.gemstone.gemfire.cache.Region;

public class GemfireModelManager implements ModelManager {

    private Region<String, Model> region;

    public GemfireModelManager(Region<String, Model> region) {
        this.region = region;
    }

    @Override
    public Model getModel(String modelName) {
        Model m = region.get(modelName);
        return m;
    }

    @Override
    public void createModel(Model model) {
        Model om = region.putIfAbsent(model.getName(), model);
    }

    @Override
    public void updateModel(Model model) {
        Model om = region.put(model.getName(), model);
    }

    @Override
    public Model deleteModel(String modelName) {
        Model om = region.get(modelName);
        return om;
    }

}
