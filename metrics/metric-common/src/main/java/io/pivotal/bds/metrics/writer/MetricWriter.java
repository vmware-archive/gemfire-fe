package io.pivotal.bds.metrics.writer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.pivotal.bds.metrics.data.Metric;

public abstract class MetricWriter {

    protected final Logger log;

    public MetricWriter(String name) {
        log = LoggerFactory.getLogger(name);
    }

    public void write(Metric metric) {
        try {
            doWriter(metric);
        } catch (Exception x) {
            log.error(x.toString(), x);
        }
    }

    protected abstract void doWriter(Metric metric) throws Exception;
}
