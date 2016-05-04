package io.pivotal.bds.gemfire.util;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.Assert;

import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.cache.client.PoolFactory;

public class LocatorHelper {

    private static final Pattern pattern = Pattern.compile("(?<host>[\\-\\.\\w-]+)\\[(?<port>\\d+)\\]");
    private static final Logger LOG = LogManager.getLogger(LocatorHelper.class);

    public static void addLocators(ClientCacheFactory cacheFactory, String locatorString) {
        LOG.info("addLocators: locatorString={}", locatorString);
        List<InetSocketAddress> list = parseLocators(locatorString);

        for (InetSocketAddress i : list) {
            cacheFactory.addPoolLocator(i.getHostName(), i.getPort());
        }
    }

    public static void addLocators(PoolFactory poolFactory, String locatorString) {
        LOG.info("addLocators: locatorString={}", locatorString);
        List<InetSocketAddress> list = parseLocators(locatorString);

        for (InetSocketAddress i : list) {
            poolFactory.addLocator(i.getHostName(), i.getPort());
        }
    }

    public static List<InetSocketAddress> parseLocators(String t) {
        List<InetSocketAddress> list = new ArrayList<>();
        String[] ss = t.split(",");

        for (String s : ss) {
            Matcher m = pattern.matcher(s);

            while (m.find()) {
                String host = m.group("host");
                String port = m.group("port");
                LOG.info("parseLocators: host={}, port={}, locatorString={}", host, port, s);

                Assert.hasText(host, "Missing host in locator string " + s);
                Assert.hasText(port, "Missing port in locator string " + s);

                try {
                    int p = Integer.parseInt(port);
                    list.add(new InetSocketAddress(host, p));
                } catch (Exception x) {
                    throw new IllegalArgumentException("Port is not a number in locator string " + s);
                }
            }
        }

        return list;
    }
}
