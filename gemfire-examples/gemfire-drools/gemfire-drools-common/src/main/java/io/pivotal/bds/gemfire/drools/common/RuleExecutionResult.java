package io.pivotal.bds.gemfire.drools.common;

import java.util.List;
import java.util.Map;

import org.apache.geode.pdx.PdxReader;
import org.apache.geode.pdx.PdxSerializable;
import org.apache.geode.pdx.PdxWriter;

public class RuleExecutionResult implements PdxSerializable {

    private List<Object> errors;
    private Map<String, Object> properties;

    public RuleExecutionResult() {
    }

    public RuleExecutionResult(List<Object> errors, Map<String, Object> properties) {
        this.errors = errors;
        this.properties = properties;
    }

    public List<Object> getErrors() {
        return errors;
    }

    public void setErrors(List<Object> errors) {
        this.errors = errors;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void fromData(PdxReader reader) {
        this.properties = (Map<String, Object>) reader.readObject("properties");
        this.errors = (List<Object>) reader.readObject("errors");
    }

    @Override
    public void toData(PdxWriter writer) {
        writer.writeObject("properties", properties);
        writer.writeObject("errors", errors);
    }

    @Override
    public String toString() {
        return "RuleExecutionResult [errors=" + errors + ", properties=" + properties + "]";
    }

}
