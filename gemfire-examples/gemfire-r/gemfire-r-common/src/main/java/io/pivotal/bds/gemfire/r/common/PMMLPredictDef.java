package io.pivotal.bds.gemfire.r.common;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.geode.DataSerializable;
import org.apache.geode.DataSerializer;

@SuppressWarnings("serial")
public class PMMLPredictDef implements DataSerializable {

    private PMMLKey pmmlKey;
    private String regionName;

    public PMMLPredictDef() {
    }

    public PMMLPredictDef(PMMLKey pmmlKey, String regionName) {
        this.pmmlKey = pmmlKey;
        this.regionName = regionName;
    }

    public PMMLKey getPmmlKey() {
        return pmmlKey;
    }

    public void setPmmlKey(PMMLKey pmmlKey) {
        this.pmmlKey = pmmlKey;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Override
    public void fromData(DataInput in) throws IOException, ClassNotFoundException {
        pmmlKey = new PMMLKey();
        pmmlKey.fromData(in);
        regionName = DataSerializer.readString(in);
    }

    @Override
    public void toData(DataOutput out) throws IOException {
        pmmlKey.toData(out);
        DataSerializer.writeString(regionName, out);
    }

    @Override
    public String toString() {
        return "PMMLPredictDef [pmmlKey=" + pmmlKey + ", regionName=" + regionName + "]";
    }

}
