package io.pivotal.bds.gemfire.ml.decisiontree;

import io.pivotal.bds.gemfire.ml.AbstractModel;
import io.pivotal.bds.gemfire.ml.ModelType;
import smile.classification.DecisionTree;
import smile.classification.DecisionTree.SplitRule;

public class DecisionTreeModel extends AbstractModel {

    private DecisionTree dt;
    private int j;
    private DecisionTree.SplitRule splitRule;

    public DecisionTreeModel(String name, String attributeName, int j, SplitRule splitRule) {
        super(name, attributeName, ModelType.decisiontree);
        this.j = j;
        this.splitRule = splitRule;
    }

    @Override
    public void train(double[][] x, int[] y) {
        dt = new DecisionTree(x, y, j, splitRule);
    }

    @Override
    public int predict(double[] x) {
        return dt.predict(x);
    }

}
