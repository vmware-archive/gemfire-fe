package io.pivotal.bds.gemfire.ml.classification;

import io.pivotal.bds.gemfire.ml.AbstractModel;
import io.pivotal.bds.gemfire.ml.MetaModel;

public abstract class AbstractClassificationModel extends AbstractModel<double[][], int[], double[], Integer>
        implements ClassificationModel {

    public AbstractClassificationModel(String id, MetaModel def) {
        super(id, def);
    }

}
