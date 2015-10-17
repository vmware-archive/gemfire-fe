package io.pivotal.bds.gemfire.script.test;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.cache.client.ClientRegionFactory;
import com.gemstone.gemfire.cache.client.ClientRegionShortcut;

public class UploadScript {

    public static void main(String[] args) throws Exception {
        ClientCacheFactory ccf = new ClientCacheFactory();

        ccf.addPoolLocator("localhost", 10334);

        ClientCache cc = ccf.create();

        ClientRegionFactory<String, String> rf = cc.createClientRegionFactory(ClientRegionShortcut.PROXY);
        Region<String,String> r = rf.create("Script");
        
        r.put("test", "System.out.println(\"Whatever\")");
    }
}
