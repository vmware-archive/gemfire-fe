package io.pivotal.bds.gemfire.ml.regression;

import java.util.Map;

import io.pivotal.bds.gemfire.ml.Model;
import io.pivotal.bds.gemfire.ml.MetaModel;
import io.pivotal.bds.gemfire.ml.ModelName;
import io.pivotal.bds.gemfire.ml.MetaParameter;
import io.pivotal.bds.gemfire.ml.ModelType;
import io.pivotal.bds.gemfire.ml.util.PropertiesSupport;

public class LASSOModelFactory extends AbstractRegressionModelFactory {

    private static final Double DEFAULT_LAMBDA = 1.0;
    private static final Double DEFAULT_TOL = 1.0;
    private static final Integer DEFAULT_MAXITER = 10;

    public LASSOModelFactory() {
        super(createModelDef());
    }

    @Override
    protected Model<double[][], double[], double[], Double> doCreate(String id, Map<String, Object> properties) {
        double lambda = PropertiesSupport.getDoubleProperty(properties, "lambda", DEFAULT_LAMBDA);
        double tol = PropertiesSupport.getDoubleProperty(properties, "tol", DEFAULT_TOL);
        int maxIter = PropertiesSupport.getIntegerProperty(properties, "maxIter", DEFAULT_MAXITER);
        return new LASSOModel(id, def, lambda, tol, maxIter);
    }

    private static MetaModel createModelDef() {
        MetaModel def = new MetaModel(ModelType.regression, ModelName.LASSO);
        def.getParameters().add(new MetaParameter("lambda", Double.class, DEFAULT_LAMBDA, false));
        def.getParameters().add(new MetaParameter("tol", Double.class, DEFAULT_TOL, false));
        def.getParameters().add(new MetaParameter("maxIter", Integer.class, DEFAULT_MAXITER, false));
        return def;
    }
}
