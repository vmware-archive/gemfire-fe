package io.pivotal.bds.metrics.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Metric {

    private long ts;
    private final Map<String, String> tags = new HashMap<String, String>();
    private final List<MetricValue> values = new ArrayList<>();

    public Metric(long ts) {
        this.ts = ts;
    }

    public long getTs() {
        return ts;
    }

    public List<MetricValue> getValues() {
        return values;
    }

    public Map<String, String> getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return "Metric [ts=" + ts + ", tags=" + tags + ", values=" + values + "]";
    }

}
