package io.pivotal.bds.gemfire.mongodb.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.ClientRegionFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;

import io.pivotal.bds.gemfire.mongodb.data.AccountKey;

public class XrefTest {

    public static void main(String[] args) throws Exception {
        ClientCacheFactory ccf = new ClientCacheFactory();

        ccf.addPoolLocator("localhost", 10334);

        ClientCache cc = ccf.create();

        ClientRegionFactory<String, List<AccountKey>> crf = cc.createClientRegionFactory(ClientRegionShortcut.PROXY);
        Region<String, List<AccountKey>> region = crf.create("region1Xref");

        for (int i = 0; i < 10; ++i) {
            String id = "id-" + i;

            Map<String, Object> crit = new HashMap<>();
            crit.put("id", id);

            List<AccountKey> list = region.get(id, crit);
            System.out.println("id=" + id + ", crit=" + crit + ", list=" + list);
        }

        Map<String, Object> crit = new HashMap<>();

        List<String> ids = new ArrayList<>();
        ids.add("id-0");
        ids.add("id-1");

        Map<String, Object> oper = new HashMap<>();
        oper.put("$in", ids);

        crit.put("id", oper);

        System.out.println("list1=" + region.get("in1", crit));
        System.out.println("list2=" + region.get(crit));
        System.out.println("list3=" + region.get("in2", "{\"id\":{\"$in\":[\"id-2\",\"id-3\"]}}"));
        System.out.println("list4=" + region.get("{\"id\":{\"$in\":[\"id-2\",\"id-3\"]}}"));
    }
}
