package io.pivotal.bds.gemfire.pmml.common.data;

import java.util.Map;

public class EvaluatorParams {

    private String name;
    private Map<String, Object> parameters;

    public EvaluatorParams() {
    }

    public EvaluatorParams(String name, Map<String, Object> parameters) {
        this.name = name;
        this.parameters = parameters;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "EvaluatorParams [name=" + name + ", parameters=" + parameters + "]";
    }

}
