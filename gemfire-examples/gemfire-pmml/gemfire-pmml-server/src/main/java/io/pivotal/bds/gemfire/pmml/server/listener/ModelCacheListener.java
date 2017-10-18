package io.pivotal.bds.gemfire.pmml.server.listener;

import java.io.StringReader;
import java.util.Map;

import javax.xml.transform.Source;

import org.apache.geode.cache.EntryEvent;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.RegionEvent;
import org.apache.geode.cache.util.CacheListenerAdapter;
import org.dmg.pmml.PMML;
import org.jpmml.model.ImportFilter;
import org.jpmml.model.JAXBUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.xml.sax.InputSource;

import io.pivotal.bds.gemfire.pmml.common.data.Model;
import io.pivotal.bds.gemfire.pmml.common.keys.ModelKey;

@Component
public class ModelCacheListener extends CacheListenerAdapter<ModelKey, Model> {

    private Region<ModelKey, PMML> pmmlRegion;

    private static final Logger LOG = LoggerFactory.getLogger(ModelCacheListener.class);

    public ModelCacheListener(Region<ModelKey, PMML> pmmlRegion) {
        this.pmmlRegion = pmmlRegion;
    }

    @Override
    public void afterCreate(EntryEvent<ModelKey, Model> event) {
        LOG.info("afterCreate: event={}", event);
        createModel(event);
    }

    @Override
    public void afterDestroy(EntryEvent<ModelKey, Model> event) {
        LOG.info("afterDestroy: event={}", event);
        ModelKey key = event.getKey();
        pmmlRegion.remove(key);
    }

    @Override
    public void afterUpdate(EntryEvent<ModelKey, Model> event) {
        LOG.info("afterCreate: event={}", event);
        createModel(event);
    }

    @Override
    public void afterRegionCreate(RegionEvent<ModelKey, Model> event) {
        LOG.info("afterRegionCreate");
        for (Map.Entry<ModelKey, Model> entry: event.getRegion().entrySet()) {
            createModel(entry.getKey(), entry.getValue());
        }
    }

    private void createModel(EntryEvent<ModelKey, Model> event) {
        ModelKey key = event.getKey();
        Model model = event.getNewValue();
        createModel(key, model);
    }

    private void createModel(ModelKey key, Model model) {
        LOG.info("createModel: key={}, model={}", key, model);
        try {
            String s = model.getModel();
            Source source = ImportFilter.apply(new InputSource(new StringReader(s)));

            PMML pmml = JAXBUtil.unmarshalPMML(source);
            pmmlRegion.put(key, pmml);
        } catch (Exception x) {
            LOG.error("createModel: x={}", x.toString(), x);
            throw new IllegalArgumentException(x.toString(), x);
        }
    }
}
