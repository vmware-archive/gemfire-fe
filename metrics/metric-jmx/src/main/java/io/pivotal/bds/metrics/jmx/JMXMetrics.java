package io.pivotal.bds.metrics.jmx;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.openmbean.CompositeDataSupport;
import javax.management.openmbean.CompositeType;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.pivotal.bds.metrics.data.Metric;
import io.pivotal.bds.metrics.data.MetricType;
import io.pivotal.bds.metrics.data.MetricUnit;
import io.pivotal.bds.metrics.data.MetricValue;
import io.pivotal.bds.metrics.writer.LogMetricWriter;
import io.pivotal.bds.metrics.writer.MetricWriter;

public class JMXMetrics {

    public static final String DEFAULT_CONTEXT = "jmx";
    public static final long DEFAULT_DELAY = 60L * 1000L; // 1 minute

    private static final long MINIMUM_DELAY = 10L * 1000L; // 10 seconds
    private static final long MAXIMUM_DELAY = 60L * 60L * 1000L; // 1 hour

    private String context;
    private String host;
    private MetricWriter writer;
    private long delay;

    private boolean running = false;

    private final MBeanServer server = ManagementFactory.getPlatformMBeanServer();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final Map<ObjectName, MetricDef> metrics = new HashMap<>();
    private final List<ScheduledFuture<?>> handles = new ArrayList<>();

    private static final Logger LOG = LoggerFactory.getLogger(JMXMetrics.class);

    public JMXMetrics() throws Exception {
        this(DEFAULT_CONTEXT, InetAddress.getLocalHost().getHostName());
    }

    public JMXMetrics(String context, String host) {
        this(context, host, new LogMetricWriter(context), DEFAULT_DELAY);
    }

    public JMXMetrics(String context, String host, MetricWriter writer, long delay) {
        if (delay < MINIMUM_DELAY) {
            throw new IllegalArgumentException("Delay too short, must be >= " + MINIMUM_DELAY + " milliseconds");
        }

        if (delay > MAXIMUM_DELAY) {
            throw new IllegalArgumentException("Delay too long, must be <= " + MAXIMUM_DELAY + " milliseconds");
        }

        this.context = context;
        this.writer = writer;
        this.delay = delay;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public MetricWriter getWriter() {
        return writer;
    }

    public void setWriter(MetricWriter writer) {
        this.writer = writer;
    }

    public long getDelay() {
        return delay;
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }

    public void addFromJSON(String file) throws Exception {
        File f = new File(file);

        if (f.exists()) {
            FileReader fr = new FileReader(f);

            try {
                JSONTokener jtk = new JSONTokener(fr);
                add(jtk);
            } finally {
                fr.close();
            }
        } else {
            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(file);

            if (is != null) {
                try {
                    JSONTokener jtk = new JSONTokener(is);
                    add(jtk);
                } finally {
                    is.close();
                }
            } else {
                throw new FileNotFoundException(file);
            }
        }
    }

    private void add(JSONTokener jtk) throws Exception {
        JSONArray ja = new JSONArray(jtk);

        for (int i = 0; i < ja.length(); ++i) {
            JSONObject jo = ja.getJSONObject(i);
            String on = jo.getString("name");
            JSONArray attrs = jo.getJSONArray("attributes");

            for (int j = 0; j < attrs.length(); ++j) {
                String at = attrs.getString(j);
                addAttribute(on, at);
            }
        }
    }

    public void addAttribute(String oname, String attr) throws Exception {
        ObjectName on = new ObjectName(oname);
        add(on, attr);
    }

    public void removeAttribute(String oname, String attr) throws Exception {
        ObjectName on = new ObjectName(oname);
        remove(on, attr);
    }

    public synchronized void removeAllAttributes() {
        metrics.clear();
    }

    public synchronized void start() {
        if (!running) {
            ScheduledFuture<?> f = scheduler.scheduleWithFixedDelay(new Runner(), delay, delay, TimeUnit.MILLISECONDS);
            handles.add(f);
            running = true;
        }
    }

    public synchronized void stop() {
        if (running) {
            try {
                for (ScheduledFuture<?> f : handles) {
                    f.cancel(true);
                }
            } finally {
                handles.clear();
                running = false;
            }
        }
    }

    private synchronized void add(ObjectName on, String attr) throws Exception {
        LOG.debug("add: on={}, attr={}", on, attr);
        Set<ObjectName> names = server.queryNames(on, null);

        if (names.isEmpty()) {
            throw new IllegalArgumentException("No beans found for ObjectName " + on);
        }

        for (ObjectName n : names) {
            LOG.debug("add: on={}, n={}, attr={}", on, n, attr);
            server.getAttribute(n, attr);

            MetricDef def = metrics.get(n);

            if (def == null) {
                def = new MetricDef(n);
                metrics.put(n, def);
            }

            def.attrs.add(attr);
        }
    }

    private synchronized void remove(ObjectName on, String attr) {
        LOG.debug("remove: on={}, attr={}", on, attr);
        Set<ObjectName> names = server.queryNames(on, null);

        if (names.isEmpty()) {
            throw new IllegalArgumentException("No beans found for ObjectName " + on);
        }

        for (ObjectName n : names) {
            LOG.debug("remove: on={}, n={}, attr={}", on, n, attr);
            MetricDef def = metrics.get(n);

            if (def != null) {
                def.attrs.remove(attr);
            }
        }
    }

    private class Runner implements Runnable {

        @Override
        public void run() {
            try {
                long now = System.currentTimeMillis();
                Metric metric = new Metric(now);
                metric.getTags().put("context", context);
                metric.getTags().put("host", host);

                for (MetricDef def : metrics.values()) {
                    ObjectName on = def.name;

                    for (String attr : def.attrs) {
                        Object o = server.getAttribute(on, attr);

                        if (o != null) {
                            if (Number.class.isInstance(o)) {
                                Number n = (Number) o;
                                Double d = n.doubleValue();

                                String mn = on.toString() + "." + attr;

                                metric.getValues().add(new MetricValue(mn, MetricType.latency, MetricUnit.count, d));
                            } else if (CompositeDataSupport.class.isInstance(o)) {
                                CompositeDataSupport cds = (CompositeDataSupport) o;
                                CompositeType ct = cds.getCompositeType();

                                for (String an : ct.keySet()) {
                                    Object ot = cds.get(an);

                                    if (ot != null) {
                                        if (Number.class.isInstance(ot)) {
                                            Number n = (Number) ot;
                                            Double d = n.doubleValue();

                                            String mn = on.toString() + "." + attr + "." + an;

                                            metric.getValues().add(new MetricValue(mn, MetricType.latency, MetricUnit.count, d));
                                        } else {
                                            LOG.debug("Atribute is not a number for object {}, attribute {}, composite {}", on,
                                                    attr, an);
                                        }
                                    } else {
                                        LOG.debug("Atribute is null for object {}, attribute {}, composite {}", on, attr, an);
                                    }
                                }
                            } else {
                                LOG.debug("Atribute is not a number for object {}, attribute {}", on, attr);
                            }
                        } else {
                            LOG.debug("Atribute is null for object {}, attribute {}", on, attr);
                        }
                    }
                }

                if (LOG.isTraceEnabled()) {
                    Date d = new Date(now);
                    SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss.SSS");
                    LOG.trace("writing: time={}, metric={}", fmt.format(d), metric);
                }

                writer.write(metric);
            } catch (Exception x) {
                LOG.error(x.toString(), x);
            }
        }
    }

    private static class MetricDef {

        public ObjectName name;
        public final Set<String> attrs = new HashSet<>();

        public MetricDef(ObjectName name) {
            this.name = name;
        }
    }
}
