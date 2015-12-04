package io.pivotal.bds.metrics.rater;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.pivotal.bds.metrics.data.Metric;
import io.pivotal.bds.metrics.data.MetricType;
import io.pivotal.bds.metrics.data.MetricUnit;
import io.pivotal.bds.metrics.data.MetricValue;
import io.pivotal.bds.metrics.writer.LogMetricWriter;
import io.pivotal.bds.metrics.writer.MetricWriter;

public class Rater {

    public static final long DEFAULT_CYCLE_TIME = 10000L;
    public static final int DEFAULT_ROLLING_SIZE = 100;

    private String name;
    private Logger log;
    private long reporterCycleTime;
    private MetricWriter writer;
    private boolean running = true;

    private long start = 0L;
    private long count = 0L;
    private long minimum = -1L;
    private long maximum = -1L;

    private long windowCount = 0L;
    private long windowStart = 0L;
    private long windowMinimum = -1L;
    private long windowMaximum = -1L;

    private long[] rolling;
    private int index = 0;

    public Rater(String name) {
        this(name, DEFAULT_CYCLE_TIME, DEFAULT_ROLLING_SIZE, new LogMetricWriter(name));
    }

    public Rater(String name, long reporterCycleTime, int rollingSize, MetricWriter writer) {
        this.name = name;
        this.reporterCycleTime = reporterCycleTime;
        this.rolling = new long[rollingSize];
        Arrays.fill(rolling, -1L);
        this.log = LoggerFactory.getLogger("Rater-" + name);
        this.writer = writer;

        Reporter rp = new Reporter();
        rp.setPriority(Thread.NORM_PRIORITY - 2);
        rp.setDaemon(true);
        rp.start();
    }

    public synchronized void increment() {
        if (start == 0L) {
            start = windowStart = System.currentTimeMillis();
        }

        ++windowCount;
        ++count;
    }

    public synchronized void reset() {
        count = 0L;
        start = 0L;
        windowCount = 0L;
        windowStart = 0L;
        minimum = -1L;
        maximum = -1L;
        windowMinimum = -1L;
        windowMaximum = -1L;
    }

    @Override
    protected void finalize() throws Throwable {
        running = false;
    }

    private synchronized void report() {
        long now = System.currentTimeMillis();

        long delta = now - start;
        long rate = 0L;

        if (delta > 0L) {
            rate = 1000L * count / delta;

            if (rate > maximum) {
                maximum = rate;
            }

            if (minimum < 0L || rate < minimum) {
                minimum = rate;
            }
        }

        long windowDelta = now - windowStart;
        long windowRate = 0L;

        if (windowDelta > 0L) {
            windowRate = 1000L * windowCount / windowDelta;

            if (windowRate > windowMaximum) {
                windowMaximum = windowRate;
            }

            if (windowMinimum < 0L || windowRate < windowMinimum) {
                windowMinimum = windowRate;
            }
        }

        if (index >= rolling.length) {
            index = 0;
        }

        rolling[index++] = rate;

        long min = -1L;
        long max = -1L;
        int cnt = 0;
        long tot = 0L;

        for (int i = 0; i < rolling.length; ++i) {
            long t = rolling[i];

            if (t >= 0L) {
                ++cnt;

                if (t > max) {
                    max = t;
                }

                if (min == -1L || t < min) {
                    min = t;
                }

                tot += t;
            }
        }

        long avg = tot / cnt;

        if (cnt > 0L && count > 0L) {
            Metric metric = new Metric(now);
            metric.getTags().put("name", name);

            metric.getValues().add(new MetricValue("rater.overall.count", MetricType.rate, MetricUnit.count, count));
            metric.getValues().add(new MetricValue("rater.overall.rate", MetricType.rate, MetricUnit.per_second, rate));
            metric.getValues().add(new MetricValue("rater.overall.minimum", MetricType.rate, MetricUnit.per_second, minimum));
            metric.getValues().add(new MetricValue("rater.overall.maximum", MetricType.rate, MetricUnit.per_second, maximum));
            metric.getValues().add(new MetricValue("rater.window.count", MetricType.rate, MetricUnit.count, windowCount));
            metric.getValues().add(new MetricValue("rater.window.rate", MetricType.rate, MetricUnit.per_second, windowRate));
            metric.getValues().add(new MetricValue("rater.window.minimum", MetricType.rate, MetricUnit.per_second, windowMinimum));
            metric.getValues().add(new MetricValue("rater.window.maximum", MetricType.rate, MetricUnit.per_second, windowMaximum));
            metric.getValues().add(new MetricValue("rater.rolling.count", MetricType.rate, MetricUnit.count, cnt));
            metric.getValues().add(new MetricValue("rater.rolling.rate", MetricType.rate, MetricUnit.per_second, avg));
            metric.getValues().add(new MetricValue("rater.rolling.minimum", MetricType.rate, MetricUnit.per_second, min));
            metric.getValues().add(new MetricValue("rater.rolling.maximum", MetricType.rate, MetricUnit.per_second, max));

            writer.write(metric);
        }

        windowCount = 0L;
        windowStart = now;
    }

    private class Reporter extends Thread {

        public Reporter() {
            super("Rater-Reporter-" + name);
        }

        @Override
        public void run() {
            try {
                while (running) {
                    Thread.sleep(reporterCycleTime);
                    report();
                }
            } catch (Exception x) {
                log.error("name={}, x={}", name, x.toString(), x);
            }
        }
    }
}
