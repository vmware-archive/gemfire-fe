package io.pivotal.bds.gemfire.ml.regression;

import io.pivotal.bds.gemfire.ml.AbstractModelFactory;
import io.pivotal.bds.gemfire.ml.MetaModel;

public abstract class AbstractRegressionModelFactory extends AbstractModelFactory<double[][], double[], double[], Double>implements RegressionModelFactory {

    public AbstractRegressionModelFactory(MetaModel def) {
        super(def);
    }

}
