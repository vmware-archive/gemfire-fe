package io.pivotal.bds.gemfire.ml;

import java.util.ArrayList;
import java.util.List;

public class MetaModel {

    private ModelType type;
    private ModelName name;
    private final List<MetaParameter> parameters = new ArrayList<>();

    public MetaModel(ModelType type, ModelName name) {
        this.type = type;
        this.name = name;
    }

    public ModelType getType() {
        return type;
    }

    public ModelName getName() {
        return name;
    }

    public List<MetaParameter> getParameters() {
        return parameters;
    }

    @Override
    public String toString() {
        return "ModelDef [type=" + type + ", name=" + name + ", parameters=" + parameters + "]";
    }

}
