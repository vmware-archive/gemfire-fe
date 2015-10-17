package io.pivotal.bds.gemfire.ml;

public abstract class AbstractModel implements Model {

    private String name;
    private String attributeName;
    private ModelType type;

    public AbstractModel(String name, String attributeName, ModelType type) {
        this.name = name;
        this.attributeName = attributeName;
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAttributeName() {
        return attributeName;
    }

    @Override
    public ModelType getType() {
        return type;
    }

}
