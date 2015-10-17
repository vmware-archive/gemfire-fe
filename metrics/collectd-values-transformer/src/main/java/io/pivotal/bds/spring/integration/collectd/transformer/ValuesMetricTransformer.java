package io.pivotal.bds.spring.integration.collectd.transformer;

import java.util.List;
import java.util.Map;

import org.jcollectd.agent.api.DataSource;
import org.jcollectd.agent.api.Values;

import io.pivotal.bds.metrics.data.Metric;
import io.pivotal.bds.metrics.data.MetricType;
import io.pivotal.bds.metrics.data.MetricUnit;
import io.pivotal.bds.metrics.data.MetricValue;

public class ValuesMetricTransformer {

    public Metric transform(Values values) {
        long ts = values.getTime();
        Metric m = new Metric(ts);

        List<Number> data = values.getData();
        List<DataSource> srcs = values.getDataSource();

        Map<String, String> tags = m.getTags();

        tags.put("host", values.getHost());
        tags.put("plugin", values.getPlugin());
        tags.put("pluginInstance", values.getPluginInstance());
        tags.put("source", values.getSource());
        tags.put("type", values.getType());
        tags.put("typeInstance", values.getTypeInstance());

        List<MetricValue> vals = m.getValues();

        for (int i = 0; i < data.size(); ++i) {
            String n = srcs.get(i).getName();
            double val = data.get(i).doubleValue();
            vals.add(new MetricValue(n, MetricType.unknown, MetricUnit.unknown, val));
        }

        return m;
    }
}
