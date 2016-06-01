package io.pivotal.bds.gemfire.r.server.writer;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.CacheWriterException;
import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.EntryEvent;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.util.CacheWriterAdapter;

import io.pivotal.bds.gemfire.r.common.VariableType;
import io.pivotal.bds.gemfire.r.common.Vector;
import io.pivotal.bds.gemfire.r.common.VectorDef;
import io.pivotal.bds.gemfire.r.common.VectorKey;
import io.pivotal.bds.gemfire.r.server.util.Utils;
import io.pivotal.bds.gemfire.util.RegionHelper;

public class VectorDefCacheWriter extends CacheWriterAdapter<VectorKey, VectorDef>implements Declarable {

    private static final Logger LOG = LoggerFactory.getLogger(VectorDefCacheWriter.class);

    @Override
    public void beforeCreate(EntryEvent<VectorKey, VectorDef> event) throws CacheWriterException {
        LOG.debug("beforeCreate: event={}", event);
        Utils.addVariableType(event.getKey(), VariableType.Vector);
        createVector(event);
    }

    @Override
    public void beforeUpdate(EntryEvent<VectorKey, VectorDef> event) throws CacheWriterException {
        LOG.debug("beforeUpdate: event={}", event);
        createVector(event);
    }

    @Override
    public void beforeDestroy(EntryEvent<VectorKey, VectorDef> event) throws CacheWriterException {
        LOG.debug("beforeDestroy: event={}", event);
        Utils.removeVariableType(event.getKey());
        VectorKey key = event.getKey();
        Region<VectorKey, Vector<Object>> r = RegionHelper.getRegion("vector");
        r.remove(key);
    }

    @Override
    public void init(Properties props) {
    }

    private void createVector(EntryEvent<VectorKey, VectorDef> event) {
        VectorKey key = event.getKey();
        VectorDef def = event.getNewValue();
        LOG.debug("createVector: key={}, def={}", key, def);

        String queryId = def.getQueryId();
        Object[] args = def.getQueryArgs();
        String fld = def.getField();

        Vector<Object> v = Utils.getVectorFromQuery(queryId, args, fld);
        LOG.debug("createVector: key={}, def={},v={}", key, def, v);
        Region<VectorKey, Vector<Object>> r = RegionHelper.getRegion("vector");
        r.put(key, v);
    }
}
