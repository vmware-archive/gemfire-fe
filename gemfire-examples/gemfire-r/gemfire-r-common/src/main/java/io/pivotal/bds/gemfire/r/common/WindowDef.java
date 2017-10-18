package io.pivotal.bds.gemfire.r.common;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.geode.DataSerializable;

@SuppressWarnings("serial")
public class WindowDef implements DataSerializable {

    private String regionName;
    private String[] fieldNames;
    private int size;
    private Object targetKey;

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String[] getFieldNames() {
        return fieldNames;
    }

    public void setFieldNames(String[] fieldNames) {
        this.fieldNames = fieldNames;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Object getTargetKey() {
        return targetKey;
    }

    public void setTargetKey(Object targetKey) {
        this.targetKey = targetKey;
    }

    @Override
    public void fromData(DataInput in) throws IOException, ClassNotFoundException {
    }

    @Override
    public void toData(DataOutput out) throws IOException {
    }

}
