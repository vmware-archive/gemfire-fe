package io.pivotal.bds.gemfire.ml.classification;

import java.util.Map;

import io.pivotal.bds.gemfire.ml.Model;
import io.pivotal.bds.gemfire.ml.MetaModel;
import io.pivotal.bds.gemfire.ml.ModelName;
import io.pivotal.bds.gemfire.ml.MetaParameter;
import io.pivotal.bds.gemfire.ml.ModelType;

public class RDAModelFactory extends AbstractClassificationModelFactory {

    private static final double DEFAULT_ALPHA = 1.0;

    public RDAModelFactory() {
        super(createModelDef());
    }

    @Override
    protected Model<double[][], int[], double[], Integer> doCreate(String id, Map<String, Object> properties) {
        Double alpha = (Double) properties.getOrDefault("alpha", DEFAULT_ALPHA);
        return new RDAModel(id, def, alpha);
    }

    private static MetaModel createModelDef() {
        MetaModel def = new MetaModel(ModelType.classification, ModelName.RDA);
        def.getParameters().add(new MetaParameter("alpha", Double.class, DEFAULT_ALPHA, false));
        return def;
    }
}
