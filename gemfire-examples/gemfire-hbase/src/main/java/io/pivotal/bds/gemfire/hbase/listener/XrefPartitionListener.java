package io.pivotal.bds.gemfire.hbase.listener;

import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.partition.PartitionListener;
import com.gemstone.gemfire.cache.partition.PartitionRegionHelper;
import com.gemstone.gemfire.pdx.PdxInstance;

import io.pivotal.bds.gemfire.util.DSLockingHashSet;
import io.pivotal.bds.gemfire.util.RegionHelper;

public class XrefPartitionListener implements PartitionListener, Declarable {

    private Region<?, ?> region;
    private String fieldName;
    private String xrefRegionName;

    private static final Logger LOG = LoggerFactory.getLogger(XrefPartitionListener.class);

    @Override
    public void init(Properties props) {
        xrefRegionName = props.getProperty("xrefRegionName");
        fieldName = props.getProperty("xrefRegionName");
        LOG.info("init: xrefRegionName={}, fieldName={}", xrefRegionName, fieldName);

        Assert.notNull(xrefRegionName, "Missing property 'xrefRegionName'");
        Assert.notNull(fieldName, "Missing property 'fieldName'");
    }

    @Override
    public void afterBucketCreated(int bucketId, Iterable<?> keys) {
        LOG.info("afterBucketCreated: region={}, bucketId={}", region.getName(), bucketId);
    }

    @Override
    public void afterBucketRemoved(int bucketId, Iterable<?> keys) {
        LOG.info("afterBucketRemoved: region={}, bucketId={}", region.getName(), bucketId);

        Region<Object, DSLockingHashSet<Object>> xrefRegion = RegionHelper.getRegion(xrefRegionName);

        for (Object key : keys) {
            if (LOG.isTraceEnabled()) {
                LOG.info("afterBucketRemoved: region={}, bucketId={}, key={}", region.getName(), bucketId, key);
            }

            PdxInstance inst = (PdxInstance) region.get(key);
            Object fieldValue = inst.getField(fieldName);

            if (fieldValue != null) {
                if (LOG.isTraceEnabled()) {
                    LOG.info("afterBucketRemoved: region={}, bucketId={}, key={}, fieldName={}, fieldValue={}", region.getName(),
                            bucketId, key, fieldName, fieldValue);
                }

                DSLockingHashSet<Object> set = xrefRegion.get(fieldValue);
                set.remove(key);
                xrefRegion.put(fieldValue, set);
            } else if (LOG.isTraceEnabled()) {
                LOG.info("afterBucketRemoved: field value is null: region={}, bucketId={}, key={}, fieldName={}", region.getName(),
                        bucketId, key, fieldName);
            }
        }
    }

    @Override
    public void afterPrimary(int bucketId) {
        LOG.info("afterPrimary: region={}, bucketId={}", region.getName(), bucketId);

        Region<Object, DSLockingHashSet<Object>> xrefRegion = RegionHelper.getRegion(xrefRegionName);
        Region<?, ?> pr = PartitionRegionHelper.getLocalPrimaryData(region);

        for (Map.Entry<?, ?> e : pr.entrySet()) {
            Object key = e.getKey();

            if (LOG.isTraceEnabled()) {
                LOG.info("afterPrimary: region={}, bucketId={}, key={}", region.getName(), bucketId, key);
            }

            PdxInstance inst = (PdxInstance) e.getValue();
            Object fieldValue = inst.getField(fieldName);

            if (fieldValue != null) {
                if (LOG.isTraceEnabled()) {
                    LOG.info("afterPrimary: region={}, bucketId={}, key={}, fieldName={}, fieldValue={}", region.getName(), bucketId,
                            key, fieldName, fieldValue);
                }

                DSLockingHashSet<Object> set = xrefRegion.get(fieldValue);
                set.add(key);
                xrefRegion.put(fieldValue, set);
            } else if (LOG.isTraceEnabled()) {
                LOG.info("afterPrimary: field value is null: region={}, bucketId={}, key={}, fieldName={}", region.getName(),
                        bucketId, key, fieldName);
            }
        }
    }

    @Override
    public void afterRegionCreate(Region<?, ?> region) {
        LOG.info("afterRegionCreate: region={}", region.getName());
        this.region = region;
    }

}
