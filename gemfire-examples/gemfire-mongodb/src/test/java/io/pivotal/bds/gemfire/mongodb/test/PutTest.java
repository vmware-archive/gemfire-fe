package io.pivotal.bds.gemfire.mongodb.test;

import java.util.Date;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.ClientRegionFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;

import io.pivotal.bds.gemfire.mongodb.data.Account;
import io.pivotal.bds.gemfire.mongodb.data.AccountKey;

public class PutTest {

    public static void main(String[] args) throws Exception {
        ClientCacheFactory ccf = new ClientCacheFactory();

        ccf.addPoolLocator("localhost", 10334);

        ClientCache cc = ccf.create();

        ClientRegionFactory<AccountKey, Account> crf1 = cc.createClientRegionFactory(ClientRegionShortcut.PROXY);
        Region<AccountKey, Account> region1 = crf1.create("region1");

        ClientRegionFactory<String, Account> crf2 = cc.createClientRegionFactory(ClientRegionShortcut.PROXY);
        Region<String, Account> region2 = crf2.create("region2");

        for (int i = 0; i < 10; ++i) {
            String id = "id-" + i;
            String name = "name-" + i;
            double amt = 10.0 * i;
            Date d = new Date();

            AccountKey key = new AccountKey(id);

            Account acct = new Account();

            acct.setId(id);
            acct.setName(name);
            acct.setAmount(amt);
            acct.setCreatedOn(d);

            region1.put(key, acct);
            region2.put(id, acct);
        }
    }
}
