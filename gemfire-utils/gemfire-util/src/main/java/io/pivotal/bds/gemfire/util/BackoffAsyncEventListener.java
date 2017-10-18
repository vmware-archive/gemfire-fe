package io.pivotal.bds.gemfire.util;

import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.asyncqueue.AsyncEvent;
import org.apache.geode.cache.asyncqueue.AsyncEventListener;

public abstract class BackoffAsyncEventListener implements AsyncEventListener, Declarable {

    private long initialDelay;
    private long maximumDelay;
    private double delayScaling;
    private int errorCountThreshold;

    private long delay = initialDelay;
    private int errorCount = 0;

    private static final long DEFAULT_INITIAL_DELAY = 1000L; // one second
    private static final long DEFAULT_MAXIMUM_DELAY = 16000L; // 16 seconds
    private static final double DEFAULT_DELAY_SCALING = 2.0;
    private static final int DEFAULT_ERROR_COUNT_THRESHOLD = 10;

    protected final Logger LOG;

    public BackoffAsyncEventListener() {
        LOG = LogManager.getLogger(getClass());
    }

    @SuppressWarnings("rawtypes")
    @Override
    public final boolean processEvents(List<AsyncEvent> events) {
        try {
            doProcessEvents(events);

            errorCount = 0;
            delay = initialDelay;

            return true;
        } catch (Exception x) {
            LOG.error(x.toString(), x);

            if (++errorCount >= errorCountThreshold) {
                long d = delay;

                delay += delay * delayScaling;

                if (delay > maximumDelay) {
                    delay = maximumDelay;
                }

                LOG.error("errorCount={}, delay={}", errorCount, d);

                try {
                    synchronized (this) {
                        this.wait(d);
                    }
                } catch (InterruptedException ie) {
                    // ignore
                }
            }

            return false;
        }
    }

    @SuppressWarnings("rawtypes")
    protected abstract void doProcessEvents(List<AsyncEvent> events) throws Exception;

    @Override
    public void init(Properties props) {
        initialDelay = getLong(props, "initialDelay", DEFAULT_INITIAL_DELAY);
        maximumDelay = getLong(props, "maximumDelay", DEFAULT_MAXIMUM_DELAY);
        errorCountThreshold = getInt(props, "errorCountThreshold", DEFAULT_ERROR_COUNT_THRESHOLD);
        delayScaling = getDouble(props, "delayScaling", DEFAULT_DELAY_SCALING);
        LOG.info("init: initialDelay={}, maximumDelay={}, errorCountThreshold={}, delayScaling={}", initialDelay, maximumDelay,
                errorCountThreshold, delayScaling);
    }

    @Override
    public void close() {
        synchronized (this) {
            this.notify();
        }
    }

    private static String getString(Properties props, String name) {
        String s = System.getProperty("BackoffAsyncEventListener." + name);
        s = props.getProperty(name, s);

        if (s == null || s.trim().length() == 0) {
            return null;
        }

        return s;
    }

    private static long getLong(Properties props, String name, long def) {
        String s = getString(props, name);

        if (s == null) {
            return def;
        }

        try {
            return Long.parseLong(s.trim());
        } catch (NumberFormatException x) {
            return def;
        }
    }

    private static int getInt(Properties props, String name, int def) {
        String s = getString(props, name);

        if (s == null) {
            return def;
        }

        try {
            return Integer.parseInt(s.trim());
        } catch (NumberFormatException x) {
            return def;
        }
    }

    private static double getDouble(Properties props, String name, double def) {
        String s = getString(props, name);

        if (s == null) {
            return def;
        }

        try {
            return Double.parseDouble(s.trim());
        } catch (NumberFormatException x) {
            return def;
        }
    }
}
