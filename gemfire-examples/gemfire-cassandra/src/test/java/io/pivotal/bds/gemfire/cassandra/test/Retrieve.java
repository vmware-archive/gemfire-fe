package io.pivotal.bds.gemfire.cassandra.test;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.cache.client.ClientRegionFactory;
import com.gemstone.gemfire.cache.client.ClientRegionShortcut;
import com.gemstone.gemfire.pdx.ReflectionBasedAutoSerializer;

import io.pivotal.bds.gemfire.cassandra.data.Account;
import io.pivotal.bds.gemfire.cassandra.key.AccountKey;

public class Retrieve {

    public static void main(String[] args) throws Exception {
        ClientCacheFactory ccf = new ClientCacheFactory();

        ccf.addPoolLocator("localhost", 10334);
        ccf.setPdxPersistent(false);
        ccf.setPdxReadSerialized(false);
        ccf.setPdxSerializer(new ReflectionBasedAutoSerializer("io.pivotal.bds.gemfire.cassandra.data.*"));

        ClientCache cc = ccf.create();

        ClientRegionFactory<AccountKey, Account> crf = cc.createClientRegionFactory(ClientRegionShortcut.PROXY);
        Region<AccountKey, Account> r = crf.create("account");

        for (int i = 0; i < 10; ++i) {
            String id = "account-" + i;

            AccountKey key = new AccountKey(id);
            Account acct = r.get(key);
            System.out.println(key + " " + acct);
        }
    }
}
