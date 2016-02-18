package io.pivotal.bds.gemfire.ml.classification;

import java.util.Map;

import io.pivotal.bds.gemfire.ml.Model;
import io.pivotal.bds.gemfire.ml.MetaModel;
import io.pivotal.bds.gemfire.ml.ModelName;
import io.pivotal.bds.gemfire.ml.MetaParameter;
import io.pivotal.bds.gemfire.ml.ModelType;

public class RandomForestModelFactory extends AbstractClassificationModelFactory {

    private static final int DEFAULT_T = 1;
    private static final int DEFAULT_M = 1;

    public RandomForestModelFactory() {
        super(createModelDef());
    }

    @Override
    protected Model<double[][], int[], double[], Integer> doCreate(String id, Map<String, Object> properties) {
        Integer t = (Integer) properties.getOrDefault("T", DEFAULT_T);
        Integer m = (Integer) properties.getOrDefault("M", DEFAULT_M);
        return new RandomForestModel(id, def, t, m);
    }

    private static MetaModel createModelDef() {
        MetaModel def = new MetaModel(ModelType.classification, ModelName.RandomForest);
        def.getParameters().add(new MetaParameter("T", Integer.class, DEFAULT_T, false));
        def.getParameters().add(new MetaParameter("M", Integer.class, DEFAULT_M, false));
        return def;
    }
}
