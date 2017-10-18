package io.pivotal.bds.gemfire.cassandra.test;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.ClientRegionFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.apache.geode.pdx.ReflectionBasedAutoSerializer;

import io.pivotal.bds.gemfire.cassandra.data.Account;
import io.pivotal.bds.gemfire.cassandra.data.AccountStatus;
import io.pivotal.bds.gemfire.cassandra.key.AccountKey;

public class Populate {

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
            
            Account acct = new Account();
            
            acct.setAccountId(id);
            acct.setLimit(i);
            acct.setStatus(AccountStatus.active);
            
            r.put(key, acct);
        }
    }
}
