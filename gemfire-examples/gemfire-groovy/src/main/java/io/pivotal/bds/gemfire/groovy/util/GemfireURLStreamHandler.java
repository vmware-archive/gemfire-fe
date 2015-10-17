package io.pivotal.bds.gemfire.groovy.util;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.Region;

public class GemfireURLStreamHandler extends URLStreamHandler {

    private Region<URL, URLConnection> region;

    private static final Logger LOG = LoggerFactory.getLogger(GemfireURLStreamHandler.class);

    public GemfireURLStreamHandler(Region<URL, URLConnection> region) {
        this.region = region;
    }

    @Override
    protected URLConnection openConnection(URL url) throws IOException {
        LOG.debug("openConnection: url={}", url);

        URLConnection conn = region.get(url);
        LOG.debug("openConnection: url={}, conn={}", url, conn);

        if (conn == null) {
            throw new IOException("Script " + url + " not found");
        }

        return conn;
    }
}
