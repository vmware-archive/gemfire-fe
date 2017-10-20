package io.pivotal.bds.gemfire.pmml.common.data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import io.pivotal.bds.gemfire.pmml.common.keys.ModelKey;

public class Model {

    private ModelKey key;
    private String model;

    public Model() {
    }

    public Model(ModelKey key, String model) {
        this.key = key;
        this.model = model;
    }

    public ModelKey getKey() {
        return key;
    }

    public void setKey(ModelKey key) {
        this.key = key;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
