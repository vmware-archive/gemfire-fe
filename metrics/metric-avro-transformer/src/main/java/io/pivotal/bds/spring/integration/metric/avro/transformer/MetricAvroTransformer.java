package io.pivotal.bds.spring.integration.metric.avro.transformer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.pivotal.bds.metrics.avro.AvroMetric;
import io.pivotal.bds.metrics.data.Metric;
import io.pivotal.bds.metrics.data.MetricValue;

public class MetricAvroTransformer {

    public AvroMetric transform(Metric metric) {
        long ts = metric.getTs();

        Map<String, String> tags = metric.getTags();
        Map<CharSequence, CharSequence> avtags = new HashMap<>();

        for (Map.Entry<String, String> e : tags.entrySet()) {
            avtags.put(e.getKey(), e.getValue());
        }

        List<MetricValue> vals = metric.getValues();
        Map<CharSequence, Double> avvals = new HashMap<>();

        for (MetricValue mv : vals) {
            avvals.put(mv.getName(), mv.getValue());
        }

        return new AvroMetric(ts, avtags, avvals);
    }
}
