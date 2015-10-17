package io.pivotal.bds.gemfire.drools.server.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.kie.api.runtime.Globals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;

public class ApplicationContextGlobals implements Globals {

    private ApplicationContext context;
    private final Map<String, Object> vals = new HashMap<>();
    private Globals delegate;

    private static final Logger LOG = LoggerFactory.getLogger(ApplicationContextGlobals.class);

    public ApplicationContextGlobals(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public Object get(String identifier) {
        LOG.info("get: identifier={}", identifier);

        Object value = null;

        try {
            value = context.getBean(identifier);
        } catch (NoSuchBeanDefinitionException x) {
            value = vals.get(identifier);
        }

        if (value == null && delegate != null) {
            value = delegate.get(identifier);
        }

        if (value == null) {
            throw new IllegalArgumentException("Value for identifier " + identifier + " does not exist");
        }

        LOG.info("get: identifier={}, value={}", identifier, value);
        return value;
    }

    @Override
    public void set(String identifier, Object value) {
        LOG.info("set: identifier={}, value={}", identifier, value);
        vals.put(identifier, value);
    }

    @Override
    public void setDelegate(Globals delegate) {
        LOG.info("setDelegate: delegate.class={}", delegate.getClass().getName());
        this.delegate = delegate;
    }

    @Override
    public Collection<String> getGlobalKeys() {
        Set<String> s = new HashSet<>(vals.keySet());

        if (delegate != null) {
            s.addAll(delegate.getGlobalKeys());
        }

        for (String r : context.getBeanDefinitionNames()) {
            s.add(r);
        }

        return s;
    }

}
