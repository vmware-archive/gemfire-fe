package io.pivotal.bds.gemfire.r.common;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.gemstone.gemfire.DataSerializable;
import com.gemstone.gemfire.DataSerializer;

@SuppressWarnings("serial")
public class PMMLPrediction implements DataSerializable {

    private Map<String, Object> values;

    public PMMLPrediction() {
    }

    public PMMLPrediction(Map<String, Object> values) {
        this.values = values;
    }

    public Map<String, Object> getValues() {
        return values;
    }

    public void setValues(Map<String, Object> values) {
        this.values = values;
    }

    @Override
    public void fromData(DataInput in) throws IOException, ClassNotFoundException {
        values = DataSerializer.readHashMap(in);
    }

    @Override
    public void toData(DataOutput out) throws IOException {
        DataSerializer.writeHashMap((HashMap<?, ?>) values, out);
    }

    @Override
    public String toString() {
        return "PMMLPrediction [values=" + values + "]";
    }

}
