package io.pivotal.bds.gemfire.ml.fld;

import java.util.Properties;

import io.pivotal.bds.gemfire.ml.Model;
import io.pivotal.bds.gemfire.ml.ModelFactory;
import io.pivotal.bds.gemfire.ml.util.PropertiesSupport;

public class FLDModelFactory implements ModelFactory {

    private static final int DEFAULT_L = 1;
    private static final double DEFAULT_TOL = 1.0;
    private static final String[] PROPERTY_NAMES = { "L", "tol" };

    @Override
    public String[] getPropertyNames() {
        return PROPERTY_NAMES;
    }

    @Override
    public Model create(String name, String attributeName, Properties properties) {
        Integer l = PropertiesSupport.getIntegerProperty(properties, "fld.L", DEFAULT_L);
        Double tol = PropertiesSupport.getDoubleProperty(properties, "fld.tol", DEFAULT_TOL);
        return new FLDModel(name, attributeName, l, tol);
    }

}
