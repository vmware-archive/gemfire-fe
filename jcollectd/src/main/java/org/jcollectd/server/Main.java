package org.jcollectd.server;

import org.jcollectd.server.http.HttpReceiver;
import org.jcollectd.server.mx.MBeanReceiver;

/**
 * Created with IntelliJ IDEA.
 * User: andrus
 * Date: 6/18/12
 * Time: 4:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        HttpReceiver.main(args);
        MBeanReceiver.main(args);
    }
}
