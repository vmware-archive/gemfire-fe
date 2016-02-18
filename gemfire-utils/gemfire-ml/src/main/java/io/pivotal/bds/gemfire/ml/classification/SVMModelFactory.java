package io.pivotal.bds.gemfire.ml.classification;

import java.util.Map;

import io.pivotal.bds.gemfire.ml.Model;
import io.pivotal.bds.gemfire.ml.MetaModel;
import io.pivotal.bds.gemfire.ml.ModelName;
import io.pivotal.bds.gemfire.ml.MetaParameter;
import io.pivotal.bds.gemfire.ml.ModelType;
import smile.classification.SVM;
import smile.math.kernel.GaussianKernel;

public class SVMModelFactory extends AbstractClassificationModelFactory {

    private static final double DEFAULT_SIGMA = 1.0;
    private static final double DEFAULT_CP = 1.0;
    private static final double DEFAULT_CN = 1.0;

    public SVMModelFactory() {
        super(createModelDef());
    }

    @Override
    protected Model<double[][], int[], double[], Integer> doCreate(String id, Map<String, Object> properties) {
        Double sigma = (Double) properties.getOrDefault("sigma", DEFAULT_SIGMA);
        Double cp = (Double) properties.getOrDefault("cp", DEFAULT_CP);
        Double cn = (Double) properties.getOrDefault("cn", DEFAULT_CN);

        SVM<double[]> svm = new SVM<double[]>(new GaussianKernel(sigma), cp, cn);
        return new SVMModel(id, def, svm);
    }

    private static MetaModel createModelDef() {
        MetaModel def = new MetaModel(ModelType.classification, ModelName.SVM);
        def.getParameters().add(new MetaParameter("sigma", Double.class, DEFAULT_SIGMA, false));
        def.getParameters().add(new MetaParameter("cp", Double.class, DEFAULT_CP, false));
        def.getParameters().add(new MetaParameter("cn", Double.class, DEFAULT_CN, false));
        return def;
    }
}
