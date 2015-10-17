package io.pivotal.bds.metrics.jmx.test;

import io.pivotal.bds.metrics.jmx.JMXMetrics;

public class JMXMetricsTest {

    public static void main(String[] args) throws Exception {
        JMXMetrics m = new JMXMetrics();
        m.setDelay(1000L);
        m.addFromJSON("jvm.json");
        m.start();

        synchronized (JMXMetricsTest.class) {
            JMXMetricsTest.class.wait();
        }
    }
}
