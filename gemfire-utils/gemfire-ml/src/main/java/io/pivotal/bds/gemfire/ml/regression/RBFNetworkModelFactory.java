package io.pivotal.bds.gemfire.ml.regression;

import java.util.Map;

import io.pivotal.bds.gemfire.ml.Model;
import io.pivotal.bds.gemfire.ml.MetaModel;
import io.pivotal.bds.gemfire.ml.ModelName;
import io.pivotal.bds.gemfire.ml.MetaParameter;
import io.pivotal.bds.gemfire.ml.ModelType;
import io.pivotal.bds.gemfire.ml.util.PropertiesSupport;
import smile.math.distance.EuclideanDistance;
import smile.math.distance.Metric;
import smile.math.rbf.GaussianRadialBasis;
import smile.math.rbf.RadialBasisFunction;

public class RBFNetworkModelFactory extends AbstractRegressionModelFactory {

    private static final Metric<double[]> DEFAULT_DISTANCE = new EuclideanDistance();
    private static final RadialBasisFunction DEFAULT_RADIAL_BASIS_FUNCTION = new GaussianRadialBasis();
    private static final Boolean DEFAULT_NORMALIZED = Boolean.FALSE;

    public RBFNetworkModelFactory() {
        super(createModelDef());
    }

    @SuppressWarnings("unchecked")
    @Override
    protected Model<double[][], double[], double[], Double> doCreate(String id, Map<String, Object> properties) {
        Metric<double[]> distance = PropertiesSupport.getProperty(properties, "distance", Metric.class, DEFAULT_DISTANCE);
        RadialBasisFunction rbfunc = PropertiesSupport.getProperty(properties, "rbfunc", RadialBasisFunction.class,
                DEFAULT_RADIAL_BASIS_FUNCTION);
        double[][] centers = PropertiesSupport.getRequiredProperty(properties, "centers", double[][].class);
        boolean normalized = PropertiesSupport.getBooleanProperty(properties, "normalized", DEFAULT_NORMALIZED);
        return new RBFNetworkModel(id, def, distance, rbfunc, centers, normalized);
    }

    private static MetaModel createModelDef() {
        MetaModel def = new MetaModel(ModelType.regression, ModelName.RBFNetwork);
        def.getParameters().add(new MetaParameter("distance", Metric.class, DEFAULT_DISTANCE, false));
        def.getParameters().add(new MetaParameter("rbfunc", RadialBasisFunction.class, DEFAULT_RADIAL_BASIS_FUNCTION, false));
        def.getParameters().add(new MetaParameter("centers", double[][].class, null, true));
        def.getParameters().add(new MetaParameter("normalized", Boolean.class, DEFAULT_NORMALIZED, false));
        return def;
    }
}
