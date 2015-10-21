package io.pivotal.bds.gemfire.groovy.data;

public class ScriptExecutionResult {

    private Object result;

    public ScriptExecutionResult() {
    }

    public ScriptExecutionResult(Object result) {
        this.result = result;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ScriptExecutionResult [result=" + result + "]";
    }

}
