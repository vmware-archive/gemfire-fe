package io.pivotal.bds.gemfire.ml.classification;

import java.util.Map;

import io.pivotal.bds.gemfire.ml.Model;
import io.pivotal.bds.gemfire.ml.MetaModel;
import io.pivotal.bds.gemfire.ml.ModelName;
import io.pivotal.bds.gemfire.ml.MetaParameter;
import io.pivotal.bds.gemfire.ml.ModelType;

public class FLDModelFactory extends AbstractClassificationModelFactory {

    private static final int DEFAULT_L = 1;
    private static final double DEFAULT_TOL = 1.0;

    public FLDModelFactory() {
        super(createModelDef());
    }

    @Override
    protected Model<double[][], int[], double[], Integer> doCreate(String id, Map<String, Object> properties) {
        Integer l = (Integer) properties.getOrDefault("L", DEFAULT_L);
        Double tol = (Double) properties.getOrDefault("tol", DEFAULT_TOL);
        return new FLDModel(id, def, l, tol);
    }

    private static MetaModel createModelDef() {
        MetaModel def = new MetaModel(ModelType.classification, ModelName.FLD);
        def.getParameters().add(new MetaParameter("L", Integer.class, DEFAULT_L, false));
        def.getParameters().add(new MetaParameter("tol", Double.class, DEFAULT_TOL, false));
        return def;
    }
}
