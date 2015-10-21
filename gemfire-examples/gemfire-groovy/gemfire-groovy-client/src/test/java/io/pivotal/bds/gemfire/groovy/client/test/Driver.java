package io.pivotal.bds.gemfire.groovy.client.test;

import java.util.Random;
import java.util.UUID;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import io.pivotal.bds.metrics.rater.Rater;

public class Driver {

    private static final String[] securities = { "emc", "vmw", "piv" };
    private static final String[] accounts = { "acct1", "acct2", "acct3" };

    private static final Random random = new Random();

    private static final Logger LOG = LoggerFactory.getLogger(Driver.class);

    public static void main(String[] args) throws Exception {
        Rater rater = new Rater("Driver");

        LOG.info("creating connection...");
        ConnectionFactory cf = new ConnectionFactory();

        cf.setHost("localhost");
        cf.setPort(5672);
        cf.setUsername("admin");
        cf.setPassword("admin");

        Connection conn = cf.newConnection();
        Channel ch = conn.createChannel();

        LOG.info("sending messages...");

        while (true) {
            String tradeId = UUID.randomUUID().toString();
            String secId = securities[random.nextInt(securities.length)];
            String acctId = accounts[random.nextInt(accounts.length)];
            long ts = System.currentTimeMillis();
            int quan = 10 + random.nextInt(1000);
            double price = 1.0 + (99.0 * random.nextDouble());

            JSONObject o = new JSONObject();

            o.put("tradeId", tradeId);
            o.put("securityId", secId);
            o.put("accountId", acctId);
            o.put("ts", ts);
            o.put("quantity", quan);
            o.put("price", price);

            String s = o.toString();

            ch.basicPublish("", "trade", null, s.getBytes("UTF-8"));
            rater.increment();
        }
    }
}
