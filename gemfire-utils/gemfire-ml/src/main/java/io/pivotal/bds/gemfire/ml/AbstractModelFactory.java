package io.pivotal.bds.gemfire.ml;

import java.util.Map;

public abstract class AbstractModelFactory<X, Y, T, P> implements ModelFactory<X, Y, T, P> {

    protected MetaModel def;

    public AbstractModelFactory(MetaModel def) {
        this.def = def;
    }

    @Override
    public MetaModel getMetadata() {
        return def;
    }

    @Override
    public final Model<X, Y, T, P> create(String id, Map<String, Object> properties) {
        Model<X, Y, T, P> m = doCreate(id, properties);
        m.getAttributes().putAll(properties);
        return m;
    }

    protected abstract Model<X, Y, T, P> doCreate(String id, Map<String, Object> properties);
}
