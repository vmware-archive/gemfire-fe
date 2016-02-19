package io.pivotal.bds.gemfire.r.common;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Map;

import com.gemstone.gemfire.DataSerializable;

public class KernelDef implements DataSerializable {

    private KernelType type;
    private Map<String, Number> properties;

    public KernelDef() {
    }

    public KernelDef(KernelType type, Map<String, Number> properties) {
        this.type = type;
        this.properties = properties;
    }

    public KernelType getType() {
        return type;
    }

    public void setType(KernelType type) {
        this.type = type;
    }

    public Map<String, Number> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Number> properties) {
        this.properties = properties;
    }

    @Override
    public void fromData(DataInput arg0) throws IOException, ClassNotFoundException {
        // TODO Auto-generated method stub

    }

    @Override
    public void toData(DataOutput arg0) throws IOException {
        // TODO Auto-generated method stub

    }

    @Override
    public String toString() {
        return "KernelDef [type=" + type + ", properties=" + properties + "]";
    }

}
