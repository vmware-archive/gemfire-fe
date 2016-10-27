package io.pivotal.bds.metrics.timer;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import org.apache.commons.math3.stat.descriptive.SummaryStatistics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.pivotal.bds.metrics.data.Metric;
import io.pivotal.bds.metrics.data.MetricType;
import io.pivotal.bds.metrics.data.MetricUnit;
import io.pivotal.bds.metrics.data.MetricValue;
import io.pivotal.bds.metrics.writer.LogMetricWriter;
import io.pivotal.bds.metrics.writer.MetricWriter;

public class Timer {

    public static final int DEFAULT_QUEUE_SIZE = 1000000;
    public static final long DEFAULT_CYCLE_TIME = 10000L;
    public static final int DEFAULT_ROLLING_SIZE = 100;

    private String name;
    private boolean writeEachTiming;
    private final ThreadLocal<Long> th = new ThreadLocal<>();
    private BlockingQueue<Long> queue;
    private Logger log;
    private long reporterCycleTime;
    private MetricWriter writer;
    private SummaryStatistics stats = new SummaryStatistics();
    private boolean running = true;

    private Long[] rolling;
    private int index = 0;

    public Timer(String name) {
        this(name, DEFAULT_QUEUE_SIZE, DEFAULT_ROLLING_SIZE, DEFAULT_CYCLE_TIME, false, new LogMetricWriter(name));
    }

    public Timer(String name, boolean writeEachTiming) {
        this(name, DEFAULT_QUEUE_SIZE, DEFAULT_ROLLING_SIZE, DEFAULT_CYCLE_TIME, writeEachTiming, new LogMetricWriter(name));
    }

    public Timer(String name, int queueSize, int rollingSize, long reporterCycleTime, boolean writeEachTiming,
            MetricWriter writer) {
        this.name = name;
        this.writeEachTiming = writeEachTiming;
        this.reporterCycleTime = reporterCycleTime;
        this.queue = new LinkedBlockingDeque<>(queueSize);
        this.rolling = new Long[rollingSize];
        this.log = LoggerFactory.getLogger("Timer-" + name);
        this.writer = writer;

        Processor pr = new Processor();
        pr.setPriority(Thread.NORM_PRIORITY - 1);
        pr.setDaemon(true);
        pr.start();

        Reporter rp = new Reporter();
        rp.setPriority(Thread.NORM_PRIORITY - 2);
        rp.setDaemon(true);
        rp.start();

    }

    public void start() {
        th.set(System.nanoTime());
    }

    public void end() {
        Long s = th.get();
        th.remove();

        if (s == null) {
            this.log.warn("start not called in this thread");
        } else {
            long e = System.nanoTime();
            long d = e - s;

            queue.offer(d);
        }
    }

    public synchronized void reset() {
        stats = new SummaryStatistics();
        Arrays.fill(rolling, null);
        index = 0;
    }

    @Override
    protected void finalize() throws Throwable {
        running = false;
    }

    private synchronized void calc(long t) {
        if (writeEachTiming) {
            log.info("timing={}", t);
        }

        stats.addValue(t);

        if (index >= rolling.length) {
            index = 0;
        }

        rolling[index++] = t;
    }

    private synchronized void report() {
        SummaryStatistics rstats = new SummaryStatistics();

        for (int i = 0; i < rolling.length; ++i) {
            Long t = rolling[i];

            if (t != null) {
                rstats.addValue(t);
            }
        }

        if (stats.getN() > 0L && rstats.getN() > 0L) {
            Metric metric = new Metric(System.currentTimeMillis());
            metric.getTags().put("name", name);

            addMetrics(metric, stats, "timer.overall.");
            addMetrics(metric, rstats, "timer.rolling.");

            writer.write(metric);
        }
    }

    private static void addMetrics(Metric metric, SummaryStatistics stats, String prefix) {
        List<MetricValue> values = metric.getValues();

        values.add(new MetricValue(prefix + "count", MetricType.latency, MetricUnit.count, stats.getN()));
        values.add(new MetricValue(prefix + "mean", MetricType.latency, MetricUnit.nanoseconds, stats.getMean()));
        values.add(new MetricValue(prefix + "std", MetricType.latency, MetricUnit.nanoseconds, stats.getStandardDeviation()));
        values.add(new MetricValue(prefix + "variance", MetricType.latency, MetricUnit.nanoseconds, stats.getVariance()));
        values.add(new MetricValue(prefix + "minimum", MetricType.latency, MetricUnit.nanoseconds, stats.getMin()));
        values.add(new MetricValue(prefix + "maximum", MetricType.latency, MetricUnit.nanoseconds, stats.getMax()));
    }

    private class Processor extends Thread {

        public Processor() {
            super("Timer-Processor-" + name);
        }

        @Override
        public void run() {
            try {
                while (running) {
                    long t = queue.take();
                    calc(t);
                }
            } catch (Exception x) {
                log.error(x.toString(), x);
            }
        }
    }

    private class Reporter extends Thread {

        public Reporter() {
            super("Timer-Reporter-" + name);
        }

        @Override
        public void run() {
            try {
                while (running) {
                    Thread.sleep(reporterCycleTime);
                    report();
                }
            } catch (Exception x) {
                log.error(x.toString(), x);
            }
        }
    }
}
