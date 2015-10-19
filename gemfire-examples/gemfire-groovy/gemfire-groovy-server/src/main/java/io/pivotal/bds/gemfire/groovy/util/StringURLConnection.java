package io.pivotal.bds.gemfire.groovy.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class StringURLConnection extends URLConnection {

    private String data;
    private long lastModified = System.currentTimeMillis();

    public StringURLConnection(URL url, String data) {
        super(url);
        this.data = data;
    }

    @Override
    public void connect() throws IOException {
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(data.getBytes("UTF-8"));
    }

    @Override
    public long getLastModified() {
        return lastModified;
    }

}
