package io.pivotal.bds.gemfire.r.server.writer;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.CacheWriterException;
import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.EntryEvent;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.util.CacheWriterAdapter;

import io.pivotal.bds.gemfire.r.common.HMMData;
import io.pivotal.bds.gemfire.r.common.HMMKey;
import io.pivotal.bds.gemfire.util.RegionHelper;
import smile.sequence.HMM;

public class HMMDataCacheWriter<O> extends CacheWriterAdapter<HMMKey, HMMData<O>>implements Declarable {

    private static final Logger LOG = LoggerFactory.getLogger(HMMDataCacheWriter.class);

    @Override
    public void beforeCreate(EntryEvent<HMMKey, HMMData<O>> event) throws CacheWriterException {
        LOG.debug("beforeCreate: event={}", event);
        createHMM(event);
    }

    @Override
    public void beforeUpdate(EntryEvent<HMMKey, HMMData<O>> event) throws CacheWriterException {
        LOG.debug("beforeUpdate: event={}", event);
        createHMM(event);
    }

    @Override
    public void beforeDestroy(EntryEvent<HMMKey, HMMData<O>> event) throws CacheWriterException {
        LOG.debug("beforeDestroy: event={}", event);
        HMMKey key = event.getKey();
        LOG.debug("beforeDestroy: key={}", key);
        Region<HMMKey, HMM<O>> r = RegionHelper.getRegion("hmm");
        r.remove(key);
    }

    @Override
    public void init(Properties props) {
    }

    private void createHMM(EntryEvent<HMMKey, HMMData<O>> event) throws CacheWriterException {
        HMMKey key = event.getKey();
        HMMData<O> value = event.getNewValue();
        LOG.debug("createHMM: key={}, value={}", key, value);

        double[] pi = value.getPi();
        double[][] a = value.getA();
        double[][] b = value.getB();
        O[] s = value.getSymbols();

        HMM<O> hmm = s == null ? new HMM<>(pi, a, b) : new HMM<>(pi, a, b, s);

        Region<HMMKey, HMM<O>> r = RegionHelper.getRegion("hmm");
        r.put(key, hmm);
    }
}
