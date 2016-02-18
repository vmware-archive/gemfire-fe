package io.pivotal.bds.gemfire.ml.classification;

import io.pivotal.bds.gemfire.ml.MetaModel;
import smile.classification.DecisionTree;
import smile.classification.DecisionTree.SplitRule;

public class DecisionTreeModel extends AbstractClassificationModel {

    private DecisionTree dt;
    private int j;
    private DecisionTree.SplitRule splitRule;

    public DecisionTreeModel(String id, MetaModel def, int j, SplitRule splitRule) {
        super(id, def);
        this.j = j;
        this.splitRule = splitRule;
    }

    @Override
    public void train(double[][] x, int[] y) {
        dt = new DecisionTree(x, y, j, splitRule);
        getAttributes().put("importance", dt.importance());
    }

    @Override
    public Integer predict(double[] x) {
        return dt.predict(x);
    }

}
