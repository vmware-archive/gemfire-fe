package io.pivotal.bds.gemfire.r.server.listener;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.gemstone.gemfire.cache.CacheFactory;
import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.EntryEvent;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.query.Query;
import com.gemstone.gemfire.cache.query.QueryService;
import com.gemstone.gemfire.cache.query.SelectResults;
import com.gemstone.gemfire.cache.query.Struct;
import com.gemstone.gemfire.cache.util.CacheListenerAdapter;

import io.pivotal.bds.gemfire.ml.ModelName;
import io.pivotal.bds.gemfire.ml.ModelType;
import io.pivotal.bds.gemfire.r.common.ModelData;
import io.pivotal.bds.gemfire.r.common.ModelDef;
import io.pivotal.bds.gemfire.r.common.ModelKey;
import io.pivotal.bds.gemfire.r.server.util.Utils;
import io.pivotal.bds.gemfire.util.RegionHelper;

public class ModelDefCacheListener extends CacheListenerAdapter<ModelKey, ModelDef>implements Declarable {

    private static final Logger LOG = LoggerFactory.getLogger(ModelDefCacheListener.class);

    @Override
    public void afterCreate(EntryEvent<ModelKey, ModelDef> event) {
        LOG.debug("afterCreate: event={}", event);
        generateModel(event);
    }

    @Override
    public void afterUpdate(EntryEvent<ModelKey, ModelDef> event) {
        LOG.debug("afterUpdate: event={}", event);
        generateModel(event);
    }

    @Override
    public void afterDestroy(EntryEvent<ModelKey, ModelDef> event) {
        ModelKey modelKey = event.getKey();
        LOG.debug("afterDestroy: modelId={}", modelKey);
        RegionHelper.getRegion("modelData").remove(modelKey);
    }

    private void generateModel(EntryEvent<ModelKey, ModelDef> event) {
        try {
            ModelKey modelKey = event.getKey();
            ModelDef modelDef = event.getNewValue();
            LOG.debug("generateModel: modelKey={}, modelDef={}", modelKey, modelDef);

            String queryId = modelDef.getQueryId();
            Region<String, String> queryRegion = RegionHelper.getRegion("queries");
            String query = queryRegion.get(queryId);
            LOG.debug("generateModel: modelKey={}, query={}", modelKey, query);
            Assert.hasText(query, "Query " + queryId + " does not exist");

            List<Object> queryArgs = modelDef.getQueryArgs();
            List<Struct> list = doQuery(query, queryArgs);
            LOG.debug("generateModel: modelKey={}, list.size={}", modelKey, list.size());

            ModelType modelType = modelDef.getModelType();
            ModelName modelName = modelDef.getModelName();
            Map<String, Object> properties = modelDef.getParameters();

            Region<ModelKey, ModelData> modelDataRegion = RegionHelper.getRegion("modelData");

            double[][] x = Utils.extractX(list);
            Number[] y = null;

            switch (modelType) {
                case classification: {
                    y = Utils.extractIntY(list);
                    break;
                }
                case regression: {
                    y = Utils.extractDoubleY(list);
                    break;
                }
                default: {
                    // TODO
                }
            }

            ModelData data = new ModelData(modelKey, modelType, modelName, properties, x, y);
            modelDataRegion.put(modelKey, data);
        } catch (Exception x) {
            LOG.error("generateModel: x={}", x.toString(), x);
            throw new IllegalArgumentException(x.toString(), x);
        }
    }

    @Override
    public void init(Properties props) {
    }

    private List<Struct> doQuery(String query, List<Object> args) throws Exception {
        // TODO check query for limit
        QueryService qs = CacheFactory.getAnyInstance().getQueryService();
        Query q = qs.newQuery(query);
        @SuppressWarnings("unchecked")
        SelectResults<Struct> res = (SelectResults<Struct>) (args == null || args.isEmpty() ? q.execute()
                : q.execute(args.toArray()));
        // TODO check for struct, x and y fields
        return res.asList();
    }
}
