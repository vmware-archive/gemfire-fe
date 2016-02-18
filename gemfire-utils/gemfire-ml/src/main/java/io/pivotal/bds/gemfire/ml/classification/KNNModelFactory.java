package io.pivotal.bds.gemfire.ml.classification;

import java.util.Map;

import io.pivotal.bds.gemfire.ml.Model;
import io.pivotal.bds.gemfire.ml.MetaModel;
import io.pivotal.bds.gemfire.ml.ModelName;
import io.pivotal.bds.gemfire.ml.MetaParameter;
import io.pivotal.bds.gemfire.ml.ModelType;

public class KNNModelFactory extends AbstractClassificationModelFactory {

    private static final int DEFAULT_K = 10;

    public KNNModelFactory() {
        super(createModelDef());
    }

    @Override
    protected Model<double[][], int[], double[], Integer> doCreate(String id, Map<String, Object> properties) {
        Integer k = (Integer) properties.getOrDefault("k", DEFAULT_K);
        return new KNNModel(id, def, k);
    }

    private static MetaModel createModelDef() {
        MetaModel def = new MetaModel(ModelType.classification, ModelName.KNN);
        def.getParameters().add(new MetaParameter("K", Integer.class, DEFAULT_K, false));
        return def;
    }
}
