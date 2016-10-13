package io.pivotal.bds.gemfire.mongodb.test;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.cache.client.ClientRegionFactory;
import com.gemstone.gemfire.cache.client.ClientRegionShortcut;

import io.pivotal.bds.gemfire.mongodb.data.Account;
import io.pivotal.bds.gemfire.mongodb.data.AccountKey;

public class GetTest {

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

            AccountKey key = new AccountKey(id);

            Account value1 = region1.get(key);
            System.out.println("key=" + key + ", value1=" + value1);

            Account value2 = region2.get(id);
            System.out.println("id=" + id + ", value2=" + value2);
        }
    }
}
