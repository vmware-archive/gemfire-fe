package io.pivotal.bds.gemfire.ml.classification;

import java.util.Map;

import org.springframework.util.StringUtils;

import io.pivotal.bds.gemfire.ml.Model;
import io.pivotal.bds.gemfire.ml.MetaModel;
import io.pivotal.bds.gemfire.ml.ModelName;
import io.pivotal.bds.gemfire.ml.MetaParameter;
import io.pivotal.bds.gemfire.ml.ModelType;
import smile.classification.DecisionTree;

public class DecisionTreeModelFactory extends AbstractClassificationModelFactory {

    private static final int DEFAULT_J = 10;
    private static final DecisionTree.SplitRule DEFAULT_SPLIT_RULE = DecisionTree.SplitRule.GINI;

    public DecisionTreeModelFactory() {
        super(createModelDef());
    }

    @Override
    protected Model<double[][], int[], double[], Integer> doCreate(String id, Map<String, Object> properties) {
        Integer j = (Integer) properties.getOrDefault("j", DEFAULT_J);
        String osr = (String) properties.get("splitRule");
        DecisionTree.SplitRule sr = StringUtils.hasText(osr) ? DecisionTree.SplitRule.valueOf(osr.toString()) : DEFAULT_SPLIT_RULE;
        return new DecisionTreeModel(id, def, j, sr);
    }

    private static MetaModel createModelDef() {
        MetaModel def = new MetaModel(ModelType.classification, ModelName.DecisionTree);
        def.getParameters().add(new MetaParameter("J", Integer.class, DEFAULT_J, false));
        def.getParameters().add(new MetaParameter("splitRule", DecisionTree.SplitRule.class, DEFAULT_SPLIT_RULE, false));
        return def;
    }
}
