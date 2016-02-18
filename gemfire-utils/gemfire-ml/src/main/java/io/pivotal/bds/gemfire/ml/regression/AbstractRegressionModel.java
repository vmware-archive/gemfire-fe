package io.pivotal.bds.gemfire.ml.regression;

import io.pivotal.bds.gemfire.ml.AbstractModel;
import io.pivotal.bds.gemfire.ml.MetaModel;

public abstract class AbstractRegressionModel extends AbstractModel<double[][], double[], double[], Double> implements RegressionModel {

    public AbstractRegressionModel(String id, MetaModel def) {
        super(id, def);
    }

}
