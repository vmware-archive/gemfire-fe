package io.pivotal.bds.metrics.cassandra;

import io.pivotal.bds.metrics.data.Metric;
import io.pivotal.bds.metrics.writer.MetricWriter;

public class CassandraMetricWriter extends MetricWriter {

    public CassandraMetricWriter(String name) {
        super(name);
    }

    @Override
    protected void doWrite(Metric metric) throws Exception {

    }

}
