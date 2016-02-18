package io.pivotal.bds.gemfire.ml.classification;

import java.util.Map;

import org.springframework.util.StringUtils;

import io.pivotal.bds.gemfire.ml.Model;
import io.pivotal.bds.gemfire.ml.MetaModel;
import io.pivotal.bds.gemfire.ml.ModelName;
import io.pivotal.bds.gemfire.ml.MetaParameter;
import io.pivotal.bds.gemfire.ml.ModelType;
import smile.classification.NaiveBayes;

public class NaiveBayesModelFactory extends AbstractClassificationModelFactory {

    private static final NaiveBayes.Model DEFAULT_NAIVE_BAYES_MODEL = NaiveBayes.Model.GENERAL;
    private static final int DEFAULT_K = 1;
    private static final int DEFAULT_P = 1;
    private static final double DEFAULT_SIGMA = 1.0;

    public NaiveBayesModelFactory() {
        super(createModelDef());
    }

    @Override
    protected Model<double[][], int[], double[], Integer> doCreate(String id, Map<String, Object> properties) {
        String snbm = (String) properties.getOrDefault("model", DEFAULT_NAIVE_BAYES_MODEL.name());
        Integer k = (Integer) properties.getOrDefault("k", DEFAULT_K);
        Integer p = (Integer) properties.getOrDefault("p", DEFAULT_P);
        Double sigma = (Double) properties.getOrDefault("sigma", DEFAULT_SIGMA);

        NaiveBayes.Model nbm = StringUtils.hasText(snbm) ? NaiveBayes.Model.valueOf(snbm) : DEFAULT_NAIVE_BAYES_MODEL;

        return new NaiveBayesModel(id, def, nbm, k, p, sigma);
    }

    private static MetaModel createModelDef() {
        MetaModel def = new MetaModel(ModelType.classification, ModelName.NaiveBayes);
        def.getParameters().add(new MetaParameter("model", NaiveBayes.Model.class, NaiveBayes.Model.GENERAL, false));
        def.getParameters().add(new MetaParameter("k", Integer.class, DEFAULT_K, false));
        def.getParameters().add(new MetaParameter("p", Integer.class, DEFAULT_P, false));
        def.getParameters().add(new MetaParameter("sigma", Double.class, DEFAULT_SIGMA, false));
        return def;
    }
}
