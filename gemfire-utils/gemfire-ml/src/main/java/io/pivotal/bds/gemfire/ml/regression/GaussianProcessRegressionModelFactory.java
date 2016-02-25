package io.pivotal.bds.gemfire.ml.regression;

import java.util.Map;

import io.pivotal.bds.gemfire.ml.Model;
import io.pivotal.bds.gemfire.ml.MetaModel;
import io.pivotal.bds.gemfire.ml.ModelName;
import io.pivotal.bds.gemfire.ml.MetaParameter;
import io.pivotal.bds.gemfire.ml.ModelType;
import smile.math.kernel.GaussianKernel;
import smile.math.kernel.MercerKernel;

public class GaussianProcessRegressionModelFactory extends AbstractRegressionModelFactory {

    private static final Double DEFAULT_SIGMA = 1.0;
    private static final Double DEFAULT_LAMBDA = 1.0;

    public GaussianProcessRegressionModelFactory() {
        super(createModelDef());
    }

    @SuppressWarnings("unchecked")
    @Override
    protected Model<double[][], double[], double[], Double> doCreate(String id, Map<String, Object> properties) {
        MercerKernel<double[]> kernel = (MercerKernel<double[]>) properties.get("kernel");
        
        if (kernel == null) {
            Double sigma = (Double) properties.getOrDefault("sigma", DEFAULT_SIGMA);
            kernel = new GaussianKernel(sigma);
        }
        
        Double lambda = (Double) properties.getOrDefault("lambda", DEFAULT_LAMBDA);
        return new GaussianProcessRegressionModel(id, def, kernel, lambda);
    }

    private static MetaModel createModelDef() {
        MetaModel def = new MetaModel(ModelType.regression, ModelName.GaussianProcess);
        def.getParameters().add(new MetaParameter("sigma", Double.class, DEFAULT_SIGMA, false));
        def.getParameters().add(new MetaParameter("lambda", Double.class, DEFAULT_LAMBDA, false));
        def.getParameters().add(new MetaParameter("kernel", MercerKernel.class, null, true));
        return def;
    }
}
