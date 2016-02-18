package io.pivotal.bds.gemfire.ml.classification;

import java.util.Map;

import io.pivotal.bds.gemfire.ml.Model;
import io.pivotal.bds.gemfire.ml.MetaModel;
import io.pivotal.bds.gemfire.ml.ModelName;
import io.pivotal.bds.gemfire.ml.MetaParameter;
import io.pivotal.bds.gemfire.ml.ModelType;

public class LogisticRegressionModelFactory extends AbstractClassificationModelFactory {

    private static final double DEFAULT_LAMBDA = 1.0;
    private static final double DEFAULT_TOL = 1.0;
    private static final int DEFAULT_MAXITER = 10;

    public LogisticRegressionModelFactory() {
        super(createModelDef());
    }

    @Override
    protected Model<double[][], int[], double[], Integer> doCreate(String id, Map<String, Object> properties) {
        Double lambda = (Double) properties.getOrDefault("lambda", DEFAULT_LAMBDA);
        Double tol = (Double) properties.getOrDefault("tol", DEFAULT_TOL);
        Integer maxIter = (Integer) properties.getOrDefault("maxIter", DEFAULT_MAXITER);
        return new LogisticRegressionModel(id, def, lambda, tol, maxIter);
    }

    private static MetaModel createModelDef() {
        MetaModel def = new MetaModel(ModelType.classification, ModelName.LogisticRegression);
        def.getParameters().add(new MetaParameter("lambda", Double.class, DEFAULT_LAMBDA, false));
        def.getParameters().add(new MetaParameter("tol", Double.class, DEFAULT_TOL, false));
        def.getParameters().add(new MetaParameter("maxIter", Integer.class, DEFAULT_MAXITER, false));
        return def;
    }
}
