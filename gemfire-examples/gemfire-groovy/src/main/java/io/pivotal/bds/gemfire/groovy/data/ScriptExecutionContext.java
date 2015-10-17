package io.pivotal.bds.gemfire.groovy.data;

public class ScriptExecutionContext {

    private String scriptName;
    private Object arguments;

    public ScriptExecutionContext() {
    }

    public ScriptExecutionContext(String scriptName, Object arguments) {
        this.scriptName = scriptName;
        this.arguments = arguments;
    }

    public String getScriptName() {
        return scriptName;
    }

    public void setScriptName(String scriptName) {
        this.scriptName = scriptName;
    }

    public Object getArguments() {
        return arguments;
    }

    public void setArguments(Object arguments) {
        this.arguments = arguments;
    }

    @Override
    public String toString() {
        return "ScriptExecutionContext [scriptName=" + scriptName + ", arguments=" + arguments + "]";
    }

}
