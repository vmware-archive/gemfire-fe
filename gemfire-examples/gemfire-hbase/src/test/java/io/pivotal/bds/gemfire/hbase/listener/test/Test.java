package io.pivotal.bds.gemfire.hbase.listener.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.cache.client.ClientRegionFactory;
import com.gemstone.gemfire.cache.client.ClientRegionShortcut;
import com.gemstone.gemfire.pdx.PdxInstance;
import com.gemstone.gemfire.pdx.PdxInstanceFactory;

public class Test {

    private static final int numberOfAccounts = 10;
    private static final int numberOfEntries = numberOfAccounts * 100;

    public static void main(String[] args) throws Exception {
        ClientCacheFactory ccf = new ClientCacheFactory();

        ccf.addPoolLocator("node1.dev", 10334);
        ccf.setPdxPersistent(true);
        ccf.setPdxReadSerialized(true);

        ClientCache cc = ccf.create();

        try {
            ClientRegionFactory<String, PdxInstance> crf = cc.createClientRegionFactory(ClientRegionShortcut.PROXY);
            Region<String, PdxInstance> r = crf.create("hbase");

            // create accountids
            List<String> accountIds = new ArrayList<>();

            for (int i = 0; i < numberOfAccounts; ++i) {
                accountIds.add(UUID.randomUUID().toString());
            }

            int ia = 0;

            // create entries
            for (int i = 0; i < numberOfEntries; ++i) {
                if (ia >= accountIds.size()) {
                    ia = 0;
                }

                String acct = accountIds.get(ia++);

                String key = UUID.randomUUID().toString();
                String desc = "entry-" + key;
                Date d = new Date();
                int amount = i;

                PdxInstanceFactory pif = cc.createPdxInstanceFactory("MyObject");

                pif.writeString("id", key);
                pif.writeString("accountId", acct);
                pif.writeString("desc", desc);
                pif.writeDate("date", d);
                pif.writeInt("amount", amount);

                PdxInstance value = pif.create();

                r.put(key, value);
            }
        } finally {
            cc.close();
        }
    }
}
