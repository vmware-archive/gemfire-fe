package io.pivotal.bds.gemfire.ml;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.Assert;

import io.pivotal.bds.gemfire.ml.classification.DecisionTreeModelFactory;
import io.pivotal.bds.gemfire.ml.classification.FLDModelFactory;
import io.pivotal.bds.gemfire.ml.classification.KNNModelFactory;
import io.pivotal.bds.gemfire.ml.classification.LDAModelFactory;
import io.pivotal.bds.gemfire.ml.classification.LogisticRegressionModelFactory;
import io.pivotal.bds.gemfire.ml.classification.NaiveBayesModelFactory;
import io.pivotal.bds.gemfire.ml.classification.RDAModelFactory;
import io.pivotal.bds.gemfire.ml.classification.SVMModelFactory;
import io.pivotal.bds.gemfire.ml.regression.GaussianProcessRegressionModelFactory;
import io.pivotal.bds.gemfire.ml.regression.GradientTreeBoostModelFactory;
import io.pivotal.bds.gemfire.ml.regression.LASSOModelFactory;
import io.pivotal.bds.gemfire.ml.regression.OLSModelFactory;
import io.pivotal.bds.gemfire.ml.regression.RBFNetworkModelFactory;
import io.pivotal.bds.gemfire.ml.regression.RegressionTreeModelFactory;
import io.pivotal.bds.gemfire.ml.regression.RidgeRegressionModelFactory;
import io.pivotal.bds.gemfire.ml.regression.SVRModelFactory;

public class ModelFactoryManager {

    @SuppressWarnings("rawtypes")
    private static final Map<String, ModelFactory> factories;

    static {
        factories = new HashMap<>();

        // classification
        add(new DecisionTreeModelFactory());
        add(new FLDModelFactory());
        add(new KNNModelFactory());
        add(new LDAModelFactory());
        add(new LogisticRegressionModelFactory());
        add(new NaiveBayesModelFactory());
        add(new io.pivotal.bds.gemfire.ml.classification.RandomForestModelFactory());
        add(new RDAModelFactory());
        add(new SVMModelFactory());

        // regression
        add(new GaussianProcessRegressionModelFactory());
        add(new GradientTreeBoostModelFactory());
        add(new LASSOModelFactory());
        add(new OLSModelFactory());
        add(new io.pivotal.bds.gemfire.ml.regression.RandomForestModelFactory());
        add(new RBFNetworkModelFactory());
        add(new RegressionTreeModelFactory());
        add(new RidgeRegressionModelFactory());
        add(new SVRModelFactory());
    }

    @SuppressWarnings("rawtypes")
    private static void add(ModelFactory f) {
        MetaModel def = f.getMetadata();
        ModelType type = def.getType();
        ModelName name = def.getName();
        String k = createKey(type, name);
        factories.put(k, f);
    }

    private static String createKey(ModelType type, ModelName name) {
        return type.name() + "." + name.name();
    }

    public static <X, Y, T, P> ModelFactory<X, Y, T, P> getFactory(ModelType type, ModelName name) {
        String k = createKey(type, name);
        @SuppressWarnings("unchecked")
        ModelFactory<X, Y, T, P> f = factories.get(k);
        Assert.notNull(f, "Model: type=" + type.name() + ", name=" + name + " not found");
        return f;
    }
}
