package io.pivotal.bds.gemfire.localregion.test;

import java.util.Date;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.ClientRegionFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.apache.geode.pdx.ReflectionBasedAutoSerializer;

import io.pivotal.bds.gemfire.data.ecom.Account;
import io.pivotal.bds.gemfire.data.ecom.AccountKey;
import io.pivotal.bds.gemfire.data.ecom.Order;
import io.pivotal.bds.gemfire.data.ecom.OrderKey;

public class Populate {

    public static void main(String[] args) throws Exception {
        new Populate().run();
    }

    private void run() throws Exception {
        ClientCacheFactory ccf = new ClientCacheFactory();

        ccf.setPdxReadSerialized(false);
        ccf.setPdxSerializer(
                new ReflectionBasedAutoSerializer("io.pivotal.bds.gemfire.localregion.data.*,io.pivotal.bds.gemfire.data.ecom.*"));
        ccf.addPoolLocator("localhost", 10334);

        ClientCache cc = ccf.create();

        Region<AccountKey, Account> accountRegion = createRegion("account", cc);
        Region<OrderKey, Order> orderRegion = createRegion("order", cc);

        long orderId = 0;

        for (long ia = 0; ia < 10; ++ia) {
            AccountKey akey = new AccountKey(ia);

            Account acct = new Account();

            acct.setKey(akey);
            acct.setName("account-" + ia);
            acct.setCreatedOn(new Date());

            accountRegion.put(akey, acct);

            for (int io = 0; io < 5; ++io) {
                OrderKey okey = new OrderKey(orderId++, ia);
                Order order = new Order();

                order.setKey(okey);
                order.setAccountKey(akey);
                order.setOrderedOn(new Date());
                order.setTotal(io);

                orderRegion.put(okey, order);
            }
        }
    }

    private <K, V> Region<K, V> createRegion(String name, ClientCache cache) {
        ClientRegionFactory<K, V> crf = cache.createClientRegionFactory(ClientRegionShortcut.PROXY);
        crf.setPoolName(cache.getDefaultPool().getName());
        return crf.create(name);
    }
}
