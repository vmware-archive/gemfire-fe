package io.pivotal.bds.metrics.writer;

import java.util.List;
import java.util.Map;

import io.pivotal.bds.metrics.data.Metric;
import io.pivotal.bds.metrics.data.MetricValue;

public class LogMetricWriter extends MetricWriter {

    public LogMetricWriter(String name) {
        super(name);
    }

    @Override
    protected void doWrite(Metric metric) {
        StringBuilder buf = new StringBuilder();

        buf.append("ts=").append(metric.getTs());

        for (Map.Entry<String, String> e : metric.getTags().entrySet()) {
            buf.append(',').append(e.getKey()).append('=').append(e.getValue());
        }

        List<MetricValue> vals = metric.getValues();

        for (int i = 0; i < vals.size(); ++i) {
            MetricValue val = vals.get(i);
            buf.append(',').append(val.getName()).append('=').append(val.getValue());
        }

        log.info(buf.toString());
    }
}
