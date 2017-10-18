package io.pivotal.bds.gemfire.r.server.writer;

import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.CacheWriterException;
import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.EntryEvent;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.util.CacheWriterAdapter;

import io.pivotal.bds.gemfire.r.common.Matrix;
import io.pivotal.bds.gemfire.r.common.MatrixKey;
import io.pivotal.bds.gemfire.r.common.Vector;
import io.pivotal.bds.gemfire.r.common.VectorKey;
import io.pivotal.bds.gemfire.r.common.Window;
import io.pivotal.bds.gemfire.r.common.WindowDef;
import io.pivotal.bds.gemfire.r.common.WindowKey;
import io.pivotal.bds.gemfire.util.RegionHelper;

public class WindowCacheWriter<T> extends CacheWriterAdapter<WindowKey, Window<T>>implements Declarable {

    private static final Logger LOG = LoggerFactory.getLogger(WindowCacheWriter.class);

    @Override
    public void beforeCreate(EntryEvent<WindowKey, Window<T>> event) throws CacheWriterException {
        LOG.debug("beforeCreate: event={}", event);
        updateMatrixOrVector(event);
    }

    @Override
    public void beforeUpdate(EntryEvent<WindowKey, Window<T>> event) throws CacheWriterException {
        LOG.debug("beforeUpdate: event={}", event);
        updateMatrixOrVector(event);
    }

    @Override
    public void init(Properties props) {
    }

    @SuppressWarnings("unchecked")
    private void updateMatrixOrVector(EntryEvent<WindowKey, Window<T>> event) throws CacheWriterException {
        WindowKey key = event.getKey();
        LOG.debug("updateMatrixOrVector: key={}", key);

        Window<T> win = event.getNewValue();

        Region<WindowKey, WindowDef> windowDefRegion = RegionHelper.getRegion("windowDef");
        WindowDef def = windowDefRegion.get(key);
        LOG.debug("updateMatrixOrVector: key={}, def={}", key, def);

        Object targetKey = def.getTargetKey();

        if (MatrixKey.class.isInstance(targetKey)) {
            Window<Vector<Number>> wwin = (Window<Vector<Number>>) win;
            MatrixKey mk = MatrixKey.class.cast(targetKey);
            
            List<Vector<Number>> list = wwin.asList();
            Matrix<Number> m = new Matrix<>(list);

            Region<MatrixKey, Matrix<Number>> matrixRegion = RegionHelper.getRegion("matrix");
            matrixRegion.put(mk, m);
        } else if (VectorKey.class.isInstance(targetKey)) {
            Window<Number> vwin = (Window<Number>) win;
            VectorKey vk = VectorKey.class.cast(targetKey);
            
            List<Number> list = vwin.asList();
            Vector<Number> v = new Vector<>(list);

            Region<VectorKey, Vector<Number>> vectorRegion = RegionHelper.getRegion("vector");
            vectorRegion.put(vk, v);
        } else {
            throw new CacheWriterException("Target is not a vector or matrix: " + targetKey.getClass().getName());
        }
    }
}
