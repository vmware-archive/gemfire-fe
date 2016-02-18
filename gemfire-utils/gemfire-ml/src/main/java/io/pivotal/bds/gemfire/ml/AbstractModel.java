package io.pivotal.bds.gemfire.ml;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractModel<X, Y, T, P> implements Model<X, Y, T, P> {

    private String id;
    private MetaModel def;
    private Map<String, Object> attributes = new HashMap<>();

    public AbstractModel(String id, MetaModel def) {
        this.id = id;
        this.def = def;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MetaModel getMetadata() {
        return def;
    }

    public void setDef(MetaModel def) {
        this.def = def;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [id=" + id + ", def=" + def + ", attributes=" + attributes + "]";
    }

}
