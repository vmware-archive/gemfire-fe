package io.pivotal.bds.gemfire.groovy.test;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.cache.client.ClientRegionFactory;
import com.gemstone.gemfire.cache.client.ClientRegionShortcut;
import com.gemstone.gemfire.cache.execute.FunctionService;
import com.gemstone.gemfire.pdx.ReflectionBasedAutoSerializer;

import io.pivotal.bds.gemfire.groovy.common.ScriptExecutionContext;

public class ExecuteScript {

    private static final Logger LOG = LoggerFactory.getLogger(ExecuteScript.class);

    public static void main(String[] args) throws Exception {
        LOG.info("creating ClientCacheFactory");
        ClientCacheFactory ccf = new ClientCacheFactory();

        ccf.addPoolLocator("localhost", 10334);
        ccf.setPdxSerializer(
                new ReflectionBasedAutoSerializer("io.pivotal.bds.gemfire.groovy.data.*,io.pivotal.bds.gemfire.data.ecom.*"));

        LOG.info("creating ClientCache");
        ClientCache cc = ccf.create();

        try {
            LOG.info("creating script Region");
            ClientRegionFactory<String, String> crf = cc.createClientRegionFactory(ClientRegionShortcut.PROXY);
            Region<String, String> r = crf.create("script");

            ScriptExecutionContext sec = new ScriptExecutionContext("test.groovy", "whatever");

            Set<String> filter = new HashSet<>();
            filter.add("abc");

            LOG.info("executing function");
            // FunctionService.onRegion(r).withArgs(sec).withFilter(filter).execute("ScriptExecutionFunction").getResult();

            for (int i = 0; i < 100; ++i) {
                FunctionService.onRegion(r).withArgs(sec).withFilter(filter).execute("ScriptExecutionFunction").getResult();
            }
        } finally {
            LOG.info("closing ClientCache");
            cc.close();
        }
    }
}
