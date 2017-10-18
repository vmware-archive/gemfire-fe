package io.pivotal.bds.gemfire.groovy.server.listener;

import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.EntryEvent;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.util.CacheListenerAdapter;

import io.pivotal.bds.gemfire.groovy.server.util.StringURLConnection;

public class ScriptCacheListener extends CacheListenerAdapter<String, String> {

    private URLStreamHandler handler;
    private Region<URL, URLConnection> connectionRegion;

    private static final Logger LOG = LoggerFactory.getLogger(ScriptCacheListener.class);

    public ScriptCacheListener(URLStreamHandler handler, Region<URL, URLConnection> connectionRegion) {
        this.handler = handler;
        this.connectionRegion = connectionRegion;
    }

    @Override
    public void afterCreate(EntryEvent<String, String> event) {
        String key = event.getKey();
        String value = event.getNewValue();
        LOG.info("afterCreate: key={}, value={}", key, value);

        try {
            URL url = new URL(null, "gf:/" + key, handler);
            URLConnection conn = new StringURLConnection(url, value);
            connectionRegion.put(url, conn);
        } catch (Exception x) {
            throw new IllegalArgumentException(x.toString(), x);
        }
    }

    @Override
    public void afterDestroy(EntryEvent<String, String> event) {
        String key = event.getKey();
        LOG.info("afterDestroy: key={}", key);

        try {
            URL url = new URL(null, "gf:/" + key, handler);
            connectionRegion.remove(url);
        } catch (Exception x) {
            throw new IllegalArgumentException(x.toString(), x);
        }
    }

    @Override
    public void afterUpdate(EntryEvent<String, String> event) {
        String key = event.getKey();
        String value = event.getNewValue();
        LOG.info("afterUpdate: key={}, value={}", key, value);

        try {
            URL url = new URL(null, "gf:/" + key, handler);
            URLConnection conn = new StringURLConnection(url, value);
            connectionRegion.put(url, conn);
        } catch (Exception x) {
            throw new IllegalArgumentException(x.toString(), x);
        }
    }
}
