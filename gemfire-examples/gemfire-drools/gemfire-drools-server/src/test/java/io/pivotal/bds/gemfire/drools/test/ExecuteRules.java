package io.pivotal.bds.gemfire.drools.test;

import java.util.HashSet;
import java.util.Set;

import org.kie.api.KieServices;
import org.kie.api.builder.ReleaseId;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.cache.client.ClientRegionFactory;
import com.gemstone.gemfire.cache.client.ClientRegionShortcut;
import com.gemstone.gemfire.cache.execute.FunctionService;
import com.gemstone.gemfire.pdx.ReflectionBasedAutoSerializer;

import io.pivotal.bds.gemfire.data.ecom.OrderKey;
import io.pivotal.bds.gemfire.drools.common.RuleExecutionContext;

public class ExecuteRules {

    public static void main(String[] args) throws Exception {
        KieServices ks = KieServices.Factory.get();

        ClientCacheFactory ccf = new ClientCacheFactory();
        ccf.addPoolLocator("localhost", 10334);
        ccf.setPdxSerializer(new ReflectionBasedAutoSerializer("io.pivotal.bds.gemfire.data.ecom.*"));
        ClientCache cc = ccf.create();

        try {
            ClientRegionFactory<String, String> crf = cc.createClientRegionFactory(ClientRegionShortcut.PROXY);
            Region<String, String> r = crf.create("account");

            OrderKey key = new OrderKey(1L, 1L);

            Set<Object> filter = new HashSet<>();
            filter.add(key);

            ReleaseId relId = ks.newReleaseId("io.pivotal.bds.gemfire.drools", "gemfire-drools", "1.0.0");

            RuleExecutionContext rec = new RuleExecutionContext(relId, null);

            long acctId = 1L;
            long orderId = 1L;

            for (int i = 0; i < 1000; ++i) {
                if (acctId > 11L) {
                    acctId = 1L;
                }

                key.setId(orderId);
                key.setColocationId(acctId);
                FunctionService.onRegion(r).withFilter(filter).withArgs(rec).execute("StatelessRuleExecutionFunction").getResult();
            }
        } finally {
            cc.close();
        }
    }
}
