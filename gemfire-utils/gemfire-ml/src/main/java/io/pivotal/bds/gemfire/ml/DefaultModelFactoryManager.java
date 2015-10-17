package io.pivotal.bds.gemfire.ml;

import java.util.HashMap;
import java.util.Map;

import io.pivotal.bds.gemfire.ml.decisiontree.DecisionTreeModelFactory;
import io.pivotal.bds.gemfire.ml.fld.FLDModelFactory;
import io.pivotal.bds.gemfire.ml.knn.KNNModelFactory;
import io.pivotal.bds.gemfire.ml.lda.LDAModelFactory;
import io.pivotal.bds.gemfire.ml.logisticreg.LogisticRegressionModelFactory;
import io.pivotal.bds.gemfire.ml.naivebayes.NaiveBayesModelFactory;
import io.pivotal.bds.gemfire.ml.randomforest.RandomForestModelFactory;
import io.pivotal.bds.gemfire.ml.rda.RDAModelFactory;
import io.pivotal.bds.gemfire.ml.svm.SVMModelFactory;

public class DefaultModelFactoryManager implements ModelFactoryManager {

    private Map<ModelType, ModelFactory> factories = new HashMap<ModelType, ModelFactory>();

    public DefaultModelFactoryManager() {
        factories.put(ModelType.svm, new SVMModelFactory());
        factories.put(ModelType.decisiontree, new DecisionTreeModelFactory());
        factories.put(ModelType.naivebayes, new NaiveBayesModelFactory());
        factories.put(ModelType.randomforest, new RandomForestModelFactory());
        factories.put(ModelType.knn, new KNNModelFactory());
        factories.put(ModelType.lda, new LDAModelFactory());
        factories.put(ModelType.fld, new FLDModelFactory());
        factories.put(ModelType.logisticreg, new LogisticRegressionModelFactory());
        factories.put(ModelType.rda, new RDAModelFactory());
    }

    @Override
    public ModelFactory getFactory(ModelType type) {
        ModelFactory f = factories.get(type);
        return f;
    }

}
