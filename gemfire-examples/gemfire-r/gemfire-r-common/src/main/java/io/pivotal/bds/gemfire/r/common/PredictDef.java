package io.pivotal.bds.gemfire.r.common;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;

import com.gemstone.gemfire.DataSerializable;
import com.gemstone.gemfire.DataSerializer;

@SuppressWarnings("serial")
public class PredictDef implements DataSerializable {

    private ModelKey modelKey;
    private String regionName;
    private String[] fieldNames;

    public PredictDef() {
    }

    public PredictDef(ModelKey modelKey, String regionName, String[] fieldNames) {
        this.modelKey = modelKey;
        this.regionName = regionName;
        this.fieldNames = fieldNames;
    }

    public ModelKey getModelKey() {
        return modelKey;
    }

    public void setModelKey(ModelKey modelKey) {
        this.modelKey = modelKey;
    }

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

    @Override
    public void fromData(DataInput input) throws IOException, ClassNotFoundException {
        modelKey = new ModelKey();
        modelKey.fromData(input);
        regionName = DataSerializer.readString(input);
        fieldNames = DataSerializer.readStringArray(input);
    }

    @Override
    public void toData(DataOutput output) throws IOException {
        modelKey.toData(output);
        DataSerializer.writeString(regionName, output);
        DataSerializer.writeStringArray(fieldNames, output);
    }

    @Override
    public String toString() {
        return "PredictDef [modelKey=" + modelKey + ", regionName=" + regionName + ", fieldNames=" + Arrays.toString(fieldNames)
                + "]";
    }
}
