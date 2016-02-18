package io.pivotal.bds.gemfire.ml.regression;

import java.util.Map;

import io.pivotal.bds.gemfire.ml.Model;
import io.pivotal.bds.gemfire.ml.MetaModel;
import io.pivotal.bds.gemfire.ml.ModelName;
import io.pivotal.bds.gemfire.ml.MetaParameter;
import io.pivotal.bds.gemfire.ml.ModelType;
import io.pivotal.bds.gemfire.ml.util.PropertiesSupport;
import smile.regression.GradientTreeBoost.Loss;

public class GradientTreeBoostModelFactory extends AbstractRegressionModelFactory {

    private static final Loss DEFAULT_LOSS = Loss.LeastSquares;
    private static final Integer DEFAULT_NTREES = 10;
    private static final Integer DEFAULT_MAXNODES = 10;
    private static final Double DEFAULT_SHRINKAGE = 1.0;
    private static final Double DEFAULT_F = 1.0;

    public GradientTreeBoostModelFactory() {
        super(createModelDef());
    }

    @Override
    protected Model<double[][], double[], double[], Double> doCreate(String id, Map<String, Object> properties) {
        Loss loss = (Loss) properties.getOrDefault("loss", DEFAULT_LOSS);
        int ntrees = PropertiesSupport.getIntegerProperty(properties, "ntrees", DEFAULT_NTREES);
        int maxNodes = PropertiesSupport.getIntegerProperty(properties, "maxNodes", DEFAULT_MAXNODES);
        double shrinkage = PropertiesSupport.getDoubleProperty(properties, "shrinkage", DEFAULT_SHRINKAGE);
        double f = PropertiesSupport.getDoubleProperty(properties, "f", DEFAULT_F);
        return new GradientTreeBoostModel(id, def, loss, ntrees, maxNodes, shrinkage, f);
    }

    private static MetaModel createModelDef() {
        MetaModel def = new MetaModel(ModelType.regression, ModelName.GradientTreeBoost);
        def.getParameters().add(new MetaParameter("loss", Loss.class, DEFAULT_LOSS, false));
        def.getParameters().add(new MetaParameter("ntrees", Integer.class, DEFAULT_NTREES, false));
        def.getParameters().add(new MetaParameter("maxNodes", Integer.class, DEFAULT_MAXNODES, false));
        def.getParameters().add(new MetaParameter("shrinkage", Double.class, DEFAULT_SHRINKAGE, false));
        def.getParameters().add(new MetaParameter("f", Double.class, DEFAULT_F, false));
        return def;
    }
}
