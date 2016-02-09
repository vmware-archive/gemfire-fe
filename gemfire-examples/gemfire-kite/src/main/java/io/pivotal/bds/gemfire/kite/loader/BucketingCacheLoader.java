package io.pivotal.bds.gemfire.kite.loader;

import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.CacheLoader;
import com.gemstone.gemfire.cache.CacheLoaderException;
import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.LoaderHelper;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.pdx.PdxInstance;

import io.pivotal.bds.gemfire.kite.util.DatasetHelper;
import io.pivotal.bds.gemfire.util.RegionHelper;

public class BucketingCacheLoader<K> implements CacheLoader<K, PdxInstance>, Declarable {

    private String keyFieldName = "id";
    private String bucketedRegionNameSuffix = "Bucket";

    private static final Logger LOG = LoggerFactory.getLogger(BucketingCacheLoader.class);

    public BucketingCacheLoader() {
    }

    public BucketingCacheLoader(String keyFieldName, String bucketedRegionNameSuffix) {
        this.keyFieldName = keyFieldName;
        this.bucketedRegionNameSuffix = bucketedRegionNameSuffix;
    }

    public String getKeyFieldName() {
        return keyFieldName;
    }

    public void setKeyFieldName(String keyFieldName) {
        this.keyFieldName = keyFieldName;
    }

    public String getBucketedRegionNameSuffix() {
        return bucketedRegionNameSuffix;
    }

    public void setBucketedRegionNameSuffix(String bucketedRegionNameSuffix) {
        this.bucketedRegionNameSuffix = bucketedRegionNameSuffix;
    }

    @Override
    public PdxInstance load(LoaderHelper<K, PdxInstance> helper) throws CacheLoaderException {
        K key = helper.getKey();

        int hc = key.hashCode();
        int bucketNumber = Math.abs(hc % DatasetHelper.getHashBucketCount());

        String regionName = helper.getRegion().getName();
        String bucketedRegionName = regionName + bucketedRegionNameSuffix;

        LOG.debug("load: key={}, hc={}, bucketNumber={}, regionName={}, bucketedRegionName={}", key, hc, bucketNumber, regionName,
                bucketedRegionName);

        Region<Integer, List<PdxInstance>> bucketedRegion = RegionHelper.getRegion(bucketedRegionName);
        List<PdxInstance> list = bucketedRegion.get(bucketNumber, regionName);
        LOG.debug("load: key={}, list={}", key, list);

        PdxInstance inst = null;

        if (list != null && !list.isEmpty()) {
            for (int i = 0; inst == null && i < list.size(); ++i) {
                PdxInstance r = list.get(i);
                Object rk = r.getField(keyFieldName);

                if (key.equals(rk)) {
                    inst = r;
                }
            }
        } else {
            LOG.debug("load: list null or empty: key={}, hc={}, bucketNumber={}, regionName={}, bucketedRegionName={}", key, hc,
                    bucketNumber, regionName, bucketedRegionName);
        }

        LOG.debug("load: key={}, regionName={}, inst={}", key, regionName, inst);
        return inst;
    }

    @Override
    public void init(Properties props) {
        keyFieldName = props.getProperty("keyFieldName", keyFieldName);
        bucketedRegionNameSuffix = props.getProperty("bucketedRegionNameSuffix", bucketedRegionNameSuffix);
        LOG.info("init: keyFieldName, bucketedRegionNameSuffix", keyFieldName, bucketedRegionNameSuffix);
    }

    @Override
    public void close() {
    }

}
