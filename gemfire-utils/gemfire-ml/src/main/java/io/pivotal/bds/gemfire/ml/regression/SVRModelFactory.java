package io.pivotal.bds.gemfire.ml.regression;

import java.util.Map;

import io.pivotal.bds.gemfire.ml.Model;
import io.pivotal.bds.gemfire.ml.MetaModel;
import io.pivotal.bds.gemfire.ml.ModelName;
import io.pivotal.bds.gemfire.ml.MetaParameter;
import io.pivotal.bds.gemfire.ml.ModelType;
import io.pivotal.bds.gemfire.ml.util.PropertiesSupport;
import smile.math.kernel.GaussianKernel;
import smile.math.kernel.MercerKernel;

public class SVRModelFactory extends AbstractRegressionModelFactory {

    private static final MercerKernel<double[]> DEFAULT_KERNEL = new GaussianKernel(1.0);
    private static final Double DEFAULT_EPS = 1.0;
    private static final Double DEFAULT_C = 1.0;
    private static final Double DEFAULT_TOL = 1.0;

    public SVRModelFactory() {
        super(createModelDef());
    }

    @SuppressWarnings("unchecked")
    @Override
    protected Model<double[][], double[], double[], Double> doCreate(String id, Map<String, Object> properties) {
        MercerKernel<double[]> kernel = PropertiesSupport.getProperty(properties, "kernel", MercerKernel.class, DEFAULT_KERNEL);
        double eps = PropertiesSupport.getDoubleProperty(properties, "eps", DEFAULT_EPS);
        double C = PropertiesSupport.getDoubleProperty(properties, "C", DEFAULT_C);
        double tol = PropertiesSupport.getDoubleProperty(properties, "tol", DEFAULT_TOL);
        return new SVRModel(id, def, kernel, eps, C, tol);
    }

    private static MetaModel createModelDef() {
        MetaModel def = new MetaModel(ModelType.regression, ModelName.SVR);
        def.getParameters().add(new MetaParameter("kernel", MercerKernel.class, DEFAULT_KERNEL, false));
        def.getParameters().add(new MetaParameter("eps", Double.class, DEFAULT_EPS, false));
        def.getParameters().add(new MetaParameter("C", Double.class, DEFAULT_C, false));
        def.getParameters().add(new MetaParameter("tol", Double.class, DEFAULT_TOL, false));
        return def;
    }
}
