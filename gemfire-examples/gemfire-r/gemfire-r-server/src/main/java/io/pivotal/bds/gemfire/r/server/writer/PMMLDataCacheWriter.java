package io.pivotal.bds.gemfire.r.server.writer;

import java.io.StringReader;
import java.util.Properties;

import javax.xml.transform.Source;

import org.dmg.pmml.PMML;
import org.jpmml.model.ImportFilter;
import org.jpmml.model.JAXBUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;

import org.apache.geode.cache.CacheWriterException;
import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.EntryEvent;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.util.CacheWriterAdapter;

import io.pivotal.bds.gemfire.r.common.PMMLData;
import io.pivotal.bds.gemfire.r.common.PMMLKey;
import io.pivotal.bds.gemfire.util.RegionHelper;

public class PMMLDataCacheWriter extends CacheWriterAdapter<PMMLKey, PMMLData>implements Declarable {

    private static final Logger LOG = LoggerFactory.getLogger(PMMLDataCacheWriter.class);

    @Override
    public void beforeCreate(EntryEvent<PMMLKey, PMMLData> event) throws CacheWriterException {
        LOG.debug("beforeCreate: event={}", event);
        createPMML(event);
    }

    @Override
    public void beforeUpdate(EntryEvent<PMMLKey, PMMLData> event) throws CacheWriterException {
        LOG.debug("beforeUpdate: event={}", event);
        createPMML(event);
    }

    @Override
    public void beforeDestroy(EntryEvent<PMMLKey, PMMLData> event) throws CacheWriterException {
        LOG.debug("beforeDestroy: event={}", event);
        PMMLKey key = event.getKey();
        Region<PMMLKey, PMML> r = RegionHelper.getRegion("pmml");
        r.remove(key);
    }

    @Override
    public void init(Properties props) {
    }

    private void createPMML(EntryEvent<PMMLKey, PMMLData> event) throws CacheWriterException {
        try {
            PMMLKey key = event.getKey();
            PMMLData data = event.getNewValue();
            LOG.debug("createPMML: key={}, data={}", key, data);

            String model = data.getModel();
            StringReader sr = new StringReader(model);
            Source src = ImportFilter.apply(new InputSource(sr));

            PMML pmml = JAXBUtil.unmarshalPMML(src);

            Region<PMMLKey, PMML> r = RegionHelper.getRegion("pmml");
            r.put(key, pmml);
        } catch (Exception x) {
            LOG.error("createPMML: event={}, x={}", event, x.toString(), x);
            throw new CacheWriterException(x.toString(), x);
        }
    }
}
