package io.pivotal.bds.gemfire.ml.classification;

import io.pivotal.bds.gemfire.ml.AbstractModelFactory;
import io.pivotal.bds.gemfire.ml.MetaModel;

public abstract class AbstractClassificationModelFactory extends AbstractModelFactory<double[][], int[], double[], Integer>
        implements ClassificationModelFactory {

    public AbstractClassificationModelFactory(MetaModel def) {
        super(def);
    }

}
