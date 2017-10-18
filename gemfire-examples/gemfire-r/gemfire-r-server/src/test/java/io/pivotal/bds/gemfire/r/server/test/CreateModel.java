package io.pivotal.bds.gemfire.r.server.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.ClientRegionFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;

import io.pivotal.bds.gemfire.ml.ModelName;
import io.pivotal.bds.gemfire.ml.ModelType;
import io.pivotal.bds.gemfire.r.common.ModelDef;
import io.pivotal.bds.gemfire.r.common.ModelKey;

public class CreateModel {

    public static void main(String[] args) throws Exception {
        ClientCacheFactory ccf = new ClientCacheFactory();

        ccf.addPoolLocator("192.168.0.110", 10334);
        ccf.setPdxReadSerialized(true);

        ClientCache cc = ccf.create();

        ClientRegionFactory<ModelKey, ModelDef> crf = cc.createClientRegionFactory(ClientRegionShortcut.PROXY);
        Region<ModelKey, ModelDef> r = crf.create("modelDef");

        ModelKey key = new ModelKey("model1");

        Map<String, Object> properties = new HashMap<>();

        ModelDef def = null; // TODO new ModelDef(key, "x1", "y1", ModelType.regression, ModelName.RandomForest, properties);

        r.put(key, def);
    }
}
