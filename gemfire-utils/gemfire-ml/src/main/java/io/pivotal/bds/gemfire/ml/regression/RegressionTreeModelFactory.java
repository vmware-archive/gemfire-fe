package io.pivotal.bds.gemfire.ml.regression;

import java.util.Map;

import io.pivotal.bds.gemfire.ml.Model;
import io.pivotal.bds.gemfire.ml.MetaModel;
import io.pivotal.bds.gemfire.ml.ModelName;
import io.pivotal.bds.gemfire.ml.MetaParameter;
import io.pivotal.bds.gemfire.ml.ModelType;
import io.pivotal.bds.gemfire.ml.util.PropertiesSupport;

public class RegressionTreeModelFactory extends AbstractRegressionModelFactory {

    private static final Integer DEFAULT_J = 1;

    public RegressionTreeModelFactory() {
        super(createModelDef());
    }

    @Override
    protected Model<double[][], double[], double[], Double> doCreate(String id, Map<String, Object> properties) {
        int J = PropertiesSupport.getIntegerProperty(properties, "J", DEFAULT_J);
        return new RegressionTreeModel(id, def, J);
    }

    private static MetaModel createModelDef() {
        MetaModel def = new MetaModel(ModelType.regression, ModelName.RegressionTree);
        def.getParameters().add(new MetaParameter("", Integer.class, DEFAULT_J, false));
        return def;
    }
}
