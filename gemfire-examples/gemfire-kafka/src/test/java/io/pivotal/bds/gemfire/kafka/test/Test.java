package io.pivotal.bds.gemfire.kafka.test;

import java.util.Date;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.pdx.JSONFormatter;
import com.gemstone.gemfire.pdx.PdxInstance;
import com.gemstone.gemfire.pdx.PdxInstanceFactory;

import io.pivotal.bds.gemfire.data.ecom.Account;
import io.pivotal.bds.gemfire.data.ecom.AccountKey;
import io.pivotal.bds.gemfire.data.ecom.AccountStatus;

public class Test {

    public static void main(String[] args) throws Exception {
        ClientCacheFactory ccf = new ClientCacheFactory();
        ClientCache cc = ccf.create();

        Region<String, Account> r1 = cc.getRegion("r1");
        Region<String, io.pivotal.bds.gemfire.kafka.avro.Account> r2 = cc.getRegion("r2");
        Region<String, PdxInstance> r3 = cc.getRegion("r3");

        for (int i = 0; i < 10; ++i) {
            String id = "account-" + i;
            AccountKey ak = new AccountKey((long) i);
            
            io.pivotal.bds.gemfire.kafka.avro.Account avAcct = new io.pivotal.bds.gemfire.kafka.avro.Account();
            avAcct.setName(id);
            avAcct.setCreatedOn(new Date().toString());
            avAcct.setStatus(AccountStatus.ACTIVE.name());

            Account acct = new Account();

            acct.setKey(ak);
            acct.setCreatedOn(new Date());
            acct.setName(id);
            acct.setStatus(AccountStatus.ACTIVE);

            PdxInstanceFactory pif = cc.createPdxInstanceFactory(JSONFormatter.JSON_CLASSNAME);

            pif.writeDate("createdOn", new Date());
            pif.writeString("name", id);

            PdxInstance inst = pif.create();

            r1.put(id, acct);
            r2.put(id, avAcct);
//            r3.put(id, inst);
        }
    }
}
