package io.pivotal.bds.gemfire.script.data;

import com.gemstone.gemfire.pdx.PdxReader;
import com.gemstone.gemfire.pdx.PdxSerializable;
import com.gemstone.gemfire.pdx.PdxWriter;

public class ExecutionData implements PdxSerializable {

    private String scriptName;
    private Object arguments;

    public ExecutionData() {
    }

    public ExecutionData(String scriptName, Object arguments) {
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
    public void fromData(PdxReader reader) {
        scriptName = reader.readString("scriptName");
        arguments = reader.readObject("arguments");
    }

    @Override
    public void toData(PdxWriter writer) {
        writer.writeString("scriptName", scriptName);
        writer.writeObject("arguments", arguments);
    }

    @Override
    public String toString() {
        return "ExecutionData [scriptName=" + scriptName + ", arguments=" + arguments + "]";
    }
}
