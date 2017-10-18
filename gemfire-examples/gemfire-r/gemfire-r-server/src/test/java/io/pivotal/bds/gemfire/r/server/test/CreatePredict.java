package io.pivotal.bds.gemfire.r.server.test;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.ClientRegionFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;

import io.pivotal.bds.gemfire.r.common.PredictDef;
import io.pivotal.bds.gemfire.r.common.PredictDefKey;
import io.pivotal.bds.gemfire.r.common.ModelKey;

public class CreatePredict {

    public static void main(String[] args) throws Exception {
        ClientCacheFactory ccf = new ClientCacheFactory();

        ccf.addPoolLocator("192.168.0.110", 10334);
        ccf.setPdxReadSerialized(true);

        ClientCache cc = ccf.create();

        ClientRegionFactory<PredictDefKey, PredictDef> crf = cc.createClientRegionFactory(ClientRegionShortcut.PROXY);
        Region<PredictDefKey, PredictDef> r = crf.create("evaluate");

        PredictDefKey key = new PredictDefKey("eval1", "model1");
        ModelKey mk = new ModelKey(key.getColocationId());
        PredictDef def = new PredictDef(mk, "testData", new String[] { "temp" });

        r.put(key, def);
    }
}
