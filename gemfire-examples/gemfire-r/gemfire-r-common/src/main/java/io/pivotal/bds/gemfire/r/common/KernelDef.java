package io.pivotal.bds.gemfire.r.common;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.gemstone.gemfire.DataSerializable;
import com.gemstone.gemfire.DataSerializer;

import io.pivotal.bds.gemfire.ml.KernelType;

@SuppressWarnings("serial")
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
    public void fromData(DataInput in) throws IOException, ClassNotFoundException {
        type = DataSerializer.readEnum(KernelType.class, in);
        properties = DataSerializer.readHashMap(in);
    }

    @Override
    public void toData(DataOutput out) throws IOException {
        DataSerializer.writeEnum(type, out);
        DataSerializer.writeHashMap((HashMap<?, ?>) properties, out);
    }

    @Override
    public String toString() {
        return "KernelDef [type=" + type + ", properties=" + properties + "]";
    }

}
