package io.pivotal.bds.gemfire.r.server.writer;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.CacheWriterException;
import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.EntryEvent;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.util.CacheWriterAdapter;

import io.pivotal.bds.gemfire.r.common.Matrix;
import io.pivotal.bds.gemfire.r.common.MatrixDef;
import io.pivotal.bds.gemfire.r.common.MatrixKey;
import io.pivotal.bds.gemfire.r.common.VariableType;
import io.pivotal.bds.gemfire.r.server.util.Utils;
import io.pivotal.bds.gemfire.util.RegionHelper;

public class MatrixDefCacheWriter extends CacheWriterAdapter<MatrixKey, MatrixDef>implements Declarable {

    private static final Logger LOG = LoggerFactory.getLogger(MatrixDefCacheWriter.class);

    @Override
    public void beforeCreate(EntryEvent<MatrixKey, MatrixDef> event) throws CacheWriterException {
        LOG.debug("beforeCreate: event={}", event);
        Utils.addVariableType(event.getKey(), VariableType.Matrix);
        createMatrix(event);
    }

    @Override
    public void beforeUpdate(EntryEvent<MatrixKey, MatrixDef> event) throws CacheWriterException {
        LOG.debug("beforeUpdate: event={}", event);
        createMatrix(event);
    }

    @Override
    public void beforeDestroy(EntryEvent<MatrixKey, MatrixDef> event) throws CacheWriterException {
        LOG.debug("beforeDestroy: event={}", event);
        Utils.removeVariableType(event.getKey());
        MatrixKey key = event.getKey();
        Region<MatrixKey, Matrix<Object>> r = RegionHelper.getRegion("matrix");
        r.remove(key);
    }

    @Override
    public void init(Properties props) {
    }

    private void createMatrix(EntryEvent<MatrixKey, MatrixDef> event) {
        MatrixKey key = event.getKey();
        MatrixDef def = event.getNewValue();
        LOG.debug("createMatrix: key={}, def={}", key, def);

        String queryId = def.getQueryId();
        Object[] args = def.getQueryArgs();
        String[] flds = def.getFields();

        Matrix<Object> matrix = Utils.getMatrixFromQuery(queryId, args, flds);
        LOG.debug("createMatrix: key={}, matrix={}", key, matrix);

        Region<MatrixKey, Matrix<Object>> r = RegionHelper.getRegion("matrix");
        r.put(key, matrix);
    }
}
