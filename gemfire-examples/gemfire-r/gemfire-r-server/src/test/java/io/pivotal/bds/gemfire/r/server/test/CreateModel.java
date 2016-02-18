package io.pivotal.bds.gemfire.r.server.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.cache.client.ClientRegionFactory;
import com.gemstone.gemfire.cache.client.ClientRegionShortcut;

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

        List<Object> queryArgs = new ArrayList<>();
        Map<String, Object> properties = new HashMap<>();

        ModelDef def = new ModelDef(key, "q1", ModelType.regression, ModelName.RandomForest, queryArgs, properties);

        r.put(key, def);
    }
}
