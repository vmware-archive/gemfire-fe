package io.pivotal.bds.gemfire.pmml.common.data;

import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import io.pivotal.bds.gemfire.pmml.common.keys.EvalKey;

public class EvaluatorParams {

    private EvalKey key;
    private String modelName;
    private Map<String, Object> parameters;

    public EvaluatorParams() {
    }

    public EvaluatorParams(EvalKey key, String modelName, Map<String, Object> parameters) {
        this.key = key;
        this.modelName = modelName;
        this.parameters = parameters;
    }

    public EvalKey getKey() {
        return key;
    }

    public void setKey(EvalKey key) {
        this.key = key;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
