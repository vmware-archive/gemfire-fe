package io.pivotal.bds.gemfire.r.server.test;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.cache.client.ClientRegionFactory;
import com.gemstone.gemfire.cache.client.ClientRegionShortcut;

import io.pivotal.bds.gemfire.r.common.EvaluateDef;
import io.pivotal.bds.gemfire.r.common.EvaluateKey;
import io.pivotal.bds.gemfire.r.common.ModelKey;

public class CreateEvaluate {

    public static void main(String[] args) throws Exception {
        ClientCacheFactory ccf = new ClientCacheFactory();

        ccf.addPoolLocator("192.168.0.110", 10334);
        ccf.setPdxReadSerialized(true);

        ClientCache cc = ccf.create();

        ClientRegionFactory<EvaluateKey, EvaluateDef> crf = cc.createClientRegionFactory(ClientRegionShortcut.PROXY);
        Region<EvaluateKey, EvaluateDef> r = crf.create("evaluate");

        EvaluateKey key = new EvaluateKey("eval1", "model1");
        ModelKey mk = new ModelKey(key.getModelId());
        EvaluateDef def = new EvaluateDef(mk, "testData", new String[] { "temp" });

        r.put(key, def);
    }
}
