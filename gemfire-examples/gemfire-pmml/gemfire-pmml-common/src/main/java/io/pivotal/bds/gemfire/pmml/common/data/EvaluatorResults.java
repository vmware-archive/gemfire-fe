package io.pivotal.bds.gemfire.pmml.common.data;

import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class EvaluatorResults {

    private EvaluatorParams params;
    private Map<String, Object> resultValues;
    private Map<String, Object> outputValues;

    public EvaluatorResults() {
    }

    public EvaluatorResults(EvaluatorParams params, Map<String, Object> resultValues, Map<String, Object> outputValues) {
        this.params = params;
        this.resultValues = resultValues;
        this.outputValues = outputValues;
    }

    public EvaluatorParams getParams() {
        return params;
    }

    public void setParams(EvaluatorParams params) {
        this.params = params;
    }

    public Map<String, Object> getResultValues() {
        return resultValues;
    }

    public void setResultValues(Map<String, Object> resultValues) {
        this.resultValues = resultValues;
    }

    public Map<String, Object> getOutputValues() {
        return outputValues;
    }

    public void setOutputValues(Map<String, Object> outputValues) {
        this.outputValues = outputValues;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
