package io.pivotal.bds.gemfire.ml.regression;

import java.util.Map;

import io.pivotal.bds.gemfire.ml.Model;
import io.pivotal.bds.gemfire.ml.MetaModel;
import io.pivotal.bds.gemfire.ml.ModelName;
import io.pivotal.bds.gemfire.ml.MetaParameter;
import io.pivotal.bds.gemfire.ml.ModelType;
import io.pivotal.bds.gemfire.ml.util.PropertiesSupport;

public class RandomForestModelFactory extends AbstractRegressionModelFactory {

    private static final Integer DEFAULT_T = 1;
    private static final Integer DEFAULT_M = 1;
    private static final Integer DEFAULT_S = 1;

    public RandomForestModelFactory() {
        super(createModelDef());
    }

    @Override
    protected Model<double[][], double[], double[], Double> doCreate(String id, Map<String, Object> properties) {
        int T = PropertiesSupport.getIntegerProperty(properties, "T", DEFAULT_T);
        int M = PropertiesSupport.getIntegerProperty(properties, "M", DEFAULT_M);
        int S = PropertiesSupport.getIntegerProperty(properties, "S", DEFAULT_S);
        return new RandomForestModel(id, def, T, M, S);
    }

    private static MetaModel createModelDef() {
        MetaModel def = new MetaModel(ModelType.regression, ModelName.RandomForest);
        def.getParameters().add(new MetaParameter("T", Integer.class, DEFAULT_T, false));
        def.getParameters().add(new MetaParameter("M", Integer.class, DEFAULT_M, false));
        def.getParameters().add(new MetaParameter("S", Integer.class, DEFAULT_S, false));
        return def;
    }
}
