package io.pivotal.bds.gemfire.groovy.test;

import java.net.URL;

import io.pivotal.bds.gemfire.groovy.server.util.GemfireURLStreamHandler;

public class URLTest {

    public static void main(String[] args) throws Exception {
        URL u = new URL(null, "gf://whatever.groovy", new GemfireURLStreamHandler(null));
        String s = u.toExternalForm();
        System.out.println(s);
    }
}
