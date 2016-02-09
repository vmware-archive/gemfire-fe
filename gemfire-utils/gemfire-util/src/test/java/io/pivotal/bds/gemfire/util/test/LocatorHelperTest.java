package io.pivotal.bds.gemfire.util.test;

import java.net.InetSocketAddress;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.pivotal.bds.gemfire.util.LocatorHelper;

public class LocatorHelperTest {

    @Test
    public void test() throws Exception {
        List<InetSocketAddress> list = LocatorHelper.parseLocators("host1[10334]");

        Assert.assertEquals(list.size(), 1);

        InetSocketAddress i = list.get(0);
        Assert.assertEquals(i.getHostName(), "host1");
        Assert.assertEquals(i.getPort(), 10334);

        list = LocatorHelper.parseLocators("host1[10334],host2[10335]");

        Assert.assertEquals(list.size(), 2);

        i = list.get(0);
        Assert.assertEquals(i.getHostName(), "host1");
        Assert.assertEquals(i.getPort(), 10334);

        i = list.get(1);
        Assert.assertEquals(i.getHostName(), "host2");
        Assert.assertEquals(i.getPort(), 10335);
    }
}
