package io.pivotal.bds.metrics.timer;

import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

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
    private static final ThreadLocal<Long> th = new ThreadLocal<>();
    private BlockingQueue<Long> queue;
    private Logger log;
    private long reporterCycleTime;
    private MetricWriter writer;

    private long count = 0L;
    private long total = 0L;
    private long average = 0L;
    private long minimum = -1L;
    private long maximum = -1L;

    private long[] rolling;
    private int index = 0;

    public Timer(String name) {
        this(name, DEFAULT_QUEUE_SIZE, DEFAULT_ROLLING_SIZE, DEFAULT_CYCLE_TIME, new LogMetricWriter(name));
    }

    public Timer(String name, int queueSize, int rollingSize, long reporterCycleTime, MetricWriter writer) {
        this.name = name;
        this.reporterCycleTime = reporterCycleTime;
        this.queue = new LinkedBlockingDeque<>(queueSize);
        this.rolling = new long[rollingSize];
        Arrays.fill(rolling, -1L);
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
        th.set(System.currentTimeMillis());
    }

    public void end() {
        Long e = th.get();
        th.remove();

        if (e == null) {
            this.log.warn("start not called in this thread");
        } else {
            long t = System.currentTimeMillis();
            long d = t - e;

            queue.offer(d);
        }
    }

    public synchronized void reset() {
        count = 0L;
        total = 0L;
        average = 0L;
        Arrays.fill(rolling, -1L);
        index = 0;
    }

    private synchronized void calc(long t) {
        ++count;
        total += t;
        average = total / count;

        if (t > maximum) {
            maximum = t;
        }

        if (minimum < 0L || t < minimum) {
            minimum = t;
        }

        if (index >= rolling.length) {
            index = 0;
        }

        rolling[index++] = t;
    }

    private synchronized void report() {
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

        long avg = cnt > 0L ? tot / cnt : 0L;

        if (cnt > 0L && count > 0L) {
            Metric metric = new Metric(System.currentTimeMillis());
            metric.getTags().put("name", name);

            metric.getValues().add(new MetricValue("timer.overall.count", MetricType.latency, MetricUnit.count, count));
            metric.getValues().add(new MetricValue("timer.overall.average", MetricType.latency, MetricUnit.milliseconds, average));
            metric.getValues().add(new MetricValue("timer.overall.minimum", MetricType.latency, MetricUnit.milliseconds, minimum));
            metric.getValues().add(new MetricValue("timer.overall.maximum", MetricType.latency, MetricUnit.milliseconds, maximum));
            metric.getValues().add(new MetricValue("timer.rolling.count", MetricType.latency, MetricUnit.count, cnt));
            metric.getValues().add(new MetricValue("timer.rolling.average", MetricType.latency, MetricUnit.milliseconds, avg));
            metric.getValues().add(new MetricValue("timer.rolling.minimum", MetricType.latency, MetricUnit.milliseconds, min));
            metric.getValues().add(new MetricValue("timer.rolling.maximum", MetricType.latency, MetricUnit.milliseconds, max));

            writer.write(metric);
        }
    }

    private class Processor extends Thread {

        public Processor() {
            super("Timer-Processor-" + name);
        }

        @Override
        public void run() {
            try {
                while (true) {
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
                while (true) {
                    Thread.sleep(reporterCycleTime);
                    report();
                }
            } catch (Exception x) {
                log.error(x.toString(), x);
            }
        }
    }
}
