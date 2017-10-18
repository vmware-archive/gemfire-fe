package io.pivotal.bds.gemfire.r.common;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.geode.DataSerializable;

@SuppressWarnings("serial")
public class AdhocPredictionResponse implements DataSerializable {

    private List<AdhocPrediction> results;

    public AdhocPredictionResponse() {
    }

    public AdhocPredictionResponse(List<AdhocPrediction> results) {
        this.results = results;
    }

    public List<AdhocPrediction> getResults() {
        return results;
    }

    public void setResults(List<AdhocPrediction> results) {
        this.results = results;
    }

    @Override
    public void fromData(DataInput input) throws IOException, ClassNotFoundException {
        results = new ArrayList<>();
        int c = input.readInt();
        for (int i = 0; i < c; ++i) {
            AdhocPrediction p = new AdhocPrediction();
            p.fromData(input);
            results.add(p);
        }
    }

    @Override
    public void toData(DataOutput output) throws IOException {
        int c = results.size();
        output.writeInt(c);
        for (int i = 0; i < c; ++i) {
            results.get(i).toData(output);
        }
    }

    @Override
    public String toString() {
        return "AdhocPredictionResponse [results=" + results + "]";
    }

}
