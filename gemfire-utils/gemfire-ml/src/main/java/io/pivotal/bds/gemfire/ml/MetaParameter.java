package io.pivotal.bds.gemfire.ml;

public class MetaParameter {

    private String name;
    private Class<?> type;
    private Object def;
    private boolean required;

    public MetaParameter(String name, Class<?> type, Object def, boolean required) {
        this.name = name;
        this.type = type;
        this.def = def;
        this.required = required;
    }

    public String getName() {
        return name;
    }

    public Class<?> getType() {
        return type;
    }

    public Object getDef() {
        return def;
    }

    public boolean isRequired() {
        return required;
    }

}
