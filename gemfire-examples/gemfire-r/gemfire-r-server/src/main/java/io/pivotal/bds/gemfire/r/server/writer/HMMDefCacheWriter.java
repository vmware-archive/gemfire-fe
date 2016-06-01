package io.pivotal.bds.gemfire.r.server.writer;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.CacheWriterException;
import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.EntryEvent;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.util.CacheWriterAdapter;

import io.pivotal.bds.gemfire.r.common.HMMData;
import io.pivotal.bds.gemfire.r.common.HMMDef;
import io.pivotal.bds.gemfire.r.common.HMMKey;
import io.pivotal.bds.gemfire.r.common.Matrix;
import io.pivotal.bds.gemfire.r.common.MatrixKey;
import io.pivotal.bds.gemfire.r.common.Vector;
import io.pivotal.bds.gemfire.r.common.VectorKey;
import io.pivotal.bds.gemfire.r.server.util.Utils;
import io.pivotal.bds.gemfire.util.Assert;
import io.pivotal.bds.gemfire.util.RegionHelper;

public class HMMDefCacheWriter<O> extends CacheWriterAdapter<HMMKey, HMMDef>implements Declarable {

    private static final Logger LOG = LoggerFactory.getLogger(HMMDefCacheWriter.class);

    @Override
    public void beforeCreate(EntryEvent<HMMKey, HMMDef> event) throws CacheWriterException {
        LOG.debug("beforeCreate: event={}", event);
        createHMM(event);
    }

    @Override
    public void beforeUpdate(EntryEvent<HMMKey, HMMDef> event) throws CacheWriterException {
        LOG.debug("beforeUpdate: event={}", event);
        createHMM(event);
    }

    @Override
    public void beforeDestroy(EntryEvent<HMMKey, HMMDef> event) throws CacheWriterException {
        LOG.debug("beforeDestroy: event={}", event);
        HMMKey key = event.getKey();
        Region<HMMKey, HMMData<?>> dataRegion = RegionHelper.getRegion("hmmData");
        dataRegion.remove(key);
    }

    @Override
    public void init(Properties props) {
    }

    @SuppressWarnings("unchecked")
    private void createHMM(EntryEvent<HMMKey, HMMDef> event) throws CacheWriterException {
        HMMKey key = event.getKey();
        HMMDef def = event.getNewValue();
        LOG.debug("createHMM: key={}, def={}", key, def);

        Region<VectorKey, Vector<Object>> vectorRegion = RegionHelper.getRegion("vector");
        Region<MatrixKey, Matrix<Object>> matrixRegion = RegionHelper.getRegion("matrix");

        VectorKey piKey = def.getPiKey();
        Vector<Object> piV = vectorRegion.get(piKey);
        Assert.notNull(piV, "Vector %s not found", piKey.getId());

        MatrixKey aKey = def.getaKey();
        Matrix<Object> am = matrixRegion.get(aKey);
        Assert.notNull(am, "Matrix %s not found", aKey.getId());

        MatrixKey bKey = def.getbKey();
        Matrix<Object> bm = matrixRegion.get(bKey);
        Assert.notNull(bm, "Matrix %s not found", bKey.getId());

        Object[] s = null;
        VectorKey sKey = def.getSymbolsKey();

        if (sKey != null) {
            Vector<O> sv = (Vector<O>) vectorRegion.get(piKey);
            Assert.notNull(sv, "Vector %s not found", sKey.getId());
            s = sv.getVector().toArray();
        }

        double[] pi = Utils.convertObjectVectorToDoubleArray(piV);
        double[][] a = Utils.convertObjectMatrixToDoubleArray(am);
        double[][] b = Utils.convertObjectMatrixToDoubleArray(bm);

        HMMData<?> data = new HMMData<>(pi, a, b, s);
        LOG.debug("createHMM: key={}, data={}", key, data);

        Region<HMMKey, HMMData<?>> dataRegion = RegionHelper.getRegion("hmmData");
        dataRegion.put(key, data);
    }
}
