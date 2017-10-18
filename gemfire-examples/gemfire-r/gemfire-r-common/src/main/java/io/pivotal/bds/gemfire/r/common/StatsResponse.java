package io.pivotal.bds.gemfire.r.common;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import org.apache.geode.DataSerializable;
import org.apache.geode.DataSerializer;

@SuppressWarnings("serial")
public class StatsResponse implements DataSerializable {

    private DescriptiveStatistics stats;

    public StatsResponse() {
    }

    public StatsResponse(DescriptiveStatistics stats) {
        this.stats = stats;
    }

    public DescriptiveStatistics getStats() {
        return stats;
    }

    public void setStats(DescriptiveStatistics stats) {
        this.stats = stats;
    }

    @Override
    public void fromData(DataInput in) throws IOException, ClassNotFoundException {
        stats = DataSerializer.readObject(in);
    }

    @Override
    public void toData(DataOutput out) throws IOException {
        DataSerializer.writeObject(stats, out);
    }

    @Override
    public String toString() {
        return "StatsResponse [stats=" + stats + "]";
    }

}
