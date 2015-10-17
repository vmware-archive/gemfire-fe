package io.pivotal.bds.gemfire.ml.decisiontree;

import java.util.Properties;

import org.springframework.util.StringUtils;

import io.pivotal.bds.gemfire.ml.Model;
import io.pivotal.bds.gemfire.ml.ModelFactory;
import io.pivotal.bds.gemfire.ml.util.PropertiesSupport;
import smile.classification.DecisionTree;

public class DecisionTreeModelFactory implements ModelFactory {

    private static final int DEFAULT_J = 10;
    private static final DecisionTree.SplitRule DEFAULT_SPLIT_RULE = DecisionTree.SplitRule.GINI;

    private static final String[] PROPERTY_NAMES = { "j", "splitRule" };

    @Override
    public String[] getPropertyNames() {
        return PROPERTY_NAMES;
    }

    @Override
    public Model create(String name, String attributeName, Properties properties) {
        Integer j = PropertiesSupport.getIntegerProperty(properties, "decisiontree.j", DEFAULT_J);
        String osr = properties.getProperty("decisiontree.splitRule");
        DecisionTree.SplitRule sr = StringUtils.hasText(osr) ? DecisionTree.SplitRule.valueOf(osr.toString()) : DEFAULT_SPLIT_RULE;
        return new DecisionTreeModel(name, attributeName, j, sr);
    }

}
