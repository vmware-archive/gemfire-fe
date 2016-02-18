package io.pivotal.bds.gemfire.ml.regression;

import java.util.Map;

import io.pivotal.bds.gemfire.ml.Model;
import io.pivotal.bds.gemfire.ml.MetaModel;
import io.pivotal.bds.gemfire.ml.ModelName;
import io.pivotal.bds.gemfire.ml.ModelType;

public class OLSModelFactory extends AbstractRegressionModelFactory {

    public OLSModelFactory() {
        super(new MetaModel(ModelType.regression, ModelName.OLS));
    }

    @Override
    protected Model<double[][], double[], double[], Double> doCreate(String id, Map<String, Object> properties) {
        return new OLSModel(id, def);
    }

}
