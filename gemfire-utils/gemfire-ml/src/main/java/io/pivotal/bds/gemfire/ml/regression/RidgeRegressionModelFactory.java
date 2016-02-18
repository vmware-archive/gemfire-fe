package io.pivotal.bds.gemfire.ml.regression;

import java.util.Map;

import io.pivotal.bds.gemfire.ml.Model;
import io.pivotal.bds.gemfire.ml.MetaModel;
import io.pivotal.bds.gemfire.ml.ModelName;
import io.pivotal.bds.gemfire.ml.MetaParameter;
import io.pivotal.bds.gemfire.ml.ModelType;
import io.pivotal.bds.gemfire.ml.util.PropertiesSupport;

public class RidgeRegressionModelFactory extends AbstractRegressionModelFactory {

    private static final Double DEFAULT_LAMBDA = 1.0;

    public RidgeRegressionModelFactory() {
        super(createModelDef());
    }

    @Override
    protected Model<double[][], double[], double[], Double> doCreate(String id, Map<String, Object> properties) {
        double lamdba = PropertiesSupport.getDoubleProperty(properties, "lambda", DEFAULT_LAMBDA);
        return new RidgeRegressionModel(id, def, lamdba);
    }

    private static MetaModel createModelDef() {
        MetaModel def = new MetaModel(ModelType.regression, ModelName.RidgeRegression);
        def.getParameters().add(new MetaParameter("lambda", Double.class, DEFAULT_LAMBDA, false));
        return def;
    }
}
