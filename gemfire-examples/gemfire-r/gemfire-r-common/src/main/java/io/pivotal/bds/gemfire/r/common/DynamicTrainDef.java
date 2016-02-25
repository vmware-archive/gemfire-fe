package io.pivotal.bds.gemfire.r.common;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;

import com.gemstone.gemfire.DataSerializable;
import com.gemstone.gemfire.DataSerializer;

@SuppressWarnings("serial")
public class DynamicTrainDef implements DataSerializable {

    private ModelDefKey modelDefKey;
    private ModelKey modelKey;
    private String regionName;
    private int size;
    private String[] xFieldNames;
    private String yFieldName;

    public DynamicTrainDef() {
    }

    public DynamicTrainDef(ModelDefKey modelDefKey, ModelKey modelKey, String regionName, int size, String[] xFieldNames,
            String yFieldName) {
        this.modelDefKey = modelDefKey;
        this.modelKey = modelKey;
        this.regionName = regionName;
        this.size = size;
        this.xFieldNames = xFieldNames;
        this.yFieldName = yFieldName;
    }

    public ModelDefKey getModelDefKey() {
        return modelDefKey;
    }

    public void setModelDefKey(ModelDefKey modelDefKey) {
        this.modelDefKey = modelDefKey;
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String[] getxFieldNames() {
        return xFieldNames;
    }

    public void setxFieldNames(String[] xFieldNames) {
        this.xFieldNames = xFieldNames;
    }

    public String getyFieldName() {
        return yFieldName;
    }

    public void setyFieldName(String yFieldName) {
        this.yFieldName = yFieldName;
    }

    @Override
    public void fromData(DataInput in) throws IOException, ClassNotFoundException {
        modelDefKey = new ModelDefKey();
        modelDefKey.fromData(in);
        modelKey = new ModelKey();
        modelKey.fromData(in);
        regionName = DataSerializer.readString(in);
        size = in.readInt();
        xFieldNames = DataSerializer.readStringArray(in);
        yFieldName = DataSerializer.readString(in);
    }

    @Override
    public void toData(DataOutput out) throws IOException {
        modelDefKey.toData(out);
        modelKey.toData(out);
        DataSerializer.writeString(regionName, out);
        out.writeInt(size);
        DataSerializer.writeStringArray(xFieldNames, out);
        DataSerializer.writeString(yFieldName, out);
    }

    @Override
    public String toString() {
        return "DynamicTrainDef [modelDefKey=" + modelDefKey + ", modelKey=" + modelKey + ", regionName=" + regionName + ", size="
                + size + ", xFieldNames=" + Arrays.toString(xFieldNames) + ", yFieldName=" + yFieldName + "]";
    }

}
