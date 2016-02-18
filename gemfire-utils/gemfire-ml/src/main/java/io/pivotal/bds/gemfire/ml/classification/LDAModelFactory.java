package io.pivotal.bds.gemfire.ml.classification;

import java.util.Map;

import io.pivotal.bds.gemfire.ml.Model;
import io.pivotal.bds.gemfire.ml.MetaModel;
import io.pivotal.bds.gemfire.ml.ModelName;
import io.pivotal.bds.gemfire.ml.MetaParameter;
import io.pivotal.bds.gemfire.ml.ModelType;

public class LDAModelFactory extends AbstractClassificationModelFactory {

    private static final double DEFAULT_TOL = 1.0;

    public LDAModelFactory() {
        super(createModelDef());
    }

    @Override
    protected Model<double[][], int[], double[], Integer> doCreate(String id, Map<String, Object> properties) {
        Double tol = (Double) properties.getOrDefault("tol", DEFAULT_TOL);
        return new LDAModel(id, def, tol);
    }

    private static MetaModel createModelDef() {
        MetaModel def = new MetaModel(ModelType.classification, ModelName.LDA);
        def.getParameters().add(new MetaParameter("tol", Double.class, DEFAULT_TOL, false));
        return def;
    }
}
