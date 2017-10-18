package io.pivotal.bds.gemfire.drools.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.kie.api.runtime.Globals;

import org.apache.geode.cache.Cache;
import org.apache.geode.cache.Region;

public class RegionGlobals implements Globals {

    private Cache cache;
    private final Map<String, Object> vals = new HashMap<>();
    private Globals delegate;

    public RegionGlobals(Cache cache) {
        this.cache = cache;
    }

    @Override
    public Object get(String identifier) {
        Object o = cache.getRegion(identifier);

        if (o == null) {
            o = vals.get(identifier);
        }

        if (o == null && delegate != null) {
            o = delegate.get(identifier);
        }

        if (o == null) {
            throw new IllegalArgumentException("Value for identifier " + identifier + " does not exist");
        }

        return o;
    }

    @Override
    public void set(String identifier, Object value) {
        vals.put(identifier, value);
    }

    @Override
    public void setDelegate(Globals delegate) {
        this.delegate = delegate;
    }

    @Override
    public Collection<String> getGlobalKeys() {
        Set<String> s = new HashSet<>(vals.keySet());

        if (delegate != null) {
            s.addAll(delegate.getGlobalKeys());
        }

        for (Region<?, ?> r : cache.rootRegions()) {
            s.add(r.getName());
        }

        return s;
    }

}
