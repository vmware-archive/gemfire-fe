package io.pivotal.bds.gemfire.geojson.common;

import java.io.Serializable;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class AddFeatureRequest implements Serializable {

    private int id;
    private String data;

    private static final long serialVersionUID = 7736361563376429031L;

    public AddFeatureRequest() {
    }

    public AddFeatureRequest(int id, String data) {
        this.id = id;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}
